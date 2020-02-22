package com.example.demo.service;

import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;



public interface UserService {
    void add(User user) throws DuplicateDataException;
}
