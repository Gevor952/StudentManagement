package am.itspace.studentmanagement.controller;

import am.itspace.studentmanagement.entity.Lesson;
import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.entity.UserTyp;
import am.itspace.studentmanagement.service.LessonService;
import am.itspace.studentmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping( "/students")
@RequiredArgsConstructor
public class StudentController {

    private final UserService userService;
    private final LessonService lessonService;

    @GetMapping
    public String students(ModelMap modelMap) {
        List<User> users = userService.findByUserTyp(UserTyp.STUDENT);
        System.out.println(users);
        modelMap.addAttribute("users", users);
        return "students";
    }

    @GetMapping(value = "/add")
    public String addStudent(ModelMap modelMap) {
        List<Lesson> lessons = lessonService.findAll();
        modelMap.addAttribute("lessons", lessons);
        return "add_student";
    }

    @PostMapping(value = "/add")
    public String addStudent(@ModelAttribute("user") User user) {
        user.setUserTyp(UserTyp.STUDENT);
        userService.save(user);
        return "redirect:/students";
    }


    @GetMapping(value = "/delete")
    public String deleteStudent(@RequestParam("id") int id) {
        userService.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping(value = "/edit")
    public String editStudent(@RequestParam("id") int id, ModelMap modelMap) {
        Optional<User> user = userService.findById(id);

        if (user.isPresent()) {
            List<Lesson> lessons = lessonService.findAll();
            modelMap.addAttribute("lessons", lessons);
            modelMap.addAttribute("user", user.get());
            return "edit_student";
        }
        return "redirect:/students";
    }

    @PostMapping(value = "/edit")
    public String editStudent(@ModelAttribute("user") User user) {
        user.setUserTyp(UserTyp.STUDENT);
        userService.save(user);
        return "redirect:/students";
    }

}
