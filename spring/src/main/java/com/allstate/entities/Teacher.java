package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by thomas.fowler on 2/9/17.
 */
@Entity
@Data
@Table(name = "teachers")
public class Teacher {
//    CREATE TABLE `teachers` (
//      `id`         INT            NOT NULL  AUTO_INCREMENT,
//      `version`    INT            NOT NULL  DEFAULT 0,
//      `name`       VARCHAR(255)   NOT NULL,
//      `age`        INT            NOT NULL,
//      `gender`     ENUM('MALE', 'FEMALE') NOT NULL,
//      `created`    TIMESTAMP      NOT NULL  DEFAULT NOW(),
//      `modified`   TIMESTAMP      NOT NULL  DEFAULT NOW(),
//    PRIMARY KEY (`id`));

    @Id
    @GeneratedValue
    private int id;

    @Version
    @NotNull
    private int version;

    @NotNull
    @Size(min = 1)
    private String name;

    @NotNull
    private int age;

    @Column(columnDefinition = "ENUM('FEMALE', 'MALE')")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<Klass> klasses;

    public Teacher () {}

    public Teacher (String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
