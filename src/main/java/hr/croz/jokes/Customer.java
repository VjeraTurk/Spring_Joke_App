package hr.croz.jokes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

//iz nekog razloga mora biti u istom paketu ko i UserRepository, mozda mu smeta da je konstruktor protected ?!
//tutorial kaze da zelimo a konstruktor bude protected
//The Customer class is annotated with @Entity, indicating that it is a JPA entity.
//For lack of a @Table annotation, it is assumed that this entity will be mapped to a table named Customer.
@Data //13.5.
@Entity // This tells Hibernate to make a table out of this class
public class Customer { // https://stackoverflow.com/a/9036651/4771688
	
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) //(strategy=GenerationType.IDENTITY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // https://stackoverflow.com/a/35957473/4771688
    private int id; //set to int instead of Integer 13.5.

    private String name;

    private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}

