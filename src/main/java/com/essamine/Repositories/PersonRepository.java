package com.essamine.Repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.essamine.entities.Person;

public class PersonRepository {

	private final DataSource ds;

	public PersonRepository() {
		try {
			Context context = new InitialContext();
			try {
				ds = (DataSource) context
						.lookup("java:comp/env/jdbc/footballprojectDB");
			} finally {
				context.close();
			}

		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	public void init() throws SQLException {
		Connection connection = ds.getConnection();
		try {
			Statement statement = connection.createStatement();
			try {
				String sql = "create table if not exists person(id integer generated by default as identity primary key,"
						+ "firstname varchar(255),lastname varchar(255),dob date null)";
				statement.execute(sql);
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public void create(Person person) throws SQLException {

		Connection connection = ds.getConnection();
		try {
			Statement statement = connection.createStatement();
			try {
				String sql = "insert into person(firstname,lastname,dob) values('"
						+ person.getFirstname()
						+ "','"
						+ person.getLastname()
						+ "','" + person.getDob() + "')";
				statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
				ResultSet generatedKeys = statement.getGeneratedKeys();
				try {
					if (generatedKeys.next()) {
						person.setId(generatedKeys.getLong("id"));
						System.out.println(generatedKeys.getLong("id"));
					}

				} finally {
					generatedKeys.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public List<Person> findAll() throws SQLException {
		Connection connection = ds.getConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from person";
			try {
				ResultSet rs = statement.executeQuery(sql);
				try {
					List<Person> persons = new ArrayList<Person>();
					while (rs.next()) {
						persons.add(new Person(rs.getLong(1), rs.getString(2),
								rs.getString(3), rs.getDate(4)));
					}
					return persons;
				} finally {
					rs.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public void update(Person person) throws SQLException {
		Connection connection = ds.getConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "update person set firstname='"
					+ person.getFirstname() + "', lastname='"
					+ person.getLastname() + "', dob='" + person.getDob()
					+ "' where id=" + person.getId();
			try {
				statement.executeUpdate(sql);
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public void delete(Person person) throws SQLException {
		Connection connection = ds.getConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "delete from person where id=" + person.getId();
			try {
				statement.executeUpdate(sql);
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

}
