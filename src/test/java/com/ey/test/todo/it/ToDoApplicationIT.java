package com.ey.test.todo.it;

import com.ey.test.todo.ToDoApplication;
import com.ey.test.todo.entity.ToDoEntity;
import com.ey.test.todo.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        classes = ToDoApplication.class
)
@TestPropertySource(
        locations = "classpath:application-test.properties"
)
public class ToDoApplicationIT {

    @Autowired
    ToDoService toDoService;

    @Test
    public void testAddToDoList() {
        ToDoEntity data = createDummyData();
        toDoService.save(data);
        assertEquals(1, toDoService.getToDoList().size());
    }

    private ToDoEntity createDummyData() {
        return new ToDoEntity(1L, "Test", new Date(), null, false);
    }
}
