package com.essamine.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Repository<E> {

	protected EntityManager em = null;
	private final Class<E> entityClass;

	public Repository(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public static EntityManager getEntityManager() {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("footballproject");
		return managerFactory.createEntityManager();
	}

	public E find(long id) {
		em = getEntityManager();
		EntityTransaction tansaction = em.getTransaction();

		tansaction.begin();
		E entity = em.find(entityClass, id);
		tansaction.commit();

		em.close();
		return entity;
	}

	public E save(E entity) {
		em = getEntityManager();
		EntityTransaction tansaction = em.getTransaction();
		tansaction.begin();
		entity = em.merge(entity);
		tansaction.commit();
		em.close();
		return entity;
	}

	public void delete(Long id) {
		em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		E entity = em.find(entityClass, id);
		em.remove(entity);
		et.commit();
		em.close();
	}

	public List<E> findAll() {
		em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<E> entities = em.createQuery("from Person", entityClass)
				.getResultList();
		et.commit();
		if (em.isOpen())
			em.close();
		return entities;
	}
}