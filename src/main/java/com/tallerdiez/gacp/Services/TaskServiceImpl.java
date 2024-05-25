package com.tallerdiez.gacp.Services;

import com.tallerdiez.gacp.Entities.TaskEntity;
import com.tallerdiez.gacp.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskEntity> getTasks() {
        return (List<TaskEntity>) taskRepository.findAll();
    }

    @Override
    public TaskEntity createTask(TaskEntity task) {
        task.setCreationDate(new java.util.Date());
        return taskRepository.save(task);
    }

    @Override
    public TaskEntity updateTask(Long id, TaskEntity task) {
        TaskEntity taskToUpdate = taskRepository.findById(id).orElse(null);
        if (taskToUpdate != null) {
            if (task.getDescription() != null) {
                taskToUpdate.setDescription(task.getDescription());
            }
            if (task.getStatus() != null) {
                taskToUpdate.setStatus(task.getStatus());
            }
            if (task.getCreationDate() != null) {
                taskToUpdate.setCreationDate(task.getCreationDate());
            }
            return taskRepository.save(taskToUpdate);
        }
        return null;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Optional<TaskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
}

