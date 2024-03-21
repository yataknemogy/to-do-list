package com.example.todolist.Controller;

import com.example.todolist.Model.Task;
import com.example.todolist.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @PostMapping("/addtask")
    public Task createTask(@RequestBody Task task){
            return taskService.saveTask(task);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<?>updateTask(@PathVariable Long id, @RequestBody Task updateTask){
        Task updatedTask = taskService.updateTask(id, updateTask);
        return ResponseEntity.ok(updatedTask);
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id).orElseThrow(()->new RuntimeException("Task not found for " + id));
    }
}
