package com.essamine.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.essamine.Repositories.PersonRepository;
import com.essamine.entities.Person;

@WebServlet("/persons")
public class PersonListSerlvet extends HttpServlet {

	private PersonRepository personRepository=new PersonRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {

		try {
			request.setAttribute("persons", personRepository.findAll());
			request.getRequestDispatcher("jsp/person/persons.jsp").forward(
					request, respone);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse respone) throws ServletException, IOException {

	}

}
