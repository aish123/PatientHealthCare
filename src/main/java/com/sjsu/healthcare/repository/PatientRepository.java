package com.sjsu.healthcare.repository;

import com.sjsu.healthcare.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Aishwarya on 10/29/2015.
 */
@Repository

public interface PatientRepository extends MongoRepository<Patient, String> {

    public Patient findById(String Id);

}