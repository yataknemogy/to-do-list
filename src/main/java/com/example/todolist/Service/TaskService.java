package com.example.todolist.Service;

import com.example.todolist.Model.Task;
import com.example.todolist.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task){
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found"));
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDeadline(task.getDeadline());
        existingTask.setStatus(task.getStatus());
        return taskRepository.save(existingTask);
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public List<Task>getTasksSortedByStatus(){
        return taskRepository.findAllByOrderByStatusAsc();
    }
    public Optional<Task>getTaskById(Long id){
        return taskRepository.findById(id);
    }
}
