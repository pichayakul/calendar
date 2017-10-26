package ku.cs.calendar.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ku.cs.calendar.models.CalendarModel;
import ku.cs.calendar.models.Database;
import ku.cs.calendar.models.DatabaseInterface;
import ku.cs.calendar.views.AppointmentView;
import ku.cs.calendar.views.FillAppointmentView;
import ku.cs.calendar.views.MainView;
import ku.cs.calendar.views.YesNoForm;
/*
 * pichayakul jenpoomjai 5810450903 sec200
 */
public class MainController {

	public CalendarModel calendar;
	public AppointmentView appointmentView;
	public FillAppointmentView filAppointmentView;
	public MainView view;
	public DatabaseInterface database;
	public YesNoForm yesNoForm;
	public void startApplication(DatabaseInterface data,CalendarModel calendar)
	{
		this.database = data;
		this.calendar = calendar;
		database.initializeDatabase();
//		calendar = new CalendarModel(this);
		Date date = new Date();
//		ApplicationContext app = new ClassPathXmlApplicationContext("database.xml");
//		database = (Database) app.getBean("database");
//		database = new Database(this);
		view = new MainView(this);
		appointmentView = new AppointmentView(this);
		filAppointmentView = new FillAppointmentView(this); 
		yesNoForm = new YesNoForm(this); 
	}
	public YesNoForm getYesNoForm()
	{
		return this.yesNoForm;
	}
	public DatabaseInterface getDatabase()
	{
		return this.database;
	}
	public MainView getMainView()
	{
		return view;
	}
	public FillAppointmentView getFillAppointmentView()
	{
		return filAppointmentView;
	}
	public CalendarModel getCalendar()
	{
		return calendar;
	}
	public MainController getMainController()
	{
		return this;
	}
	public AppointmentView getAppointView() {
		return appointmentView;
	}
}
