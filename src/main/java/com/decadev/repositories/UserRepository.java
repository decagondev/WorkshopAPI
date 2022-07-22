package com.decadev.repositories;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.decadev.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private DynamoDBMapper mapper;

    // Create
    public User save(User user) {
        mapper.save(user);
        return user;
    }

    // Read
    public User findById(String id) {
        return mapper.load(User.class, id);
    }

    public List<User> findAll() {
        return mapper.scan(User.class, new DynamoDBScanExpression());
    }

    // Update
    public String update(String id, User user) {
        mapper.save(user, new DynamoDBSaveExpression()
                .withExpectedEntry("id",
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(id)
                        )));

        return "Successfully updated User " + id;
    }

    // Delete
    public String delete(String id) {
        User user = mapper.load(User.class, id);
        mapper.delete(user);
        return "Successfully deleted User: " + id;
    }
}
