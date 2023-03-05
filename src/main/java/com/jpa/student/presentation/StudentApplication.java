package com.jpa.student.presentation;

import java.util.Scanner;


public class StudentApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentUserInterfaceImpl userInterfaceImpl = new StudentUserInterfaceImpl();
		Integer choice;
		System.out.println("**************************************************************************************************************");
		System.out.println("                                    STUDENT  MANAGEMENT SYSTEM                                              ");
	    System.out.println("**************************************************************************************************************");
	    new Login();
	    do {
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				userInterfaceImpl.inputAddStudent();
				break;

			case 2:
				userInterfaceImpl.inputUpdateStudent();
				break;

			case 3:
				userInterfaceImpl.inputDeleteStudent();
				break;

			case 4:
				userInterfaceImpl.inputFindStudent();
				break;

			case 5:
				userInterfaceImpl.inputFindAllStudent();
				break;

			case 6:
				System.out.println("User wants to Quit !!! ");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Option------------ Please Try Again!!!");
			}
		} while (choice != 6);
	}
}
