package com.sjsu.healthcare.service;

import com.sjsu.healthcare.model.Doctor;
import com.sjsu.healthcare.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Created by Aishwarya on 10/29/2015.
 */
@Controller
public class DoctorService {

@Autowired
DoctorRepository doctorRepository;

//Save Doctor
@RequestMapping(value = "api/doctors", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
public ResponseEntity<Doctor> Doctorpost(@RequestBody Doctor doctor){

    doctorRepository.save(doctor);
    return new ResponseEntity<Doctor>(doctor,HttpStatus.CREATED);

}
    //View Doctor
    @RequestMapping(value = "api/doctors/{id}", method = RequestMethod.GET)
    public ResponseEntity DoctorGet(@PathVariable("id") String id) {
        Doctor p = doctorRepository.findById(id);
        return new ResponseEntity(p, HttpStatus.OK);
    }

    //Get All Doctors
    @RequestMapping(value = "api/allDoctors", method = RequestMethod.GET)
    public List<Doctor> getDoctors(){
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors;
    }

    //Update Doctor
    @RequestMapping(value = "api/doctor/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity doctorPut(@PathVariable("id") String id, @RequestBody Doctor d) {
        Doctor doctor;
        try {
            doctor = doctorRepository.findById(id);
        } catch (Exception e){
            return new ResponseEntity("Doctor Id requested not found!", HttpStatus.NOT_FOUND);
        }
        if (d.getName() != null) {
            doctor.setName(d.getName());
        }

        if (d.getEmail() != null) {
            doctor.setEmail(d.getEmail());
        }


        if (d.getImageurl() != null) {
            doctor.setImageurl(d.getImageurl());
        }

        if (d.getSpecialization() != null) {
            doctor.setSpecialization(d.getSpecialization());
        }



        doctorRepository.save(doctor);
        return new ResponseEntity(doctor, HttpStatus.OK);
    }
}








