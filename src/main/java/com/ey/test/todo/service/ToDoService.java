package com.ey.test.todo.service;

import com.ey.test.todo.entity.ToDoEntity;

import java.util.List;

public interface ToDoService {


    List<ToDoEntity> getToDoList();

    ToDoEntity save(ToDoEntity toDoEntity);

    void deleteById(Long id);
}
