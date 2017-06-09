package com.essamine.servlets;

import java.io.IOException;
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
				selectedPerson = personRepository.find(selectedId);
				request.setAttribute("person", selectedPerson);
				request.getRequestDispatcher("jsp/person/update.jsp").forward(
						request, response);
			}
		} else if (request.getParameter("delete") != null) {
			if (request.getParameter("id") != null) {
				selectedId = Long.parseLong(request.getParameter("id"));
				personRepository.delete(selectedId);
				response.sendRedirect("persons");
			}
		} else if (request.getParameter("details") != null) {
			if (request.getParameter("id") != null) {
				selectedId = Long.parseLong(request.getParameter("id"));

				selectedPerson = personRepository.find(selectedId);
				request.setAttribute("person", selectedPerson);
				request.setAttribute("nationalities", nationalityRepository
						.findNationalitiesByPersonId(selectedId));

				request.getRequestDispatcher("jsp/person/details.jsp").forward(
						request, response);
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
			personRepository.save(person);
		} else if (request.getParameter("update") != null) {
			selectedPerson = new Person(Long.parseLong(request
					.getParameter("id")), request.getParameter("firstname"),
					request.getParameter("lastname"),
					Helper.StringDateToSqlDate(request.getParameter("dob")));
			personRepository.save(selectedPerson);
		}
		response.sendRedirect("persons");
	}
}