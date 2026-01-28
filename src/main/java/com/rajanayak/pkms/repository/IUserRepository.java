package com.rajanayak.pkms.repository;

import com.rajanayak.pkms.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, ObjectId> {
}
