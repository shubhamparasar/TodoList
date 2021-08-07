package com.example.spring_basics2.tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Setter
@Getter
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column()
    @JsonProperty("id")
    private Integer id;

    public TaskEntity(String task, Boolean done) {
        this.task = task;
        this.done = done;
    }

    @JsonProperty("name")
    @Column(nullable = false)
    String task;

    @Column()
    @JsonProperty("done")
    Boolean done;
}
