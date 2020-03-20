package ua.lviv.iot.spring.first.rest.model;

public class Student {
  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  private String firstName;
  private String lastName;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Student(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
