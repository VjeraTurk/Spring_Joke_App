package hr.croz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
//Entity. An object fundamentally defined not by its attributes, but by a thread of continuity and identity. (Meaning it must have Id)
public class Category {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
}
