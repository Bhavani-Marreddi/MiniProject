package com.jpa.student.dao;
import java.util.List;

import com.jpa.student.model.Student;

public interface StudentDaoInterface
{
 String addStudent(Student student);
 String updateStudent(Student student);
 String deleteStudent(Integer studentId);
 List<Student> findStudent(Integer studentId);
List<Student> findAllStudent();
}
