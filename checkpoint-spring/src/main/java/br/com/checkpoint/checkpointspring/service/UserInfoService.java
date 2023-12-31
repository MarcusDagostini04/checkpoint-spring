package br.com.checkpoint.checkpointspring.service;

import br.com.checkpoint.checkpointspring.dto.UserCreatedDto;
import br.com.checkpoint.checkpointspring.model.UserInfo;
import br.com.checkpoint.checkpointspring.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByUsername(username);
        return userInfo
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    public void addUser (UserInfo userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
    }

    public Page<UserCreatedDto> listAll(Pageable pageable) {
        return repository.findAll(pageable).map(UserCreatedDto::new);
    }
}
