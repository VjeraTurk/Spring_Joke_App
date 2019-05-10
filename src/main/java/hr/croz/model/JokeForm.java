package hr.croz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

//It simply uses the @Data annotation to avoid the boilerplate code, 
// the JPA annotations to mark it as a managed entity with a primary key, 
@Data
@Entity
public class JokeForm {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message = "content may not be empty") //neprazan!
	private String content; 
	
	@Value("${some.key:0}") //initial value -> 0
	private int likes; 
	@Value("${some.key:0}") //initial value -> 0
	private int dislikes;

	//@NotEmpty(message = "category may not be empty") 
	@ManyToOne //@ManyToOne indicates to JPA/Hibernate that Many questions can exist ToOne exam.
	@JoinColumn(name = "category_id")
//	private Category category; //popunjen!
	private String category; //popunjen!
	
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

	public String getCategory() {
			return category;
		}

	public void setCategory(String category) {
		this.category = category;
	}

	//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
	@Override
	public String toString() {
		return "JokeForm [id=" + id + ", content=" + content + ", likes=" + likes + ", dislikes=" + dislikes
				+ ", category=" + category + "]";
	}

}
