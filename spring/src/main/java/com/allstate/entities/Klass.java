package com.allstate.entities;

import com.allstate.enums.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by thomas.fowler on 2/9/17.
 */
@Entity
@Table(name="klasses")
@Data
public class Klass {
//    CREATE TABLE `klasses` (
//     `id`         INT            NOT NULL  AUTO_INCREMENT,
//     `version`    INT            NOT NULL  DEFAULT 0,
//     `name`       VARCHAR(255)   NOT NULL,
//     `semester`   DATE           NOT NULL,
//     `credits`    INT            NOT NULL DEFAULT 1,
//     `department` ENUM('SCIENCE', 'ENGINEERING', 'LITERATURE', 'PHILOSOPHY') NOT NULL,
//     `fee`        DECIMAL(12, 2) NOT NULL,
//     `created`    TIMESTAMP      NOT NULL  DEFAULT NOW(),
//     `modified`   TIMESTAMP      NOT NULL  DEFAULT NOW(),
//     `teacher_id` INT            NOT NULL
// PRIMARY KEY (`id`));

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @NotNull
    @Size(min = 1)
    private String name;

    @NotNull
    private Date semester;

    @NotNull
    @Min(value = 1)
    private int credits;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Department department;

    @NotNull
    @DecimalMin(value = "0")
    private double fee;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "registrations",
        joinColumns = @JoinColumn(name = "klass_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    @JsonIgnore
    private List<Student> students;

    @OneToMany(mappedBy = "klass")
    @JsonIgnore
    private List<Registration> registrations;

    public Klass() {}

    public Klass(String name, Date semester, int credits, Department department, Double fee) {
        this.name = name;
        this.semester = semester;
        this.credits = credits;
        this.department = department;
        this.fee = fee;
    }
}
