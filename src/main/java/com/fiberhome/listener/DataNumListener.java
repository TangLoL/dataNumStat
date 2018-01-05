package com.fiberhome.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DataNumListener implements ServletContextListener {

    public static String REALPATH;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        MyThread myThread = new MyThread();
//        new Thread(myThread).start();
        REALPATH = servletContextEvent.getServletContext().getRealPath("/");
        System.out.println("----------------" + REALPATH);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
