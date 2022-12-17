package clinic.main;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PatientMethods {

	static public ArrayList<Patient> Patients=new ArrayList<Patient>();
	static public ArrayList<Appointment> Appointments=new ArrayList<Appointment>();
	public static int checkAvailability(String date, String time) 
	{
		int one=1;
		int minusone=-1;
		for(int i=0;i<Appointments.size();i++)
		{
			if(date.equals(Appointments.get(i).getDate()) && time.equals(Appointments.get(i).getTime()))
				return minusone;
			
		}			
		return one; //added
		
	}
	public static int checkRemoveAvailability(String username,String date, String time) {
		int one=1;
		int minusone=-1;
		int index=search(username);
		ArrayList<Appointment> a;
		a=Patients.get(index).getAppointments();
		for(int i=0;i<a.size();i++)
		{
			if((date.equals(a.get(i).getDate()))&&(time.equals(a.get(i).getTime())))
				return -1;
		}
		return 1;
		
	}
	public static int search(String u)
	{
		for(int i=0;i<Patients.size();i++)
		{
			if(u.equals(Patients.get(i).getUsername()))
				return i;
		}
		return -1;
	}
	public static void addAppointment(String u,Appointment a)
	{
		Patients.get(search(u)).addToPatientApp(a);
	}
	
	public static void editAppointment(String username,String oldDate,String newDate,String oldTime,String newTime)
	{
		int index=search(username);
		for(int i=0;i<Patients.get(index).getAppointments().size();i++)
		{
			if((oldDate.equals(Patients.get(index).getAppointments().get(i).getDate()))&&
					(oldTime.equals(Patients.get(index).getAppointments().get(i).getTime())))
			{
				Patients.get(index).getAppointments().get(i).setDate(newDate);
				Patients.get(index).getAppointments().get(i).setTime(newTime);
				break;
			}
		}
	}
	public static int checkIfAppointmentPassed(String date,String time)
	{
		int hour=Integer.parseInt(time.split(":")[0]);
		int minute=Integer.parseInt(time.split(":")[1]);
		/////////////////////////////////////////////////////////
		int day=Integer.parseInt(date.split("/")[0]);
		int month=Integer.parseInt(date.split("/")[1]);
		int year=Integer.parseInt(date.split("/")[2]);
		/////////////////////////////////////////////////////////////////
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
		LocalDateTime now = LocalDateTime.now();
		int currentDay=Integer.parseInt(dtf.format(now).split(" ")[0].split("/")[0]);
		int currentMonth=Integer.parseInt(dtf.format(now).split(" ")[0].split("/")[1]);
		int currentYear=Integer.parseInt(dtf.format(now).split(" ")[0].split("/")[2]);
		////////////////////////////////////////////////////////////////////////////////////////////////
		int currentHour=Integer.parseInt(dtf.format(now).split(" ")[1].split(":")[0]);
		int currentMinute=Integer.parseInt(dtf.format(now).split(" ")[1].split(":")[1]);
		//////////////////////////////////////////////////////////////////////////////////////////////
		if((currentDay>day)||(currentMonth>month)||(currentYear>year))
			return 1;
		else if((currentDay<day)||(currentMonth<month)||(currentYear<year))
			return -1;
		else if((currentDay==day)||(currentMonth==month)||(currentYear==year))
		{
			if((currentHour>=hour)&&(currentMinute>=minute))
				return 1;
			else
				return -1;
		}
		return -1;
				
	}
	public static void removeAppointment(String username,String date,String time)
	{
		int index=search(username);
		ArrayList<Appointment> a;
		a=Patients.get(index).getAppointments();
		for(int i=0;i<a.size();i++)
		{
			if((date.equals(a.get(i).getDate()))&&(time.equals(a.get(i).getTime())))
			{
				Patients.get(index).removeAppointment(i);
				break;
			}
		}
	}
	public static void changeAppointmentToVisit(String username,String date,String time)
	{
		for(int i=0;i<Appointments.size();i++)
		{
			if( date.equals(Appointments.get(i).getDate()) && 
					time.equals(Appointments.get(i).getTime())
			   )
			{
				Appointments.get(i).setStatus(1);
				break;
			}
		}
		int index=search(username);
		for(int i=0;i<Patients.get(index).getAppointments().size();i++)
		{
			if( date.equals(Patients.get(index).getAppointments().get(i).getDate()) && 
					time.equals(Patients.get(index).getAppointments().get(i).getTime())
			  )
			{	
				Patients.get(index).getAppointments().get(i).setStatus(1);
				Patients.get(index).resortAppointmentReecords();
				break;
			}
		}
	}
	public static double invoiceForAVisit(String username,String date,String time)
	{
		int index=search(username);
		for(int i=0;i<Patients.get(index).getAppointments().size();i++)
		{
			if( date.equals(Patients.get(index).getAppointments().get(i).getDate()) && 
					time.equals(Patients.get(index).getAppointments().get(i).getTime())
			  )
			{
				if(Patients.get(index).getAppointments().get(i).getStatus()==1)
					return Patients.get(index).getAppointments().get(i).getService().getPrice();
				else
					return -1;			}
		}
		return -1;
	}

}
