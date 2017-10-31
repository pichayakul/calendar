package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.CalendarModelInterface;
import server.CalendarModel;
import server.Database;
import server.DatabaseInterface;
/*
 * pichayakul jenpoomjai 5810450903 sec200
 */
public class MainController {
	public AppointmentView appointmentView;
	public FillAppointmentView filAppointmentView;
	public MainView view;
	public YesNoForm yesNoForm;
	public CalendarModelInterface calendar;
	public MainController(CalendarModelInterface calendar)
	{
		this.calendar = calendar;
	}
	public void startApplication()
	{
		Date date = new Date();
		view = new MainView(this);
		appointmentView = new AppointmentView(this);
		filAppointmentView = new FillAppointmentView(this); 
		yesNoForm = new YesNoForm(this); 
	}
	public YesNoForm getYesNoForm()
	{
		return this.yesNoForm;
	}
	public MainView getMainView()
	{
		return view;
	}
	public FillAppointmentView getFillAppointmentView()
	{
		return filAppointmentView;
	}
	public CalendarModelInterface getCalendar()
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
