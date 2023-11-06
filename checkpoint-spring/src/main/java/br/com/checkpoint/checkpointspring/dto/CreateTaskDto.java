package br.com.checkpoint.checkpointspring.dto;

import java.util.Date;

public record CreateTaskDto(

        String title,
        String description,
        Date dueDate

) {
}
