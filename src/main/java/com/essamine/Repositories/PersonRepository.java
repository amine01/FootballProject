package com.essamine.Repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.essamine.entities.Person;

public class PersonRepository {

	private final DataSource ds;

	public PersonRepository() {
		try {
			Context ctx = new InitialContext();
			try {
				ds = (DataSource) ctx
						.lookup("java:comp/env/jdbc/footballprojectDB");
			} finally {
				ctx.close();
			}

		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	public void init() throws SQLException {
		Connection cnt = ds.getConnection();
		try {
			Statement stmt = cnt.createStatement();
			try {
				String sql = "create table if not exists person(id integer generated by default as identity primary key,"
						+ "firstname varchar(255),lastname varchar(255),dob date null)";
				stmt.execute(sql);
			} finally {
				stmt.close();
			}
		} finally {
			cnt.close();
		}
	}

	public void create(Person person) throws SQLException {

		Connection connection = ds.getConnection();
		try {
			Statement stmt = connection.createStatement();
			try {
				String sql = "insert into person(firstname,lastname,dob) values('"
						+ person.getFirstname()
						+ "','"
						+ person.getLastname()
						+ "','"
						+ person.getDob()
						+ "')";
				stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				try {
					if (generatedKeys.next()) {
						person.setId(generatedKeys.getLong("id"));
						System.out.println(generatedKeys.getLong("id"));
					}

				} finally {
					generatedKeys.close();
				}
			} finally {
				stmt.close();
			}
		} finally {
			connection.close();
		}
	}

}
