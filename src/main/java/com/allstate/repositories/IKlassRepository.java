package com.allstate.repositories;

import com.allstate.entities.Klass;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by thomas.fowler on 2/9/17.
 */
public interface IKlassRepository extends CrudRepository<Klass, Integer> {
    public Klass findByName(String name);
}
