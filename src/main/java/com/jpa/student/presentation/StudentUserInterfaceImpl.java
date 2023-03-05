package com.jpa.student.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.jpa.student.dao.StudentDaoInterfaceImpl;
import com.jpa.student.model.Student;
import com.jpa.student.validation.StudentValidation;

public class StudentUserInterfaceImpl implements StudentUserInterface {
	private Integer studentId;
	private String studentDateOfJoning;
	private String studentName;
	private Float studentTotalMarks;
	private String studentMailId;
	private String studentPhoneNo;

	Scanner scanner = new Scanner(System.in);
	StudentDaoInterfaceImpl daoInterfaceImpl = new StudentDaoInterfaceImpl();
	Student student = new Student();

	public void inputAddStudent() {
		Boolean flagStudentName = true;
		Boolean flagStudentTotalMarks = true;
		Boolean flagStudentMailId = true;
		Boolean flagStudentPhoneNo = true;
		Boolean flagStudentDateOfJoning = true;

		while (flagStudentDateOfJoning) {
			System.out.println("Enter this formate (YYYY-MM-DD) -----");
			System.out.print("Enter Student Date Of Joning : ");
			studentDateOfJoning = scanner.next();
			if (StudentValidation.validateStudentJoinigData(studentDateOfJoning)) {
				student.setStudentDateOfJoning(studentDateOfJoning);
				flagStudentDateOfJoning = false;
				
				while (flagStudentName) {
					System.out.print("Enter Student Name : ");
					studentName = scanner.nextLine();
					studentName = scanner.nextLine();
					if (StudentValidation.validateStudentName(studentName)) {
						student.setStudentName(studentName);
						flagStudentName = false;
						
						while (flagStudentTotalMarks) {
							System.out.print("Enter Student Marks : ");
							studentTotalMarks = scanner.nextFloat();
							if (StudentValidation.validateStudentMarks(studentTotalMarks)) {
								student.setStudentTotalMarks(studentTotalMarks);
								flagStudentTotalMarks = false;
								
								while (flagStudentMailId) {
									System.out.print("Enter Student MailId : ");
									studentMailId = scanner.next();
									if (StudentValidation.validateStudentEmailId(studentMailId)) {
										student.setStudentMailId(studentMailId);
										flagStudentMailId = false;
										
										while (flagStudentPhoneNo) {
											System.out.print("Enter Student PhoneNo : ");
											studentPhoneNo = scanner.next();
											if (StudentValidation.validateStudentPhoneNo(studentPhoneNo)) {
												student.setStudentPhoneNo(studentPhoneNo);
												flagStudentPhoneNo = false;
												
												System.out.println(daoInterfaceImpl.addStudent(student));
											} else
												System.out.println("Enter valid Phone no !!!!!!!");
										}
									} else
										System.out.println("Enter valid Email Id !!!!");
								}
							} else
								System.out.println("Marks must be between 0 to 100 \n'");
						}
					} else
						System.out.println("Enter the text value it should not more than 30 Characters \n");
				}
			} else
				System.out.println("Enter valid Date in this format 'YYYY/MM/DD' !!!!!!!!!!!!");
		}

	}

