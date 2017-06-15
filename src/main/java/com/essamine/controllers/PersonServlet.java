package com.essamine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.essamine.Repositories.NationalityRepository;
import com.essamine.Repositories.PersonRepository;
import com.essamine.entities.Person;
import com.essamine.help.Helper;

@Controller("/person")
public class PersonServlet {
	@Autowired
	PersonRepository personRepository;
	@Autowired
	NationalityRepository nationalityRepository;

	@RequestMapping(value = "/person", params = "add", method = RequestMethod.GET)
	public String getAddPerson() {
		return "person/add";
	}

	@RequestMapping(value = "/person", params = "update", method = RequestMethod.GET)
	public String getUpdatePerson() {
		return "person/update";
	}
	

	@RequestMapping(value = "/person", params = "delete", method = RequestMethod.GET)
	public String deletePerson(@RequestParam String id) {
		personRepository.delete(Long.parseLong(id));
		return "redirect:persons";
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String allPersons(Model model) {
		model.addAttribute("persons", personRepository.findAll());
		return "person/list";
	}

	@RequestMapping(value = "/person", params = "add", method = RequestMethod.POST)
	public String postAddPerson(@RequestParam String firstname,
			@RequestParam String lastname, @RequestParam String dob) {
		Person p = new Person(firstname, lastname,
				Helper.StringDateToSqlDate(dob));
		personRepository.save(p);
		return "redirect:persons";
	}

	@RequestMapping(value = "/person", params = "update", method = RequestMethod.POST)
	public String postUpdatePerson(@RequestParam String firstname,
			@RequestParam String lastname, @RequestParam String dob) {
		Person p = new Person(firstname, lastname,
				Helper.StringDateToSqlDate(dob));
		personRepository.save(p);
		return "redirect:persons";
	}
}