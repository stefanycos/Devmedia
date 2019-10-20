package br.com.devmedia.revjpa.dao;

import java.util.List;

import br.com.devmedia.revjpa.entities.Person;

public class PersonDAO extends GenericDAO<Person> {

	public PersonDAO() {
		super(Person.class);
	}
	
	public List<Person> findByLastName(String lastName){
		String jpql = "from Person p where p.lastName like ?";
		return find(jpql, lastName);
	}
	
	public List<Person> findByAgeBetween(int min, int max){
		String jpql = "from Person p where p.age between ? and ?";
		return find(jpql, min, max);
	}

}
