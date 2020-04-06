package ua.lviv.iot.spring.first.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.spring.first.rest.model.Subject;
import ua.lviv.iot.spring.first.rest.service.SubjectService;

@RestController
public class SubjectController {

  @Autowired
  private SubjectService subjectService;

  @GetMapping("/subjects")
  public List<Subject> getAllSubjects() {
    return subjectService.getAllSubjects();
  }
}
