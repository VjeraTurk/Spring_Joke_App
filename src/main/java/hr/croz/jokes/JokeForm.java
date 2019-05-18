/*Preporučujemo da napravite novi razred JokeForm koji će predstavljati sadržaj forme. Neka se
forma nalazi na poveznici http://localhost:8080/new.*/

package hr.croz.jokes;
import java.util.List;

import javax.validation.constraints.NotEmpty;


public class JokeForm {

	@NotEmpty(message = "content may not be empty")
	private String content;
	
	@NotEmpty(message = "categoryId may not be empty") 
	private Integer categoryId;

	@NotEmpty(message = "category may not be empty") 
	private Category category;

/*
	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
*/
	private List<Category> categories;
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
}
