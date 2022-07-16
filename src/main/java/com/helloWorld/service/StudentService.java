package com.helloWorld.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.helloWorld.dto.StudentDetailsResponse;

import java.util.List;

public interface StudentService {

  List<StudentDetailsResponse> getStudentDetails() throws JsonProcessingException;

  StudentDetailsResponse getStudentDetailsById(String id) throws JsonProcessingException;
}
