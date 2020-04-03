package ua.lviv.iot.spring.first.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"group\"")
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Integer id;

  private String enrollmentYear;

  @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
  @JsonIgnoreProperties("group")
  private Set<Student> studentSet;

  public Set<Student> getStudentSet() {
    return studentSet;
  }

  public void setStudentSet(Set<Student> studentSet) {
    this.studentSet = studentSet;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEnrollmentYear() {
    return enrollmentYear;
  }

  public void setEnrollmentYear(String enrollmentYear) {
    this.enrollmentYear = enrollmentYear;
  }

  public Group(Integer id, String enrollmentYear) {
    this.id = id;
    this.enrollmentYear = enrollmentYear;
  }

  public Group() {}
}
