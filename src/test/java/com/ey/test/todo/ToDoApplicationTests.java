package com.ey.test.todo;

import com.ey.test.todo.entity.ToDoEntity;
import com.ey.test.todo.exception.InvalidFieldException;
import com.ey.test.todo.repo.ToDoRepo;
import com.ey.test.todo.service.ToDoService;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(
		classes = ToDoApplication.class
)
class ToDoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ToDoService toDoService;

	@MockBean
	ToDoRepo toDoRepo;

	@Test
	public void testGetToDoList() {
		when(toDoRepo.findAll()).thenReturn(ImmutableList.of(createDummyData()));
		assertEquals(1, toDoService.getToDoList().size());
	}

	@Test
	public void testAddToDoList_InvalidData() {
		ToDoEntity data = invalidData();
		when(toDoRepo.save(data)).thenReturn(data);

		Assertions.assertThrows(InvalidFieldException.class, () -> {
			toDoService.save(data);
		});
	}

	@Test
	public void testAddToDoList() {
		ToDoEntity data = createDummyData();
		when(toDoRepo.save(data)).thenReturn(data);
		assertEquals(data, toDoService.save(data));
	}

	@Test
	public void testUpdateToDoList() {
		ToDoEntity data = createDummyData();
		when(toDoRepo.save(data)).thenReturn(data);
		assertEquals(data, toDoService.save(data));
	}

	@Test
	public void testDeleteToDoList() {
		ToDoEntity data = createDummyData();
		toDoRepo.deleteById(data.getId());
		verify(toDoRepo, times(1)).deleteById(1L);
	}

	private ToDoEntity createDummyData() {
		return new ToDoEntity(1L, "Test", new Date(), null, false);
	}

	private ToDoEntity invalidData() {
		return new ToDoEntity(1L, null, new Date(), null, false);
	}

}
