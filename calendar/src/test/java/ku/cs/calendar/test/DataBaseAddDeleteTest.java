package ku.cs.calendar.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;

import ku.cs.calendar.models.Calendar;



public class DataBaseAddDeleteTest {

	@Test
	public void test() {
		MainController controller = new MainController();
		controller.startApplication();
		Date date = new Date();
		String dateForm = date.getDay()+" "+date.getMonth()+" "+(date.getYear()+1900);
		String time= "20:00";
		String detail ="my name is KU";
		String title="o,n";
//		System.out.println(controller.getCalendar());
		int countOld =0;
		try {
			controller.getDatabase().openConnection();
			Statement statement = controller.getDatabase().getCon().createStatement();
			ResultSet result = statement.executeQuery("SELECT * from appointment");
			
			while (result.next())
			{
				countOld++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			controller.getDatabase().closeConnection();
		}
		controller.getCalendar().addAppointment(dateForm, time, detail, title);
//		controller.getDatabase().addDatabase(dateForm, time, title, detail);
		
//		System.out.println(controller.getDatabase());
		try {
			controller.getDatabase().openConnection();
			Statement statement = controller.getDatabase().getCon().createStatement();
			ResultSet result = statement.executeQuery("SELECT * from appointment");
			int count =0;
			while (result.next())
			{
				count++;
			}
			assertEquals(countOld+1, count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			controller.getDatabase().closeConnection();
		}
		
		//delete database
		controller.getCalendar().deleteAppointment(0);
		try {
			controller.getDatabase().openConnection();
			Statement statement = controller.getDatabase().getCon().createStatement();
			ResultSet result = statement.executeQuery("SELECT * from appointment");
			int count =0;
			while (result.next())
			{
				count++;
			}
			assertEquals(countOld, count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			controller.getDatabase().closeConnection();
		}
		
		
		
	}

}
