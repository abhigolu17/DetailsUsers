package com.users.details.MongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.users.details.Model.User;


@Repository
public interface UserRepository extends MongoRepository<User, Integer>{

}
