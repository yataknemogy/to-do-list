package com.example.todolist;

import com.example.todolist.Model.Task;
import com.example.todolist.Repository.TaskRepository;
import com.example.todolist.Service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskService.class)
public class TaskServiceUnitTest {

    @Autowired
    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void testCreateTask() {
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
        System.out.println("Test successfully executed: task creation was successful.");
    }
}
