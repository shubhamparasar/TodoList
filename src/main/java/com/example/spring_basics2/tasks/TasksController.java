package com.example.spring_basics2.tasks;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tasks")
@RestController()
public class TasksController {

    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/")
    List<TaskEntity> getAllTodos(){
        return tasksService.getAllTasks();
    }

    @PostMapping(value = "/",consumes = "application/json")
    TaskEntity addNewTodos(@RequestBody TaskEntity taskEntity){
         var task=tasksService.addNewTask(taskEntity.task);
         return task;
    }

    @GetMapping("/{id}")
    TaskEntity getTodoById(@PathVariable Integer id){
        return tasksService.getTaskById(id);
    }

    @PutMapping("/{id}/done")
    TaskEntity setTodoDone(@PathVariable Integer id){
        return tasksService.setTaskDone(id,true);
    }

    @DeleteMapping("/{id}/done")
    Boolean deleteTodoDone(@PathVariable Integer id){
        return tasksService.deleteTask(id);
    }
}
