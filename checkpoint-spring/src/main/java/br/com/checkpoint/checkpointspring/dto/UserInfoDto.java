package br.com.checkpoint.checkpointspring.dto;

import br.com.checkpoint.checkpointspring.model.UserRole;

public record UserInfoDto(

        String username,
        String password,
        UserRole roles
) {
}
