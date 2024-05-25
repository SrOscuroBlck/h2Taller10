package com.tallerdiez.gacp.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Data
public class TaskEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer status;

    @Column(name = "creation_date")
    private Date creationDate;
}
