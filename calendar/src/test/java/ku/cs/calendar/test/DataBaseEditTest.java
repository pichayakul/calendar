package ku.cs.calendar.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;

public class DataBaseEditTest {

	@Test
	public void test() {
		MainController controller = new MainController();
		controller.startApplication();
		Date date = new Date();
		String dateForm = date.getDay()+" "+date.getMonth()+" "+(date.getYear()+1900);
		String time= "20:00";
		String detail ="my name is KU";
		String title="title";
//		System.out.println(controller.getCalendar());
		controller.getCalendar().addAppointment(dateForm, time, detail, title);
		try {
			controller.getDatabase().openConnection();
			Statement statement = controller.getDatabase().getCon().createStatement();
			statement.execute("UPDATE appointment SET title='newTitle' where title='"+title+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			controller.getDatabase().closeConnection();
		}
		
		try {
			controller.getDatabase().openConnection();
			Statement statement = controller.getDatabase().getCon().createStatement();
			ResultSet result = statement.executeQuery("SELECT title from appointment where title='newTitle'");
			int count=0;
			while (result.next())
			{
				count++;
			}
			assertEquals(1, count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			controller.getDatabase().closeConnection();
		}
		
	}

}
