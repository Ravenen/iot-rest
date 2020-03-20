package ua.lviv.iot.spring.first.rest.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.first.rest.model.Student;

@Service
public class StudentsService {
  private List<Student> studentList = new LinkedList<>(
      Arrays.asList(new Student("John", "Doe"), new Student("Quentin", "Quarantino")));

  public  void updateStudent(String name, Student student) {
    for (int i = 0; i < studentList.size(); i++) {
      Student s = studentList.get(i);
      if (s.getFirstName().equals(name)) {
        studentList.set(i, student);
        return;
      }
    }
  }

  public List<Student> getStudentList() {
    return studentList;
  }

  public Student getParticularStudent (String name) {
    return studentList.stream().filter(s -> s.getFirstName().equals(name)).findFirst().get();
  }

  public Student addStudent(Student student) {
    studentList.add(student);
    return student;
  }

  public void deleteStudent(String name) {
    for(Student n: studentList) {
      if(n.getFirstName().equals(name)){
        studentList.remove(n);
        return;
      }
    }
  }
}
