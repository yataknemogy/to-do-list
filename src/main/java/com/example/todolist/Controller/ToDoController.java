package com.example.todolist.Controller;

import com.example.todolist.Service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@Controller
public class ToDoController {

    private final TaskService taskService;

    public ToDoController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/todo")
    public String tasks(Model model){
        model.addAttribute("todo", taskService.getAllTasks());
        return "todo";
    }
}
