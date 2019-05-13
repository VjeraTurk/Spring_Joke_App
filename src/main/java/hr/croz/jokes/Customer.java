package hr.croz.jokes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Data //13.5.
@Entity // This tells Hibernate to make a table out of this class
public class Customer {
	
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) //(strategy=GenerationType.IDENTITY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //(strategy=GenerationType.IDENTITY
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

