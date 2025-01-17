package com.jvlcode.todo.controller;

import com.jvlcode.todo.model.Task;
import com.jvlcode.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import java.util.ArrayList;
//import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/hello-world")
    public String helloworld(){
        return "Hello World from JVL code";
    }

//    @PostMapping("/api/tasks")
    @PostMapping
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

//    @GetMapping("/api/tasks")
    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskRepository.deleteById(id);
    }

}
