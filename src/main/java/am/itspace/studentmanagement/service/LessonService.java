package am.itspace.studentmanagement.service;

import am.itspace.studentmanagement.entity.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonService {

    List<Lesson> findAll();

    void save(Lesson lesson);

    void deleteById(int id);

    Optional<Lesson> findById(int id);
}
