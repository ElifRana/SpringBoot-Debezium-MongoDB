package com.example.springbootdebeziummongodb.repository;

import com.example.springbootdebeziummongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
