package ua.lviv.iot.spring.first.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.spring.first.rest.model.Student;
import ua.lviv.iot.spring.first.rest.service.StudentsService;

@RequestMapping("/students")
@RestController
public class StudentsController {

  @Autowired
  private StudentsService studentsService;

  @GetMapping(path = "?firstName= {firstName}")
  public List<Student> getStudents(final @RequestParam(value = "firstName", required = false) String firstName) {
    if (firstName == null) {
      return studentsService.getStudentList();
    }
    return studentsService.getAllByFirstName(firstName);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/students")
  public Student addStudent(final @RequestBody Student student) {

    return studentsService.addStudent(student);
  }

  @GetMapping("/students/{id}")
  public Student getParticularStudent(@PathVariable Integer id) {
    return studentsService.getParticularStudent(id);
  }

  @GetMapping(path = "/{id}")
  public Student getStudent(@PathVariable("id") Integer studentid) {
    return new Student("pedro", "aldomovar");
  }

  @RequestMapping(method = { RequestMethod.GET, RequestMethod.PUT }, path = "/smartest")
  public Student getSmartest() {
    return new Student("tapas", "karantino");
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
  public void updateStudent(@RequestBody Student student, @PathVariable Integer id) {
    studentsService.updateStudent(id, student);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
  public ResponseEntity<Student> deleteStudent(@RequestBody @PathVariable Integer id) {
    HttpStatus status = id == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
    return ResponseEntity.status(status).build();
  }

}
