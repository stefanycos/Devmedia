package br.com.devmedia.revjpa;

import java.util.List;

import br.com.devmedia.revjpa.dao.PersonDAO;
import br.com.devmedia.revjpa.entities.Person;

/**
 * @author Stefany Souza
 *
 */
public class AppRevJPA {

	public static void main( String[] args ){
		//inserirPerson();
		//findPersonById();
		//findAllPersons();
		//countPersons();
		//findByLastName();
		findByAge();
	}

	private static void findByAge() {
		List<Person> persons = new PersonDAO().findByAgeBetween(20, 26);
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}

	private static void findByLastName() {
		List<Person> persons = new PersonDAO().findByLastName("Allen");
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}

	private static void countPersons() {
		long total = new PersonDAO().count();
		System.out.println("Total of Persons: " + total);
	}

	private static void findAllPersons() {
		List<Person> persons = new PersonDAO().findAll();
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}

	private static void findPersonById() {
		Person p1 = new PersonDAO().findById(2L);
		Person p2 = new PersonDAO().findById(5L);

		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}



	private static void inserirPerson() {
		Person p1 = new Person();
		p1.setFirstName("Barry");
		p1.setLastName("Allen Silva");
		p1.setAge(22);

		new PersonDAO().save(p1);
		System.out.println(p1.toString());

		Person p2 = new Person();
		p2.setFirstName("Marroni");
		p2.setLastName("Troxa");
		p2.setAge(45);

		new PersonDAO().save(p2);
		System.out.println(p2.toString());

		Person p3 = new Person();
		p3.setFirstName("Sara");
		p3.setLastName("Schofild");
		p3.setAge(27);

		new PersonDAO().save(p3);
		System.out.println(p3.toString());
	}
}
