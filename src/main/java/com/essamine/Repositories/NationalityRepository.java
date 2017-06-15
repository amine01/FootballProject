package com.essamine.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.essamine.entities.Nationality;

public interface NationalityRepository extends JpaRepository<Nationality, Long> {

//	public List<Nationality> findNationalitiesByPersonId(Long personId) {
//		em = getEntityManager();
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		List<Nationality> nationalities = em.createQuery(
//				"from Nationality n where n.person.id=" + personId)
//				.getResultList();
//		transaction.commit();
//		em.close();
//		return nationalities;
//	}
}