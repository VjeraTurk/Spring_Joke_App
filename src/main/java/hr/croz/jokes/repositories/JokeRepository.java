package hr.croz.jokes.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hr.croz.jokes.Joke;

//public interface JokeRepository extends JpaRepository<Joke, Integer> {
//public interface JokeRepository extends PagingAndSortingRepository<Joke, Integer>,CrudRepository<Joke, Integer> {
public interface JokeRepository extends JpaRepository<Joke, Integer>,CrudRepository<Joke, Integer> {
	List<Joke> findByContent(String content);
    List<Joke> findById(int id); //sintaksa findBy___
    
    //NATIVE QUERY postgreSQL
    
    @Query(value = "SELECT *, ( likes - dislikes ) AS score FROM joke ORDER BY 6 DESC, likes DESC, content ", countQuery ="SELECT COUNT(*) FROM joke",nativeQuery = true)  
    Page<Joke> findAllByScore(Pageable pageable); // Page is aware of total number of pages: https://www.baeldung.com/spring-data-jpa-pagination-sorting

    /* ORDER BY 6, DESC, likes DESC -> nuzan je drugi uvjet da se lista ne shuffla jer SQL ne slijedi neko pravilo vec svaki puta vrati drugacije
    
    "BUG" work around: https://stackoverflow.com/questions/38349930/spring-data-and-native-query-with-pagination 
     Pagination is also supported for native queries but requires a little bit of additional work. (https://www.baeldung.com/spring-data-jpa-query)
    List<Joke>  findAllByScore(Pageable pageable);//-> List is not aware of total number of pages!!
    
	2 su Pageable:
						org.springframework.data.domain.Pageable -> OVO JE potrebno!
						org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
	*/
    
    //JPQL - ne radi :(
    //nema SELECT *
    // Entity names instead of table names!
    
    //KAKO SORTIRATI PREMA ALIAS-u koristeci JPQL?
     
    //@Query(value = "SELECT NEW hr.croz.jokes.Joke(j.id, j.content, j.likes, j.dilikes, j.category), j.likes-j.dislikes AS score FROM Joke j ORDER BY score DESC, j.likes DESC, j.content") //unexpected token: AND near line 1, column 79
    //@Query(value = "SELECT j,  j.likes-j.dislikes AS score FROM Joke j ORDER BY 6 DESC, j.likes DESC, j.content")
    //@Query(value = "SELECT j,  j.likes-j.dislikes AS score FROM Joke j")
    //Page<Joke> findAllByScore(Pageable pageable);
//     
}
