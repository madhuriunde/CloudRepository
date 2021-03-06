package com.techlabs.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techlabs.model.Student;
import com.techlabs.repository.StudentRepository;

public class StudentService {
	private List<Student> students;
	static StudentService studentService = null;
	StudentRepository studentRepo = null;
	
	public StudentService() {
		students = new ArrayList<Student>();
		studentRepo = new StudentRepository();
	}
	
	
	
	public List<Student> getStudents() throws SQLException {		
		return studentRepo.getStudents();
	}
	
	
	public void addStudent(Student student) throws SQLException {
		this.studentRepo.addStudent(student);
	}
	
	public Student getSingleStudent(String id) throws SQLException {
		return this.studentRepo.getStudent(id);
	}
	
	public void updateStudent(String id, Student updatedStudent) throws SQLException {
		this.studentRepo.updateStudent(id, updatedStudent);
	}
	
	public List<Student> getStudentsByCollegeId(String collegeID) throws SQLException {
		return this.studentRepo.getStudentsByCollegeId(collegeID);
	}
}
