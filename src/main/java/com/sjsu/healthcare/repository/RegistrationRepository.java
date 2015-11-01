package com.sjsu.healthcare.repository;

import com.sjsu.healthcare.model.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Aishwarya on 10/29/2015.
 */
public interface RegistrationRepository extends MongoRepository<Registration, String> {

    public Registration findById(String Id);

}