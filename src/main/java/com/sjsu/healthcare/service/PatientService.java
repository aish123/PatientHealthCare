package com.sjsu.healthcare.service;

import com.sjsu.healthcare.model.Patient;

import com.sjsu.healthcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Aishwarya on 10/29/2015.
 */

@Controller
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    //Save Patient
    @RequestMapping(value = "api/Patients", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity Patientpost(@RequestBody Patient patient){

        patientRepository.save(patient);
        return new ResponseEntity(HttpStatus.CREATED);

    }
    //View Patient
    @RequestMapping(value = "api/Patients/{id}", method = RequestMethod.GET)
    public ResponseEntity PatientGet(@PathVariable("id") String id) {
        Patient p = patientRepository.findById(id);
        return new ResponseEntity(p, HttpStatus.OK);
    }

    //Get All Patients
    @RequestMapping(value = "api/allPatients", method = RequestMethod.GET)
    public List<Patient> getPatients(){
        List<Patient> Patients = patientRepository.findAll();
        return Patients;
    }

    //Update Patient
    @RequestMapping(value = "api/Patient/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity PatientPut(@PathVariable("id") String id, @RequestBody Patient p) {
        Patient patient;
        try {
            patient = patientRepository.findById(id);
        } catch (Exception e){
            return new ResponseEntity("Patient Id requested not found!", HttpStatus.NOT_FOUND);
        }
        if (p != null) {
            patient.setName(p.getName());
        }

        if (p.getEmail() != null) {
            patient.setEmail(p.getEmail());
        }


        if (p.getDisease() != null) {
            patient.setDisease(p.getDisease());
        }

        patientRepository.save(patient);
        return new ResponseEntity(patient, HttpStatus.OK);
    }

}
