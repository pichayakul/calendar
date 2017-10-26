package ku.cs.calendar;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ku.cs.calendar.controllers.MainController;
import ku.cs.calendar.models.CalendarModel;
import ku.cs.calendar.models.Database;
import ku.cs.calendar.models.DatabaseInterface;
/*
 * pichayakul jenpoomjai 5810450903 sec200
 */
public class StartApp 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        MainController controller = new MainController();
        ApplicationContext app = new ClassPathXmlApplicationContext("database.xml");
        MainController controller = (MainController) app.getBean("controller");
        CalendarModel calendar = (CalendarModel) app.getBean("calendar");
        DatabaseInterface databse = (DatabaseInterface) app.getBean("database");
        
//        calendar = new CalendarModel(this);
        controller.startApplication(databse,calendar);
    }
}
