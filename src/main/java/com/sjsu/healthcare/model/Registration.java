package com.sjsu.healthcare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Aishwarya on 10/29/2015.
 */
@Document(collection="registration") 
public class Registration {
	@Id
	String id;
    String username;
    String password;

    
    public Registration() {
		
	}
    

	public Registration(String id, String username, String password) {
		
		this.id = id;
		this.username = username;
		this.password = password;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
