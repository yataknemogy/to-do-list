package com.example.todolist.Service;

import com.example.todolist.Model.Task;
import com.example.todolist.Repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskServiceUnitTest {

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void testCreateTask() {
        TaskService taskService = new TaskService(taskRepository);

        Task task = new Task();
        task.setTitle("Test Title");
        task.setDescription("Test Description");
        Date dateOfCreation = new Date();
        Date deadline = new Date();
        Task.TaskStatus status = Task.TaskStatus.NEW;

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task createdTask = taskService.createTask("Test Title", "Test Description", dateOfCreation, deadline, status);

        verify(taskRepository, times(1)).save(any(Task.class));
        assertEquals("Test Title", createdTask.getTitle());
        assertEquals("Test Description", createdTask.getDescription());
        assertEquals(dateOfCreation, createdTask.getDateOfCreation());
        assertEquals(deadline, createdTask.getDeadline());
        assertEquals(Task.TaskStatus.NEW, createdTask.getStatus());
    }
}
