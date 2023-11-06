package br.com.checkpoint.checkpointspring.dto;

public record AuthRequest(

        String username,

        String password
) {
}
