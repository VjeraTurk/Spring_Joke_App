package hr.croz.jokes.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hr.croz.jokes.Joke;


public interface JokeRepository extends CrudRepository<Joke, Integer> {
    List<Joke> findByContent(String content);
    List<Joke> findById(int id); //sintaksa findBy___
}
