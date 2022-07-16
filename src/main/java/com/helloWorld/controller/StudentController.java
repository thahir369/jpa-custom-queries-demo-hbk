package com.helloWorld.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.helloWorld.dto.StudentDetailsResponse;
import com.helloWorld.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @GetMapping("/students")
  List<StudentDetailsResponse> retrieveStudentDetails() throws JsonProcessingException {
    return studentService.getStudentDetails();
  }

  @GetMapping("/students/{id}")
  StudentDetailsResponse retrieveStudentDetailsById(@PathVariable String id) throws JsonProcessingException {
    return studentService.getStudentDetailsById(id);
  }
}
