package com.essamine.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.essamine.Repositories.NationalityRepository;
import com.essamine.Repositories.PersonRepository;
import com.essamine.entities.Nationality;
import com.essamine.entities.Person;

@WebServlet("/nationality")
public class NationalityServlet extends HttpServlet {

	NationalityRepository nationalityRepository = new NationalityRepository();
	PersonRepository personRepository = new PersonRepository();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long selectedId = null;
		Person selectedPerson = null;

		if (request.getParameter("add") != null
				&& request.getParameter("person_id") != null) {

			request.setAttribute("person_id", request.getParameter("person_id"));

			request.getRequestDispatcher("jsp/nationality/add.jsp").forward(
					request, response);
		} else if (request.getParameter("delete") != null
				&& request.getParameter("id") != null) {
			selectedId = Long.parseLong(request.getParameter("id"));
			selectedPerson = nationalityRepository.find(selectedId).getPerson();
			nationalityRepository.delete(selectedId);
			response.sendRedirect("person?details&id=" + selectedPerson.getId());

		} else {
			super.doGet(request, response);

		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Nationality nationality = new Nationality();
		if (request.getParameter("add") != null
				& request.getParameter("person_id") != null) {
			nationality.setNationality(request.getParameter("nationality"));
			nationality.setPerson(personRepository.find(Long.parseLong(request
					.getParameter("person_id"))));
			nationalityRepository.save(nationality);

		}
		response.sendRedirect("person?details&id="
				+ request.getParameter("person_id"));
	}
}