package com.example.demo2;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Demo2Application {

  private String name = "Igawa ";
  private String age = "38";

  private Map<String, String> students;

  public Demo2Application() {
    students = new HashMap<>();
    students.put("kanta", "11");
    students.put("mei", "4");
    students.put("satsuki", "11");
  }

  public static void main(String[] args) {
    SpringApplication.run(Demo2Application.class, args);
  }

  @GetMapping("/studentInfo")
  public String getStudentInfo() {
    return name + "   " + age + "歳";
  }

  @GetMapping("/age")
  public String getAge() {
    return age;
  }

  @GetMapping("/studentNameList")
  public String getStudent(@RequestParam String studentNameList) {
    return students.get(studentNameList);
  }


  @PostMapping("/studentInfo")
  public void setStudentInfo(@RequestParam String name, @RequestParam String age) {
    this.name = name;
    this.age = age;
  }

  @PostMapping("/studentName")
  public void updateStudentInfo(String name) {
    this.name = name;
  }

  // GET POST
  // GETは取得する、リクエストの結果を受ける
  // POSTは情報を与える、渡す
}
