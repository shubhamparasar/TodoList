package com.example.spring_basics2.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TasksService {
    ArrayList<TaskEntity> taskList= new ArrayList<>();
    TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository){
        this.tasksRepository=tasksRepository;
    }

    TaskEntity addNewTask(String taskname){

        return tasksRepository.save(new TaskEntity(taskname,false));
    }

    List<TaskEntity> getAllTasks(){

        return tasksRepository.findAll();
    }

    TaskEntity getTaskById(Integer index){

        return tasksRepository.getById(index);
    }

    TaskEntity setTaskDone(Integer index,Boolean done){
        var task= tasksRepository.getById(index);
        task.setDone(done);
        return tasksRepository.save(task);
    }

    Boolean deleteTask(int index){
        var task= tasksRepository.getById(index);
        tasksRepository.delete(task);
        return true;
    }

}
