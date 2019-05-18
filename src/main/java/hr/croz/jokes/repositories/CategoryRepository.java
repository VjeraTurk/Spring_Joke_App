package hr.croz.jokes.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hr.croz.jokes.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
    List<Category> findByName(String name);
    List<Category> findById(int id); //sintaksa findBy___ //jel ima smisla da je tipa List?!
    List<Category> findAll(); //17.5.
    
}