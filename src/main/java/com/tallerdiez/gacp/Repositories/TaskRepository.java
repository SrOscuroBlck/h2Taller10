package com.tallerdiez.gacp.Repositories;


import com.tallerdiez.gacp.Entities.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {

}
