package com.allstate.dtos;

import com.allstate.entities.Teacher;
import com.allstate.entities.Klass;

import java.util.List;

/**
 * Created by localadmin on 2/10/17.
 */
public class RegisterDto {
    public List<String> emails;
    public Teacher teacher;
    public Klass klass;
}
