package clinic.main;

import java.util.ArrayList;

public class AdminMethods {
	static public ArrayList<Admin> Admins=new ArrayList<Admin>();
	static public ArrayList<Service> Services=new ArrayList<Service>();
	public static Boolean checkIfServiceCanBeAdded(Service s)
	{
		for (int i=0 ; i <AdminMethods.Services.size() ; i++ )
		{
			if(Services.get(i).getName().equalsIgnoreCase(s.getName())) 
			{
				return true;
			}
		}
		return false;
	}
	public static void addService(Service s) 
	{
		Services.add(s);
	}
	public static int search(String u)
	{
		for(int i=0;i<Admins.size();i++)
		{
			if(u.equals(Admins.get(i).getUsername()))
				return i;
		}
		return -1;
	}
}
