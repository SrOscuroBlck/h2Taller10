package com.tallerdiez.gacp.Services;

import com.tallerdiez.gacp.Entities.TaskEntity;

import java.util.List;
import java.util.Optional;


public interface TaskService {
    List<TaskEntity> getTasks();
    Optional<TaskEntity> getTaskById(Long id);
    TaskEntity createTask(TaskEntity task);
    TaskEntity updateTask(Long id, TaskEntity task);
    void deleteTask(Long id);
}
