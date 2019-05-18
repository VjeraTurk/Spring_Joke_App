package hr.croz.jokes.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import hr.croz.jokes.Joke;

//public interface JokeRepository extends JpaRepository<Joke, Integer> {
public interface JokeRepository extends PagingAndSortingRepository<Joke, Integer>,CrudRepository<Joke, Integer> {
    List<Joke> findByContent(String content);
    List<Joke> findById(int id); //sintaksa findBy___
}
/*
public interface JokeRepository extends CrudRepository<Joke, Integer> {
    List<Joke> findByContent(String content);
    List<Joke> findById(int id); //sintaksa findBy___
}
*/