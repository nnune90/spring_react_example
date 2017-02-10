package com.allstate.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by thomas.fowler on 2/9/17.
 */
@Entity
@Table(name = "registrations")
@Data
public class Registration {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "klass_id")
    private Klass klass;

    public Registration () {}

    public Registration(Student student, Klass klass) {
        this.student = student;
        this.klass = klass;
    }
}
