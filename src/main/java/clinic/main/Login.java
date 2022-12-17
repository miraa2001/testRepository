package clinic.main;
import java.util.*;

public class Login {
	static Scanner in=new Scanner(System.in);
	static int index=-1;
	public Login()
	{
	}
	public Login(ArrayList<Admin> a,ArrayList<Patient> c)
	{
		for(int i=0;i<c.size();i++)
			PatientMethods.Patients.add(c.get(i));
		for(int i=0;i<a.size();i++)
			AdminMethods.Admins.add(a.get(i));
	}
	public static void login()
	{
		int res=0;
		System.out.println("Welcome to the Login portal\n"+
						   "----------------------------------------------");
		while((res==0)||(res==-1)||(res==1))
		{
			System.out.println("Enter your username");
			String u=in.nextLine();
			System.out.println("Enter the password");
			String p=in.nextLine();
			res=checkLoginStatus(u,p);
			if(res==-2)
			{
				AdminMethods.Admins.get(index).setLogState(true);
				AdminMethods ac=new AdminMethods();//index);
			}
			else if(res==-1)
			{
				AdminMethods.Admins.get(index).setLogState(false);
				System.out.println("Invalid Credentials. Try again");
			}
			else if(res==2)
			{
				PatientMethods.Patients.get(index).setLogState(true);
				PatientMethods pm=new PatientMethods();//index);
			}
			else if(res==1)
			{
				PatientMethods.Patients.get(index).setLogState(false);
				System.out.println("Invalid Credentials. Try again");
			}
			else if(res==0)
			{
				System.out.println("Creddentials do not exist\n"
								+ "You will be redirected to the sign up portal\n"
								+ "Loading..........................");
				Signup SU=new Signup();
			}
		}
	}
	public static int checkLoginStatus(String u,String p)
	{

		for(int i=0;i<PatientMethods.Patients.size();i++)
		{
			if(u.equals(PatientMethods.Patients.get(i).getUsername()))
			{	
				index=i;
				if(p.equals(PatientMethods.Patients.get(i).getPassword()))
					return 2;
				else
					return 1;
			}
		}
		for(int i=0;i<AdminMethods.Admins.size();i++)
		{
			if(u.equals(AdminMethods.Admins.get(i).getUsername()))
			{	
				index=i;
				if(p.equals(AdminMethods.Admins.get(i).getPassword()))
					return -2;
				else
					return -1;
			}
		}
		return 0;
	}
	public static void main(String[] args)
	{
		if((AdminMethods.Admins.size()<=3)&&(PatientMethods.Patients.size()<=3))
		{
			Admin a1=new Admin("miraj","1212001","Mira Jamous");
			Admin a2=new Admin("talahamad","tala2001","Tala Hamad");
			Admin a3=new Admin("areenateeq","areen2002","Areen Ateeq");
			AdminMethods.Admins.add(a1);AdminMethods.Admins.add(a2);AdminMethods.Admins.add(a3);
			Patient c1=new Patient("ayaayman","aya2001","Aya Ayman");		
			Patient c2=new Patient("leenh","leen21","Leen Hodally");
			Patient c3=new Patient("suha2001","suhaa2001","Suha Mansour");
			PatientMethods.Patients.add(c1);PatientMethods.Patients.add(c2);PatientMethods.Patients.add(c3);
		}
		login();
	}
}

