package com.ey.test.todo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ApiModel(description = "To Do List Model")
public class ToDoEntity implements Serializable {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "Id of the To Do List", name = "id", required = true, value = "123")
    private Long id;
    @NotBlank
    @ApiModelProperty(notes = "Title of the To Do List", name = "toDoTitle", required = true, value = "Wash the car.")
    private String toDoTitle;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @ApiModelProperty(notes = "Created time stamp", name = "createdOn", required = true, value = "2021-09-20T15:23:48.997+00:00 ")
    private Date createdOn;
    @ApiModelProperty(notes = "Updated time stamp", name = "updatedOn", required = true, value = "2021-09-20T15:23:48.997+00:00")
    private Date updatedOn;
    @ApiModelProperty(notes = "Id of the To Do List", name = "isDone", required = true, value = "false")
    private boolean isDone;

    @PrePersist
    private void onCreate() {
        createdOn = new Date();
    }
}
