package hr.croz.jokes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data 
@Entity //Entity. An object fundamentally defined not by its attributes, but by a thread of continuity and identity. (Meaning it must have Id)
public class Category {

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Category name may not be empty") 
	private String name;

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

	
}
