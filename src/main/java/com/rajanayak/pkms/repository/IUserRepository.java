package com.rajanayak.pkms.repository;

import com.rajanayak.pkms.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface IUserRepository extends MongoRepository<User, ObjectId> {
    public Optional<User> findUserByUsername(String userName);
    public Optional<User> findByEmail(String email);

    @Query("{ 'username': ?0, 'email': ?1 }")
    public Optional<User> findByUserNameAndEmail(String name, String email);
}
