package ua.lviv.iot.spring.first.rest.db;

import java.util.List;
import javax.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring.first.rest.model.Student;

@NamedNativeQuery(name = "student.findBestStudent", query = "select * from students where id = 1")
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

  List<Student> findAllByFirstName(String firstName);

  List<Student> findAllByFirstNameAndLastName(String firstName, String lastName);
}
