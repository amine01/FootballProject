package com.essamine.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.essamine.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}