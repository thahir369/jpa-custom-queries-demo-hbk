package com.helloWorld.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class StudentDetailsResponse {

  String studentId;

  String studentName;

  String contactNumber;
}
