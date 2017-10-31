package server;
/*
 * pichayakul jenpoomjai 5810450903 sec200
 */
import java.util.ArrayList;
import common.Appointment;
public interface DatabaseInterface {
	public void openConnection();
	public void closeConnection();
	public void deleteDatabase(String title);
	public void editDatabase(String time , String title ,String detail,String type,String titleOld);
	public void addDatabase(String date,String time , String title ,String type,String detail);
	public ArrayList<Appointment> initializeDatabase();
}
