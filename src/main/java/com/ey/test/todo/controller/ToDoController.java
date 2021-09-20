package com.ey.test.todo.controller;

import com.ey.test.todo.entity.ToDoEntity;
import com.ey.test.todo.service.ToDoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@ApiOperation(value = "/todo", tags = "ToDo Controller")
@RestController
@RequestMapping(value = "/todo")
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @ApiOperation(value = "Get all the To Do list." , response = Iterable.class)
    @GetMapping(value = "/getToDoList")
    public List<ToDoEntity> getToDoList() {
        return toDoService.getToDoList();
    }

    @PostMapping(value = "/addToDoDetail")
    @ApiOperation(value = "Add an item to the To Do list." , response = ToDoEntity.class)
    public ToDoEntity addToDoDetail(@RequestBody ToDoEntity toDoEntity) {
        return toDoService.save(toDoEntity);
    }

    @ApiOperation(value = "Update an item of the To Do list." , response = ToDoEntity.class)
    @PutMapping(value = "/updateToDoDetail")
    public ToDoEntity updateToDoDetail(@RequestBody ToDoEntity toDoEntity) {
        if (null == toDoEntity.getUpdatedOn()) {
            toDoEntity.setUpdatedOn(new Date());
        }
        return toDoService.save(toDoEntity);
    }

    @ApiOperation(value = "Delete an item from the To Do list." , response = ToDoEntity.class)
    @DeleteMapping(value = "/deleteToDoDetail/{id}")
    public void deleteToDoDetail(@PathVariable Long id) {
        toDoService.deleteById(id);
    }
}
