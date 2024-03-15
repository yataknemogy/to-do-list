package com.example.todolist.Service;

import com.example.todolist.Model.Task;
import com.example.todolist.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String title, String description, Date dateOfCreation, Date deadline, Task.TaskStatus status) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setDateOfCreation(dateOfCreation);
        task.setDeadline(deadline);
        task.setStatus(status);
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, String title, String description, Date dateOfCreation, Date deadline, Task.TaskStatus status){
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found"));
        existingTask.setTitle(title);
        existingTask.setDescription(description);
        existingTask.setDeadline(deadline);
        existingTask.setStatus(status);
        return taskRepository.save(existingTask);
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public List<Task>getTasktsSortebByStatus(){
        return taskRepository.findAllByOrderByStatusAsc();
    }
}
