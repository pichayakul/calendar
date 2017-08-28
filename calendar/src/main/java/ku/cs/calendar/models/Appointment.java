package ku.cs.calendar.models;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import ku.cs.calendar.controllers.MainController;

public class Appointment {

	String date;
	String detail;
	String title;
	String time;
	Timer timer;
	MainController controller;
	@SuppressWarnings("deprecation")
	public Appointment(String date,String time,String detail,String title,MainController controller) {
		this.date = date;
		this.time = time;
		this.detail = detail;
		this.title = title;
		this.timer = new Timer();
		this.controller = controller;
		Date appointmentTime = new Date();
		appointmentTime.setHours(Integer.parseInt(this.time.split(":")[0]));
		appointmentTime.setMinutes(Integer.parseInt(this.time.split(":")[1]));
		appointmentTime.setDate(Integer.parseInt(this.date.split(" ")[0]));
		appointmentTime.setMonth((controller.getCalendar().getMonths().indexOf(this.date.split(" ")[1])));
		int year = (Integer.parseInt(date.split(" ")[2]));
		appointmentTime.setYear(year-1900);
		appointmentTime.setSeconds(0);
		System.out.println(appointmentTime);
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Title : "+getTitle()+"\n"+"You have an appointment."+"\nDetail : \n    "+getDetail());
			}
		}, appointmentTime);
	}
	
	public String getTime()
	{
		return this.time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public void setDetail(String detail)
	{
		this.detail = detail;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}
	public String getDetail()
	{
		return this.detail;
	}
	public String getDate()
	{
		return this.date;
	}
}
