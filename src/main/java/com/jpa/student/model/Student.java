package com.jpa.student.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Student")
public class Student 
{
	@Id
	@Column (name = "studentid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	
	@Column(name="date" , length=10)
	private String studentDateOfJoning;
	
	@Column(name="studentname" , length = 20)
	private String studentName;
	
	@Column(name="studenttotalmarks")
	private Float studentTotalMarks;
	
	@Column(name="mailid" , length = 30)
	private String studentMailId;
	
	@Column(name="phoneno" , length = 10)
	private String studentPhoneNo;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentDateOfJoning() {
		return studentDateOfJoning;
	}

	public void setStudentDateOfJoning(String studentDateOfJoning) {
		this.studentDateOfJoning = studentDateOfJoning;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Float getStudentTotalMarks() {
		return studentTotalMarks;
	}

	public void setStudentTotalMarks(Float studentMarks) {
		this.studentTotalMarks = studentMarks;
	}

	public String getStudentMailId() {
		return studentMailId;
	}

	public void setStudentMailId(String studentMailId) {
		this.studentMailId = studentMailId;
	}

	public String getStudentPhoneNo() {
		return studentPhoneNo;
	}

	public void setStudentPhoneNo(String studentPhoneNo) {
		this.studentPhoneNo = studentPhoneNo;
	}
	
}
