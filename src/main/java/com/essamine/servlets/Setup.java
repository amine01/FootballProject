package com.essamine.servlets;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;

import com.essamine.Repositories.NationalityRepository;
import com.essamine.Repositories.PersonRepository;

@WebServlet
public class Setup implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		try {
			new PersonRepository().init();
			new NationalityRepository().init();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}
