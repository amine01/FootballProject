package com.essamine.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.essamine.Repositories.NationalityRepository;
import com.essamine.Repositories.PersonRepository;
import com.essamine.entities.Nationality;
import com.essamine.entities.Person;
import com.essamine.help.Helper;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	PersonRepository personRepository = new PersonRepository();
	NationalityRepository nationalityRepository = new NationalityRepository();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long selectedId = null;
		Person selectedPerson = null;
		List<Nationality> nationalities = null;
		if (request.getParameter("add") != null)
			request.getRequestDispatcher("jsp/person/add.jsp").forward(request,
					response);
		else if (request.getParameter("update") != null) {
			if (request.getParameter("id") != null) {
				selectedId = Long.parseLong(request.getParameter("id"));
				try {
					selectedPerson = personRepository.findById(selectedId);
					request.setAttribute("person", selectedPerson);
					request.getRequestDispatcher("jsp/person/update.jsp")
							.forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (request.getParameter("delete") != null) {
			if (request.getParameter("id") != null) {
				selectedId = Long.parseLong(request.getParameter("id"));
				try {
					//
					nationalities = nationalityRepository
							.findNationalitiesByPerson(selectedId);
					if (nationalities.size() != 0) {
						for (Nationality nationality : nationalities)
							nationalityRepository.delete(nationality);
					}
					personRepository.delete(personRepository
							.findById(selectedId));
					response.sendRedirect("persons");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (request.getParameter("details") != null) {
			if (request.getParameter("id") != null) {
				selectedId = Long.parseLong(request.getParameter("id"));

				try {
					selectedPerson = personRepository.findById(selectedId);
					request.setAttribute("person", selectedPerson);
					request.setAttribute("nationalities", nationalityRepository
							.findNationalitiesByPerson(selectedId));
					request.getRequestDispatcher("jsp/person/details.jsp")
							.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} else
			super.doGet(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Person selectedPerson = null;
		if (request.getParameter("add") != null) {
			Person person = new Person();
			person.setFirstname(request.getParameter("firstname"));
			person.setLastname(request.getParameter("lastname"));
			person.setDob(Helper.StringDateToSqlDate(request
					.getParameter("dob")));
			try {
				personRepository.create(person);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (request.getParameter("update") != null) {
			selectedPerson = new Person(Long.parseLong(request
					.getParameter("id")), request.getParameter("firstname"),
					request.getParameter("lastname"),
					Helper.StringDateToSqlDate(request.getParameter("dob")));
			try {
				personRepository.update(selectedPerson);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("persons");
		// return;
	}
}
