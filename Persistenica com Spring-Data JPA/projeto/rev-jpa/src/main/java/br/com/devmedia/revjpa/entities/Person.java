package br.com.devmedia.revjpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(
		name = "PERSONS",
		//Criação de indice composto | Funciona até o JPA 2.1
		//uniqueConstraints = {@UniqueConstraint(columnNames = "FISRT_NAME, LAST_NAME", name = "IDX_1")}
		
		//Criação de indice composto | Funciona do JPA 2.1 em diante
		indexes = {@Index(columnList = "FIRST_NAME, LAST_NAME", name = "IDX_PERSON_NAME", unique = true)} //Criando Indice Composto (c/ Duas Colunas)
		)
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSON")
	private Long id;

	@Column(name = "FIRST_NAME", nullable = false, length = 30)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false, length = 60)
	private String lastName;

	@Column(name = "AGE", nullable = false)
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person Id: " + id + " | First Name: " + firstName + " | Last Name: " + lastName + " | Age: " + age ;
	}	
}
