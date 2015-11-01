package com.sjsu.healthcare.service;

import com.sjsu.healthcare.model.Registration;
import com.sjsu.healthcare.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Aishwarya on 10/29/2015.
 */
@Controller
public class RegistrationService {
    @Autowired
    RegistrationRepository registrationRepository;

    //Save Registration
    @RequestMapping(value = "api/Registrations", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Registration> Registrationpost(@RequestBody Registration registration){
    	//System.out.println(registration.getId()+registration.getUsername()+registration.getPassword());
        registrationRepository.save(new Registration(registration.getId(),registration.getUsername(),registration.getPassword()));
        return new ResponseEntity<Registration> (HttpStatus.CREATED);

    }
    //View Registration
    @RequestMapping(value = "api/Registrations/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity RegistrationGet(@PathVariable("id") String id) {
    	System.out.println("Inside get"+id);
        Registration p = registrationRepository.findById(id);
        System.out.println("username"+p.getUsername());
        return new ResponseEntity(p, HttpStatus.OK);
    }


    //Update Registration
    @RequestMapping(value = "api/Registration/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity RegistrationPut(@PathVariable("id") String id, @RequestBody Registration p) {
        Registration registration;
        try {
            registration = registrationRepository.findById(id);
        } catch (Exception e){
            return new ResponseEntity("Registration Id requested not found!", HttpStatus.NOT_FOUND);
        }
        if (p.getUsername() != null) {
            registration.setUsername(p.getUsername());
        }

        if (p.getPassword() != null) {
            registration.setPassword(p.getUsername());
        }



        registrationRepository.save(registration);
        return new ResponseEntity(registration, HttpStatus.OK);
    }
}