	public void inputUpdateStudent() {
		Boolean flagStudentName = true;
		Boolean flagStudentTotalMarks = true;
		Boolean flagStudentMailId = true;
		Boolean flagStudentPhoneNo = true;
		Boolean flagStudentDateOfJoning = true;

		System.out.print("Enter Student Id : ");
		studentId = scanner.nextInt();
		List<Student> list= daoInterfaceImpl.findStudent(studentId);
		if (list.size()!= 0) {
			student.setStudentId(studentId);
			
			while (flagStudentDateOfJoning) {
				System.out.println("Enter this formate (YYYY-MM-DD) -----");
				System.out.print("Enter Student Date Of Joning : ");
				studentDateOfJoning = scanner.next();
				if (StudentValidation.validateStudentJoinigData(studentDateOfJoning)) {
					student.setStudentDateOfJoning(studentDateOfJoning);
					flagStudentDateOfJoning = false;
					
					while (flagStudentName) {
						System.out.print("Enter Student Name : ");
						studentName = scanner.nextLine();
						studentName = scanner.nextLine();
						if (StudentValidation.validateStudentName(studentName)) {
							student.setStudentName(studentName);
							flagStudentName = false;
							
							while (flagStudentTotalMarks) {
								System.out.print("Enter Student Marks : ");
								studentTotalMarks = scanner.nextFloat();
								if (StudentValidation.validateStudentMarks(studentTotalMarks)) {
									student.setStudentTotalMarks(studentTotalMarks);
									flagStudentTotalMarks = false;
									
									while (flagStudentMailId) {
										System.out.print("Enter Student MailId : ");
										studentMailId = scanner.next();
										if (StudentValidation.validateStudentEmailId(studentMailId)) {
											student.setStudentMailId(studentMailId);
											flagStudentMailId = false;
											
											while (flagStudentPhoneNo) {
												System.out.print("Enter Student PhoneNo : ");
												studentPhoneNo = scanner.next();
												if (StudentValidation.validateStudentPhoneNo(studentPhoneNo)) {
													student.setStudentPhoneNo(studentPhoneNo);
													flagStudentPhoneNo = false;
													
													System.out.println(daoInterfaceImpl.updateStudent(student));
												} else
													System.out.println("Enter valid Phone no !!!!!!!");
											}
										} else
											System.out.println("Enter valid Email Id !!!!");
									}
								} else
									System.out.println("Marks must be between 0 to 100 \n'");
							}
						} else
							System.out.println("Enter the text value it should not more than 30 Characters \n");
					}
				} else
					System.out.println("Enter valid Date in this format 'YYYY/MM/DD' !!!!!!!!!!!!");
			}
		} else
			System.out.println("Record not Found");
	}

	public void inputDeleteStudent() {
		System.out.print("Enter Student ID : ");
		studentId = scanner.nextInt();
		System.out.println(daoInterfaceImpl.deleteStudent(studentId));
	}

	public void inputFindStudent() {
		System.out.print("Enter Student ID : ");
		studentId = scanner.nextInt();
	 List<Student> student = daoInterfaceImpl.findStudent(studentId);
	 
			if(student.size()!=0)
			{
			Iterator<Student> itr = student.iterator();
			while (itr.hasNext()) {
				Student student1 = itr.next();
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(
						"StudentId\t\tStudentDateOfJoning\t\tStudentName\t\tStudentTotalMarks\t\tStudentMailId\t\tStudentPhoneNo");
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(student1.getStudentId() + "\t\t\t\t" + student1.getStudentDateOfJoning() + "\t\t\t\t"
						+ student1.getStudentName() + "\t\t\t\t" + student1.getStudentTotalMarks() + "\t\t\t\t"
						+ student1.getStudentMailId() + "\t\t\t\t" + student1.getStudentPhoneNo());
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
			} 
			else
				System.out.println("Record not Found");
	}

	public void inputFindAllStudent() {
		List<Student> list = daoInterfaceImpl.findAllStudent();
		Iterator<Student> itr = list.iterator();
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"StudentId\t\tStudentDateOfJoning\t\tStudentName\t\tStudentTotalMarks\t\tStudentMailId\t\t\tStudentPhoneNo");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		while (itr.hasNext()) {
			Student student = itr.next();
			System.out.println(student.getStudentId() + "\t\t\t\t" + student.getStudentDateOfJoning() + "\t\t\t\t"
					+ student.getStudentName() + "\t\t\t\t" + student.getStudentTotalMarks() + "\t\t\t"
					+ student.getStudentMailId() + "\t\t\t" + student.getStudentPhoneNo());
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

}




