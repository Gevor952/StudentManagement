package am.itspace.studentmanagement.controller;

import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.entity.UserTyp;
import am.itspace.studentmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {


    private final UserService userService;

    @GetMapping
    public String teachers(ModelMap modelMap) {
        List<User> users = userService.findByUserTyp(UserTyp.TEACHER);
        modelMap.addAttribute("users", users);
        return "teachers";
    }


    @GetMapping(value = "/add")
    public String addStudent() {
        return "add_teacher";
    }

    @PostMapping(value = "/add")
    public String addStudent(@ModelAttribute("user") User user) {
        user.setUserTyp(UserTyp.TEACHER);
        userService.save(user);
        return "redirect:/teacher";
    }


    @GetMapping(value = "/delete")
    public String deleteStudent(@RequestParam("id") int id) {
        userService.deleteById(id);
        return "redirect:/teacher";
    }


    @GetMapping(value = "/edit")
    public String editStudent(@RequestParam("id") int id, ModelMap modelMap) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            modelMap.addAttribute("user", user.get());
            return "edit_teacher";
        }
       return "redirect:/teacher";
    }

    @PostMapping(value = "/edit")
    public String editStudent(@ModelAttribute("user") User user) {
        user.setUserTyp(UserTyp.TEACHER);
        userService.save(user);
        return "redirect:/teacher";
    }

}
