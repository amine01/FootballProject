package com.essamine.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.essamine.Repositories.NationalityRepository;
import com.essamine.entities.Nationality;

@WebServlet("/nationality")
public class NationalityServlet extends HttpServlet {

	NationalityRepository nationalityRepository = new NationalityRepository();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long selectedId = null;
		Long selectedPersonId = null;
		

		if (request.getParameter("add") != null
				&& request.getParameter("person_id") != null) {
			// selectedPersonId = Long
			// .parseLong(request.getParameter("person_id"));

			request.setAttribute("person_id", request.getParameter("person_id"));

			request.getRequestDispatcher("jsp/nationality/add.jsp").forward(
					request, response);
		} else if (request.getParameter("delete") != null
				&& request.getParameter("id") != null) {
			selectedId = Long.parseLong(request.getParameter("id"));
			try {
				selectedPersonId = nationalityRepository.findById(selectedId)
						.getPerson_id();
				nationalityRepository.delete(nationalityRepository
						.findById(selectedId));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("person?details&id=" + selectedPersonId);

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
			nationality.setNationality(request
					.getParameter("nationality"));
			nationality.setPerson_id(Long.parseLong(request
					.getParameter("person_id")));
			try {
				nationalityRepository.create(nationality);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		response.sendRedirect("person?details&id="
				+ request.getParameter("person_id"));
	}
}
