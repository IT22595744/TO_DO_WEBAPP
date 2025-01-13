package com.jvlcode.todo.controller;

import com.jvlcode.todo.model.Task;
import com.jvlcode.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

  //import java.util.ArrayList;
//import java.util.List;


@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/hello-world")
    public String helloworld(){
        return "Hello World from JVL code";
    }

    @PostMapping("/api/tasks")
    public Task createTask(@RequestBody Task task){
//        List<String> users = new ArrayList<>();
//        users.add("Logesh");
//        users.add("Ramesh");
//        users.add("suresh");
//        return users;
//        System.out.println(task.getDescription()+" - "+task.isCompleted());

        taskRepository.save(task);
        return task;
    }

}
