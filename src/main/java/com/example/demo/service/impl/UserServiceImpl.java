package com.example.demo.service.impl;

import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.Generator;
import com.example.demo.util.MailSenderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MailSenderClient mailSenderClient;


    public void add(User user) throws DuplicateDataException {

        boolean exists = userRepository.existsByUsername(user.getUsername());
        if (exists) {
            throw new DuplicateDataException("user.by.username.exist");
        }
        user.setStatus(-1);
        user.setCode(Generator.randomString(5));
        userRepository.save(user);
        mailSenderClient.send("username","verification",user.getCode());
    }
}


