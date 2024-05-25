package com.tallerdiez.gacp.Controllers;

import com.tallerdiez.gacp.Entities.TaskEntity;
import com.tallerdiez.gacp.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<TaskEntity> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable Long id) {
        Optional<TaskEntity> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskEntity task) {
        TaskEntity newTask = taskService.createTask(task);
        return ResponseEntity.ok(newTask);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable Long id, @RequestBody TaskEntity task) {
        TaskEntity updatedTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}