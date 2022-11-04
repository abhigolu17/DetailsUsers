package com.users.details.MongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.users.details.Model.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String>{

	Admin findByName(String name);
	
}
