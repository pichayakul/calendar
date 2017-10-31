package client;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import server.CalendarModel;
import server.Database;
import server.DatabaseInterface;
/*
 * pichayakul jenpoomjai 5810450903 sec200
 */
public class StartApp 
{
    public static void main( String[] args )
    {
        ApplicationContext app = new ClassPathXmlApplicationContext("client.xml");
        MainController controller = (MainController) app.getBean("controller");
        controller.startApplication();
    }
}
