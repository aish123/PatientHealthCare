package com.sjsu.healthcare.repository;

import com.sjsu.healthcare.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Aishwarya on 10/29/2015.
 */
public interface DoctorRepository extends MongoRepository<Doctor, String> {

        public Doctor findById(String Id);

}
