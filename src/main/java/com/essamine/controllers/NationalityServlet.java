package com.essamine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.essamine.Repositories.NationalityRepository;
import com.essamine.Repositories.PersonRepository;
import com.essamine.entities.Nationality;
import com.essamine.entities.Person;

@Controller("/nationality")
public class NationalityServlet {

	@Autowired
	PersonRepository personRepository;
	@Autowired
	NationalityRepository nationalityRepository;

	@RequestMapping(value = "/nationality", params = "add", method = RequestMethod.GET)
	public String getAddNationality(Model model, @RequestParam String person_id) {
		model.addAttribute("person_id", person_id);
		return "nationality/add";
	}

	@RequestMapping(value = "/nationality", params = "delete", method = RequestMethod.GET)
	public String getDeleteNationality(@RequestParam String id) {
		nationalityRepository.delete(Long.parseLong(id));
		return "redirect : person/list";
	}

	@RequestMapping(value = "/nationality", params = "add", method = RequestMethod.POST)
	public String postAddNationality(@RequestParam String nationality,
			@RequestParam String person_id) {
		Person p = personRepository.findOne(Long.parseLong(person_id));
		Nationality nat = new Nationality(nationality, p);
		nationalityRepository.save(nat);
		return "redirect:persons";
	}
}