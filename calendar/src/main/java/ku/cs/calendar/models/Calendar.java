package ku.cs.calendar.models;

import java.util.ArrayList;

import ku.cs.calendar.controllers.MainController;


public class Calendar {

	ArrayList<Appointment> appointmentList;
	public ArrayList<String> months = new ArrayList<>();
	public MainController controller;
	public Calendar(MainController controller)
	{
		appointmentList = new ArrayList<>();
		this.controller = controller;
		String[] list = new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"};
		for (String i : list )
		{
			months.add(i);
		}
	}
	public ArrayList<String> getMonths()
	{
		return this.months;
	}
	public void addAppointment(String date, String time,String detail, String title)
	{
		appointmentList.add(new Appointment(date,time, detail, title,this.controller));
		if (this.controller.getDatabase()!=null)
		{
			this.controller.getDatabase().addDatabase(date, time, title, detail);
		}
		
	}
	public void editAppointment(Appointment appointment ,String time,String detail, String title,String titleOld)
	{
		appointment.setTime(time);
		appointment.setDetail(detail);
		appointment.setTitle(title);
		this.controller.getDatabase().editDatabase(time, title, detail,titleOld);
		
	}
	public void deleteAppointment(int index)
	{
		Appointment a = this.appointmentList.remove(index);
		
		this.controller.getDatabase().deleteDatabase(a.getTitle());
	}
	public ArrayList<Appointment> getAppointmentList()
	{
		return appointmentList;
	}
	public boolean isSameTitle(String title)
	{
		title = title.split(" ")[0];
		for (int i=0;i<this.getAppointmentList().size();i++)
		{
			if (this.getAppointmentList().get(i).getTitle().equals(title))
			{
				return true;
			}
		}
		return false;
	}
	
}
