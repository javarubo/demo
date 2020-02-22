package com.example.demo.controller;

import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "Sign-On")
    public ModelAndView signOn(@RequestParam String username,
                               @RequestParam String name,
                               @RequestParam String password,
                               @RequestParam String surname,
                               @RequestParam int age) {
        try {

            User user = new User();
            user.setUsername(username);
            user.setName(name);
            user.setPassword(password);
            user.setSurname(surname);

            userService.add(user);


            return new ModelAndView("index", "massage", "registration succesful");

        } catch (DuplicateDataException ex) {
            return new ModelAndView("registr", "massage", ex.getMessage());
        } catch (Throwable throwable) {

            return new ModelAndView("registr", "massage", "unexcepted error");
        }


    }


}
