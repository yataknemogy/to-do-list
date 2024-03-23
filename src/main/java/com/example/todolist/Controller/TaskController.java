package com.example.todolist.Controller;

import com.example.todolist.Model.Task;
import com.example.todolist.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks"; // Это имя HTML файла без расширения
    }

    @GetMapping("/{id}")
    public String getTaskById(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id).orElseThrow(() -> new RuntimeException("Task not found for " + id));
        model.addAttribute("task", task);
        return "task"; // Это имя HTML файла без расширения
    }

    @PostMapping("/addtask")
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task updateTask) {
        Task updatedTask = taskService.updateTask(id, updateTask);
        return ResponseEntity.ok(updatedTask);
    }
}
