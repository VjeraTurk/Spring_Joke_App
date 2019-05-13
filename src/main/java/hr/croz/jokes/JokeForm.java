package hr.croz.jokes;

import javax.validation.constraints.NotEmpty;

import hr.croz.model.Category;
import hr.croz.model.Joke;

public class JokeForm {

	@NotEmpty(message = "content may not be empty") 
	private String content;
	//@NotEmpty(message = "category may not be empty")
	private Category category;
	
	private Joke joke ;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	};
	


}
