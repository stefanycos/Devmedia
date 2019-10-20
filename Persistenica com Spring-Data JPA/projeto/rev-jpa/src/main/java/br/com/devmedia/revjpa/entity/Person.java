package br.com.devmedia.revjpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(
	name = "PERSONS",
	//uniqueConstraints = {@UniqueConstraint(columnNames = "FISRT_NAME, LAST_NAME", name = "IDX_1")}, Funciona da mesma forma q o de baixo
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
	
	//Mapeamento referente a classe Document - RELACINAMENTOS
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "DOCUMENT_ID") //Estas coluna sera criada na tabela Document
	private Document document;
	
	//mappedBy: Diz com qual objeto da classe phone ele irá relacionar-se
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	private List<Phone> phones;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "PERSONS_ADDRESSES",
			joinColumns = @JoinColumn(name = "ID_PERSON"),
			inverseJoinColumns = @JoinColumn(name = "ID_ADDRESS")
	)
	private List<Address> adresses;
	
	
	public void addPhone(Phone phone){
		//Verifica se a lista esta vazia
		if(phones == null){
			phones = new ArrayList<Phone>();
		}
		
		phone.setPerson(this);
		phones.add(phone);
	}
	
	public void delPhone(Phone phone){
		if(phones != null){
			phones.remove(phone);
		}
	}
	
	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

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
