package am.itspace.studentmanagement.controller;

import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/")
    public String homePage(){
        return "index";
    }

}
