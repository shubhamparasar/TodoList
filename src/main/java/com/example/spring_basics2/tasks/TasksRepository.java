package com.example.spring_basics2.tasks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<TaskEntity,Integer> {
}
