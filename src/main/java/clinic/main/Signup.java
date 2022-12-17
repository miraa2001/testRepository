package clinic.main;

import java.util.Scanner;

public class Signup {
	static Scanner in=new Scanner(System.in);
	public static Boolean search(String u)
	{
		for(int i=0;i<PatientMethods.Patients.size();i++)
		{
			if(u.equals(PatientMethods.Patients.get(i).getUsername()))
			{
				return true;
			}
		}
		for(int i=0;i<AdminMethods.Admins.size();i++)
		{
			if(u.equals(AdminMethods.Admins.get(i).getUsername()))
			{
				return true;
			}
		}
		return false;
	}
	public Signup()
	{
		System.out.println("Welcome to the Sign up portal\n"+
							"----------------------------------------------\n"+
							"Please enter your new username");
		String u=in.nextLine();
		while(search(u))
		{
			System.out.println("Username already exists, try again\nEnter your new username");
			u=in.nextLine();
		}
		System.out.println("Please enter the password");
		String p=in.nextLine();
		System.out.println("Please enter your name");
		String n=in.nextLine();
		Patient pt=new Patient(u,p,n);
		PatientMethods.Patients.add(pt);
		System.out.println("User is added to the system successfully");
	}
}
