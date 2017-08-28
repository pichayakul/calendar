package ku.cs.calendar.test;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;

public class InformationTest {

	@Test
	public void test() {
		MainController test = new MainController();
		test.startApplication();
		
		Date date = new Date();
		String dateForm = date.getDay()+" "+date.getMonth()+" "+(date.getYear()+1900);
//		System.out.println(dateForm);
		test.getCalendar().addAppointment(dateForm, "20:00", "my name is KU", "Introduction");
		
		assertEquals("20:00", test.getCalendar().getAppointmentList().get(0).getTime());
		assertEquals("my name is KU", test.getCalendar().getAppointmentList().get(0).getDetail());
		assertEquals("Introduction", test.getCalendar().getAppointmentList().get(0).getTitle());
		
		
		
		
		
	}

}
