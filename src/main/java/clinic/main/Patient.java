package clinic.main;

import java.util.ArrayList;

public class Patient {
	private String name;
	private String username;
	private String password;
	private String phoneNumber;
	private Boolean logState=false;
	private ArrayList<Appointment> Appointments=new ArrayList<Appointment>();
	public ArrayList<Appointment> appointmentRecords=new ArrayList<Appointment>();
	public ArrayList<Appointment> visitsRecords=new ArrayList<Appointment>();
	public Patient(String s1, String s2)
	{
		this.password=s1;
		
	}
	public Patient(String s1,String s2,String s3)
	{
		this.username=s1;
		this.password=s2;
		this.name=s3;
		this.phoneNumber="0599886655";
		//logState=true;
	}
	public Patient(String s1,String s2,String s3,String s4)
	{
		this.username=s1;
		this.password=s2;
		this.name=s3;
		this.phoneNumber=s4;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	@Override
	public String toString()
	{
		return this.name + " " +  this.phoneNumber;
	}
	public Boolean getLogState() {
		return logState;
	}
	public void setLogState(Boolean logState) {
		this.logState = logState;
	}
	public void setPhoneNumber(String n)
	{
		this.phoneNumber=n;
	}
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
	public ArrayList<Appointment> getAppointments() {
		return Appointments;
	}
	public void setAppointments(ArrayList<Appointment> appointments) {
		Appointments = appointments;
	}
	public void addToPatientApp(Appointment a)
	{
		Appointments.add(a);
	}
	public void removeAppointment(int i)
	{
		this.Appointments.remove(i);
	}
	public void addToVisitsRecord(Appointment a)
	{
		this.visitsRecords.add(a);

	}
	public void resortAppointmentReecords()
	{
		this.appointmentRecords.removeAll(appointmentRecords);
		this.visitsRecords.removeAll(visitsRecords);
		for(int i=0;i<this.Appointments.size();i++)
		{
			if(this.Appointments.get(i).getStatus()==0)
			{
				this.appointmentRecords.add(this.Appointments.get(i));
			}
			else
				this.visitsRecords.add(this.Appointments.get(i));
		}
	}
}
