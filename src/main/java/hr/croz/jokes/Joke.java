package hr.croz.jokes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;
//It simply uses the @Data annotation to avoid the boilerplate code, the JPA annotations to mark it as a managed entity with a primary key, 
@Data 
@Entity
public class Joke {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "nije neprazan!") //neprazan!
	private String content; 
	
	@Value("${some.key:0}") //initial value -> 0
	private int likes; 
	@Value("${some.key:0}") //initial value -> 0
	private int dislikes;

	
	
	//@NotEmpty(message = "category may not be empty") //popunjen!
	@NotNull(message = "nije popunjen!")
	@ManyToOne //@ManyToOne indicates to JPA/Hibernate that Many questions can exist ToOne exam.
	@JoinColumn(name = "category_id")
	private Category category;  // jel ima smisla da je tipa Category? -> stack kaze dada 
	
	//trebalo bi biti protected!
	public Joke() {}; //The default constructor only exists for the sake of JPA
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public Category getCategory() {
			return category;
		}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getScore() {
		
		return this.likes-this.dislikes;
	}

}
