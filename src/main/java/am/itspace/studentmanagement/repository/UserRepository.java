package am.itspace.studentmanagement.repository;

import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.entity.UserTyp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUserTyp(UserTyp userTyp);

}
