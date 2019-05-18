package hr.croz.jokes;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface JokeRepository extends CrudRepository<Joke, Integer> {
	
    List<Joke> findByContent(String content);
    List<Joke> findById(int id); //sintaksa findBy___
    
}
