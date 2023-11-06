package br.com.checkpoint.checkpointspring.model;

import br.com.checkpoint.checkpointspring.dto.CreateTaskDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private Boolean status;

    private Date dueDate;

    private Boolean isActive;



    public Task() {}


    public Task(CreateTaskDto data) {
        this.title = data.title();
        this.description = data.description();
        this.dueDate = data.dueDate();
        this.status = false;
        this.isActive = true;
    }




}
