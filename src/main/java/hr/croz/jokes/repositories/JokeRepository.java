package hr.croz.jokes.repositories;



import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import hr.croz.jokes.Joke;

//public interface JokeRepository extends JpaRepository<Joke, Integer> {
public interface JokeRepository extends PagingAndSortingRepository<Joke, Integer>,CrudRepository<Joke, Integer> {
    List<Joke> findByContent(String content);
    List<Joke> findById(int id); //sintaksa findBy___
    @Query(value = "SELECT *, ( likes - dislikes ) AS score FROM joke ORDER BY 6 DESC", nativeQuery = true)  
    List<Joke>  findAllByScore(Pageable pageable);
    //Page<Joke>  findAllByScore(Pageable pageable); -> is aware of total number of pages!

}
