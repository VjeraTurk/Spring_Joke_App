/*Preporučujemo da napravite novi razred JokeForm koji će predstavljati sadržaj forme. Neka se
forma nalazi na poveznici http://localhost:8080/new.*/

package hr.croz.jokes;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;


public class JokeForm {


	@NotEmpty(message = "content may not be empty")
	private String content;
	
	@NotEmpty(message = "category may not be empty") 
	int categoryId;
	
	//private List<Category> categories;
	
	//public List<Integer> lista = new ArrayList();


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategory(int categoryId) {
		this.categoryId = categoryId;
	}
	
}
