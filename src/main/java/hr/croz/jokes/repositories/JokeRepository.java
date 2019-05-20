package hr.croz.jokes.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import hr.croz.jokes.Joke;

//public interface JokeRepository extends JpaRepository<Joke, Integer> {
public interface JokeRepository extends PagingAndSortingRepository<Joke, Integer>,CrudRepository<Joke, Integer> {
    List<Joke> findByContent(String content);
    List<Joke> findById(int id); //sintaksa findBy___
    
    //ORDER BY 6, DESC, likes DESC -> nuzan je drugi uvjet da se lista ne shuffla jer SQL ne slijedi neko pravilo vec svaki puta vrati drugacije
    @Query(value = "SELECT *, ( likes - dislikes ) AS score FROM joke ORDER BY 6 DESC, likes DESC, content ", countQuery ="SELECT COUNT(*) FROM joke",nativeQuery = true)  
    Page<Joke> findAllByScore(Pageable pageable); // Page is aware of total number of pages: https://www.baeldung.com/spring-data-jpa-pagination-sorting
    //BUG work around: https://stackoverflow.com/questions/38349930/spring-data-and-native-query-with-pagination 
    //List<Joke>  findAllByScore(Pageable pageable);//-> List is not aware of total number of pages!!
    
	//2 su Pageable:
	//					org.springframework.data.domain.Pageable -> OVO JE potrebno!
	//					org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

    
}
