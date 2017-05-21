package com.essamine.tests;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.essamine.Repositories.NationalityRepository;
import com.essamine.Repositories.PersonRepository;
import com.essamine.entities.Nationality;
import com.essamine.entities.Person;

@WebServlet("/servlet")
public class ServletTeste extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PersonRepository personRepository = new PersonRepository();
		NationalityRepository nationalityRepository = new NationalityRepository();
		try {
			personRepository.init();
			nationalityRepository.init();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Nationality nat1 = new Nationality();
		Nationality nat2 = new Nationality();
		

		nat1.setNationality("moroccan");
		nat1.setPerson_id(1);
		nat2.setNationality("french");
		nat2.setPerson_id(1);
		try {
			nationalityRepository.create(nat1);
			nationalityRepository.create(nat2);
		} catch (SQLException e) {

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

}
