package am.itspace.studentmanagement.service;

import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.entity.UserTyp;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    void save(User user);

    void deleteById(int id);

    Optional<User> findById(int id);

    List<User> findByUserTyp(UserTyp userTyp);

}
