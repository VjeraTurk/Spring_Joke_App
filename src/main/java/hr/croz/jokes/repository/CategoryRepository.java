package hr.croz.jokes.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hr.croz.jokes.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
    List<Category> findByName(String name);
    List<Category> findById(int id); //sintaksa findBy___
    List<Category> findAll(); //17.5.
    
}