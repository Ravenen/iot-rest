package ua.lviv.iot.spring.first.rest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.first.rest.db.StudentRepository;
import ua.lviv.iot.spring.first.rest.model.Student;

@Service
public class StudentsService {

  @Autowired
  private StudentRepository studentRepository;

  public void updateStudent(Integer id, Student student) {
    studentRepository.deleteById(id);
    studentRepository.saveAndFlush(student);
  }

  public List<Student> getStudentList() {
    return studentRepository.findAll();
  }

  public Student getParticularStudent(Integer id) {
    return studentRepository.getOne(id);
  }

  public Student addStudent(Student student) {
    studentRepository.saveAndFlush(student);
    return student;
  }

  public void deleteStudent(Integer id) {
    studentRepository.deleteById(id);
  }

  public List<Student> getAllByFirstName(String firstName) {
    return studentRepository.findAllByFirstName(firstName);
  }
}
