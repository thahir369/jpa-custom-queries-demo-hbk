package com.helloWorld.repository;

import com.helloWorld.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {


  @Query(value = "SELECT STUDENT_ID, CONTACT_NUMBER, STUDENT_NAME FROM STUDENT", nativeQuery = true)
  List<Student> fetchAll();

  @Query(value = "SELECT STUDENT_ID, STUDENT_NAME FROM STUDENT", nativeQuery = true)
  List<Object[]> fetchAllAsObjects();

  @Query(value = "SELECT STUDENT_ID, CONTACT_NUMBER, STUDENT_NAME FROM STUDENT s WHERE s.student_id =:id", nativeQuery = true)
  Optional<Student> fetchById(@Param("id") String id);


}
