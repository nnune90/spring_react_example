package com.allstate.controller;

import com.allstate.entities.Student;
import com.allstate.services.KlassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class KlassController {
    private KlassService klassService;
    @Autowired
    public void setKlassService(KlassService klassService)
    {
        this.klassService=klassService;
    }
    @RequestMapping(value="/klasses/{id}", method = RequestMethod.GET)
    public List<Student> register(@PathVariable int id){
        return this.klassService.findById(id).getStudents();
    }
}
