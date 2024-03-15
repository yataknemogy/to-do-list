package com.example.todolist;

import com.example.todolist.Service.TaskServiceUnitTest;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootApplication
@ComponentScan("com.example.todolist")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaskServiceUnitTest.class)
public class ToDoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoListApplication.class, args);
    }

}
