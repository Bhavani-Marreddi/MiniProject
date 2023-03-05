package com.jpa.student.validation;

import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;

public class StudentValidation {
	public static Boolean validateStudentName(String studentName)
	{
		Integer count=0;
		if(studentName.length()<=30)
		{
			Character[] arr=ArrayUtils.toObject(studentName.toCharArray());
			for(int i=0;i<arr.length;i++)
				if((arr[i]>=65 && arr[i]<=90) || (arr[i]>=97 && arr[i]<=122)|| arr[i]==' ')
					count++;
			if(count==studentName.length())
				return true;
			else
				return false;	
		}
		else
			return false;
	}

	public static Boolean validateStudentMarks(Float studentTotalMarks) {
		if (studentTotalMarks >= 0 && studentTotalMarks <= 1000)
			return true;
		else
			return false;
	}

	public static Boolean validateStudentEmailId(String studentMailId) {
		String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailRegex);
		if (studentMailId != null)
			return pattern.matcher(studentMailId).matches();
		else
			return false;

	}

	public static Boolean validateStudentPhoneNo(String studentPhoneNo) {
		String phonoRegex = "(0/91)?[6-9][0-9]{9}";
		Pattern pattern = Pattern.compile(phonoRegex);
		if (studentPhoneNo != null)
			return pattern.matcher(studentPhoneNo).matches();
		else
			return false;
	}

	public static Boolean validateStudentJoinigData(String studentDateOfJoning) {
		String dateRegex = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
		Pattern pattern = Pattern.compile(dateRegex);
		if (studentDateOfJoning != null)
			return pattern.matcher(studentDateOfJoning).matches();
		else
			return false;
	}

}
