package common;

import java.util.ArrayList;

public interface CalendarModelInterface {
	public boolean canMarkDay(String date);
	public ArrayList<Appointment> getNewArray();
	public void matchAppointment(String date);
	public boolean isSameTitle(String title);
	public ArrayList<Appointment> getAppointmentList();
	public void deleteAppointment(int index);
	public void editAppointment(Appointment appointment ,String time,String detail, String title,String type,String titleOld);
	public void addAppointment(String date, String time,String detail,String type, String title);
}
