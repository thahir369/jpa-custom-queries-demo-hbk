package com.helloWorld.transformer;

import com.helloWorld.dto.StudentDetailsResponse;
import com.helloWorld.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

  public StudentDetailsResponse constructStudentDetailsResponse(Student student) {

    return StudentDetailsResponse.builder()
        .studentId(student.getStudentId())
        .studentName(student.getStudentName())
        .contactNumber(student.getContactNumber())
        .build();
  }
}
