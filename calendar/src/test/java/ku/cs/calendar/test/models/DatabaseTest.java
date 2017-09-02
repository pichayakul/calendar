package ku.cs.calendar.test.models;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ku.cs.calendar.test.MainController;



public class DatabaseTest {

	Connection con;
	ResultSet resultSet;
	MainController controller;
	PreparedStatement preparedStatement;
	public DatabaseTest(MainController controller) {
		this.controller = controller;
		
		this.initializeDatabase();

	}
	public Connection getCon()
	{
		return this.con;
	}
	public void openConnection()
	{
		try {
			Class.forName("org.sqlite.JDBC");

			String dbUrl = "jdbc:sqlite:database.db";
			con = DriverManager.getConnection(dbUrl);
			if (con != null) {
				System.out.println("Connection Complete..");
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	public void closeConnection()
	{
		try {
			this.con.close();
			System.out.println("Close the connect.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteDatabase(String title)
	{
		try {
			this.openConnection();
			
			preparedStatement = con.prepareStatement("delete from appointment where title ="+"'"+title+"'");
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.closeConnection();
		}
	}
	public void editDatabase(String time , String title ,String detail,String titleOld)
	{
		try {
			this.openConnection();
			preparedStatement = con.prepareStatement("UPDATE appointment" + " SET time = '"+time+"', detail= '"+detail+ 
					"',title = '"+title+"' WHERE title = '"+titleOld+"'");
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		finally {
			this.closeConnection();
		}
	}
	public void addDatabase(String date,String time , String title ,String detail) {
		try {
			this.openConnection();
			preparedStatement = con.prepareStatement("INSERT INTO appointment(date,time,title,detail) VALUES(?,?,?,?)");
			preparedStatement.setString(1, date);
			preparedStatement.setString(2, time);
			preparedStatement.setString(3, title);
			preparedStatement.setString(4, detail);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.closeConnection();
		}
	}

	public void initializeDatabase() {
		
		try {
			this.openConnection();
			Statement statement = con.createStatement();
			resultSet = statement.executeQuery("Select * from appointment");
			
			while (resultSet.next())
			{
				String date = resultSet.getString(1);
				String time = resultSet.getString(2);
				String title = resultSet.getString(3);
				String detail = resultSet.getString(4);
				this.controller.getCalendar().addAppointment(date, time, detail, title);
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			this.closeConnection();
		}

	}
	

}
