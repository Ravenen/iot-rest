package ua.lviv.iot.spring.first.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.spring.first.rest.model.Student;
import ua.lviv.iot.spring.first.rest.service.StudentsService;

//@RequestMapping("/students")
@RestController
public class StudentsController {
  @Autowired
  private StudentsService studentsService;
  private AtomicInteger idCounter = new AtomicInteger();
  private Map<Integer, Student> students = new HashMap<>();
  @GetMapping("/students")
  public List<Student> getStudents() {
    return studentsService.getStudentList();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/students")
  public Student addStudent(final @RequestBody Student student) {
    student.setId(idCounter.incrementAndGet());
    students.put(student.getId(), student);
    return studentsService.addStudent(student);
  }

  @GetMapping("/students/{name}")
  public Student getParticularStudent (@PathVariable String name) {
    return studentsService.getParticularStudent(name);
  }
  @GetMapping(path= "/{id}")
  public Student getStudent(@PathVariable("id") Integer studentid) {
    System.out.println(studentid);
    return new Student("pedro", "aldomovar");
  }
  @RequestMapping(method = {RequestMethod.GET, RequestMethod.PUT}, path = "/smartest" )
  public Student getSmartest() {
    return new Student("tapas", "karantino");
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/students/{name}")
  public void updateStudent (@RequestBody Student student, @PathVariable String name) {
  studentsService.updateStudent(name, student);
  }
  @RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
  public ResponseEntity<Student> deleteStudent (@RequestBody  @PathVariable Integer id) {
  HttpStatus status =  id == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();
  }

}
