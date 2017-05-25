package com.essamine.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.essamine.Repositories.PersonRepository;

@WebServlet("/persons")
public class PersonListSerlvet extends HttpServlet {

	private PersonRepository personRepository=new PersonRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {

		request.setAttribute("persons", personRepository.findAll());
		request.getRequestDispatcher("jsp/person/list.jsp").forward(request,
				respone);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse respone) throws ServletException, IOException {

	}

}
