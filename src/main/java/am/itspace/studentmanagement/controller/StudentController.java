package am.itspace.studentmanagement.controller;

import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.entity.UserTyp;
import am.itspace.studentmanagement.repository.LessonRepository;
import am.itspace.studentmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping( "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    LessonRepository lessonRepository;

    @GetMapping(value = "/students")
    public String students(ModelMap modelMap) {
        List<User> users = userRepository.findByUserTyp(UserTyp.STUDENT);
        modelMap.addAttribute("users", users);
        return "students";
    }

    @GetMapping(value = "/students/add")
    public String addStudent(ModelMap modelMap) {
        return "add_student";
    }

}
