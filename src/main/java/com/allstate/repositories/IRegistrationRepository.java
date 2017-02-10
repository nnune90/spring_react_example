package com.allstate.repositories;

import com.allstate.entities.Registration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by thomas.fowler on 2/9/17.
 */
public interface IRegistrationRepository extends CrudRepository<Registration, Integer>{
    @Query("SELECT r from Registration r JOIN r.klass k JOIN r.student s WHERE k.id = :kid AND s.id = :sid")
    public Registration findByKlassAndStudent(@Param("kid") int kid, @Param("sid") int sid);
}
