package com.allstate.controller;

import com.allstate.dtos.RegisterDto;
import com.allstate.services.RegistrationService;
import com.allstate.entities.Klass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by localadmin on 2/10/17.
 */
@CrossOrigin
@RestController
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public void setRegistrationService(RegistrationService registrationService)
    {
        this.registrationService = registrationService;
    }

    @RequestMapping(value ="/registration/enroll", method= RequestMethod.POST)
    public Klass enroll(@RequestBody RegisterDto registerDto)
    {
        return this.registrationService.enroll(registerDto.emails,registerDto.teacher,registerDto.klass);
    }
}
