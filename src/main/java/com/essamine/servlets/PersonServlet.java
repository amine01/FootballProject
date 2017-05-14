package com.essamine.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.essamine.Repositories.PersonRepository;
import com.essamine.entities.Person;
import com.essamine.help.Helper;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	PersonRepository personRepository = new PersonRepository();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("add") != null)
			request.getRequestDispatcher("jsp/person/add.jsp").forward(request,
					response);
		else
			super.doGet(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getParameter("add") != null) {
			Person p = new Person();
			p.setFirstname(req.getParameter("firstname"));
			p.setLastname(req.getParameter("lastname"));
			p.setDob(Helper.StringDateToSqlDate(req.getParameter("dob")));
			try {
				personRepository.create(p);
				resp.sendRedirect("persons");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
