package com.ey.test.todo.service.impl;

import com.ey.test.todo.entity.ToDoEntity;
import com.ey.test.todo.exception.InvalidFieldException;
import com.ey.test.todo.repo.ToDoRepo;
import com.ey.test.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    ToDoRepo toDoRepo;

    @Override
    public List<ToDoEntity> getToDoList() {
        return toDoRepo.findAll();
    }

    @Override
    public ToDoEntity save(ToDoEntity toDoEntity) {
        performFieldValidation(toDoEntity);
        return toDoRepo.save(toDoEntity);
    }

    @Override
    public void deleteById(Long id) {
        try{
            toDoRepo.deleteById(id);
        }catch (EmptyResultDataAccessException ee){
            throw new InvalidFieldException("id " +id+" doesn't exist.");
        }
    }

    private void performFieldValidation(ToDoEntity toDoEntity){
        if (null == toDoEntity.getToDoTitle()) {
            throw new InvalidFieldException("Title can't be blank");
        } else if (null == toDoEntity.getCreatedOn()) {
            throw new InvalidFieldException("Create Date can't be blank");
        }
    }
}
