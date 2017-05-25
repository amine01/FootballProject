package com.essamine.Repositories;

import java.util.List;

import com.essamine.entities.Nationality;

public class NationalityRepository extends Repository<Nationality> {
	public NationalityRepository() {
		super(Nationality.class);
	}

	public List<Nationality> findNationalitiesByPersonId(Long personId) {
		return em.createQuery(
				"from Nationality n where n.person.id=" + personId)
				.getResultList();

	}
}
