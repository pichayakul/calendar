package ku.cs.calendar;

import ku.cs.calendar.controllers.MainController;
public class StartApp 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        MainController controller = new MainController();
        controller.startApplication();
    }
}
