package com.essamine.Repositories;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.essamine.entities.Nationality;

public class NationalityRepository extends Repository<Nationality> {

	public NationalityRepository() {
		super(Nationality.class);
	}

	public List<Nationality> findNationalitiesByPersonId(Long personId) {
		em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		List<Nationality> nationalities = em.createQuery(
				"from Nationality n where n.person.id=" + personId)
				.getResultList();
		transaction.commit();
		em.close();
		return nationalities;
	}
}