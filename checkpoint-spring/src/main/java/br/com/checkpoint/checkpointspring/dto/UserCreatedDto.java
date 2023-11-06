package br.com.checkpoint.checkpointspring.dto;

import br.com.checkpoint.checkpointspring.model.UserInfo;
import br.com.checkpoint.checkpointspring.model.UserRole;

public record UserCreatedDto(Long id, String username, UserRole roles) {

    public UserCreatedDto (UserInfo user) {
        this (user.getId(), user.getUsername(), user.getRole());
    }

}
