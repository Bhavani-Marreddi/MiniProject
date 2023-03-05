package com.jpa.student.presentation;

import java.util.Scanner;

public class Login {
	 Login(){
		 Scanner scanner=new Scanner(System.in);     
			String id1="admin";
			String pwd1="abc123";
			
			System.out.print("Enter UserId : " );
			String id2 = scanner.next();
			
			System.out.print("Enter Password : " );
			String pwd2=scanner.next();
			
			if(!id1.equals(id2))
				System.out.println("Invalid Userid.");
			else if(!pwd1.equals(pwd2))
				System.out.println("Invalid Password.");
			else 
			{
				     System.out.println("Login succesfully.");	
				     System.out.println("\n....................................." );
				     System.out.println("\nEnter 1 for Add Student");
						System.out.println("Enter 2 for Update Student");
						System.out.println("Enter 3 for Delete Student");
						System.out.println("Enter 4 for Find Student");
						System.out.println("Enter 5 for FindAll Student");
						System.out.println("Enter 6 for  Exit");	
						System.out.println("....................................." );		
					System.out.println("\nEnter Your choice:");
	 }					

}
}
