package com.shinhan.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
@WebListener
public class MyContextListener implements ServletContextListener {

  
    public MyContextListener() {
       System.out.println("프로그램 시작");
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("프로그램 종료");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("프로그램 초기화작업");
    }
	
}
