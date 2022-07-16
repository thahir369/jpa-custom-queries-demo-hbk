package com.helloWorld.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helloWorld.dto.StudentDetailsResponse;
import com.helloWorld.entity.Student;
import com.helloWorld.repository.StudentRepository;
import com.helloWorld.transformer.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;
  private final ObjectMapper objectMapper;

  @Override
  public List<StudentDetailsResponse> getStudentDetails() throws JsonProcessingException {

    List<Student> studentList1 = studentRepository.findAll();
    log.info(
        "Student details using jpa method:: {}", objectMapper.writeValueAsString(studentList1));

    List<Student> studentList2 = studentRepository.fetchAll();
    log.info(
        "Student details using native query:: {}", objectMapper.writeValueAsString(studentList2));

    List<Object[]> studentList3 = studentRepository.fetchAllAsObjects();
    log.info(
        "Student details as objects array using native query :: {}",
        objectMapper.writeValueAsString(studentList3));

    return studentList2.stream()
        .map(studentMapper::constructStudentDetailsResponse)
        .collect(Collectors.toList());
  }

  @Override
  public StudentDetailsResponse getStudentDetailsById(String id) throws JsonProcessingException {

    Optional<Student> student1 = studentRepository.findById(id);
    log.info("Student details using jpa method :: {}", objectMapper.writeValueAsString(student1));

    Optional<Student> student2 = studentRepository.fetchById(id);
    log.info("Student details using native query :: {}", objectMapper.writeValueAsString(student2));

    return student2.map(studentMapper::constructStudentDetailsResponse).orElse(null);
  }
}
