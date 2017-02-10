package com.allstate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by thomas.fowler on 2/9/17.
 */
@Entity
@Table(name="students")
@Data
public class Student {
//    CREATE TABLE `students` (
//      `id`       INT           NOT NULL  AUTO_INCREMENT,
//      `version`  INT           NOT NULL  DEFAULT 0,
//      `email`    VARCHAR(255)  NOT NULL,
//      `created`  TIMESTAMP     NOT NULL  DEFAULT NOW(),
//      `modified` TIMESTAMP     NOT NULL  DEFAULT NOW(),
//    PRIMARY KEY (`id`));
    @Id
    @GeneratedValue
    private int id;

    private String email;

    @Version
    private int version;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Registration> registrations;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<Klass> klasses;

    public Student () {}

    public Student(String email) {
        this.email = email;
    }
}
