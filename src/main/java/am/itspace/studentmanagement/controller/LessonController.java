package am.itspace.studentmanagement.controller;

import am.itspace.studentmanagement.entity.Lesson;
import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.service.LessonService;
import am.itspace.studentmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;
    private final UserService userService;

    @GetMapping
    public String teachers(ModelMap modelMap) {
        List<Lesson> lessons = lessonService.findAll();
        modelMap.addAttribute("lessons", lessons);
        return "lesson";
    }

    @GetMapping(value = "/add")
    public String addStudent(ModelMap modelMap) {
        List<User> users = userService.findAll();
        modelMap.addAttribute("users", users);
        return "add_lesson";
    }

    @PostMapping(value = "/add")
    public String addLesson(@ModelAttribute("lesson") Lesson lesson, @RequestParam("user") User user) {
        lesson.setTeacher(user);
        lessonService.save(lesson);
        return "redirect:/lesson";
    }

    @GetMapping(value = "/delete")
    public String deleteLesson(@RequestParam int lessonId) {
        lessonService.deleteById(lessonId);
        return "redirect:/lesson";
    }

    @GetMapping(value = "/edit")
    public String editStudent(@RequestParam("id") int id, ModelMap modelMap) {
        Optional<Lesson> lesson = lessonService.findById(id);
        if (lesson.isPresent()) {
            List<User> users = userService.findAll();
            modelMap.addAttribute("lesson", lesson.get());
            modelMap.addAttribute("users", users);
            return "edit_lesson";
        }
        return "redirect:/lesson";
    }

    @PostMapping(value = "/edit")
    public String editStudent(@ModelAttribute("lesson") Lesson lesson, @RequestParam("user") User user) {
        lesson.setTeacher(user);
        lessonService.save(lesson);
        return "redirect:/lesson";
    }

}
