package server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartApp {

	public static void main(String[] args) {
		ApplicationContext bf = new ClassPathXmlApplicationContext("server.xml");
		System.out.println("server start");
	}
}