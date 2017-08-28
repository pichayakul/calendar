package ku.cs.calendar.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;

import ku.cs.calendar.test.models.CalendarTest;

public class MainController {

	public CalendarTest calendar;
	public void startApplication()
	{
		calendar = new CalendarTest(this);
		Date date = new Date();
		
	}
	
	public CalendarTest getCalendar()
	{
		return calendar;
	}
	public MainController getMainController()
	{
		return this;
	}
}
