package hr.croz.jokes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hr.croz.jokes.Category;
import hr.croz.jokes.Joke;
import hr.croz.jokes.JokeForm;
import hr.croz.jokes.repository.CategoryRepository;
import hr.croz.jokes.repository.JokeRepository;
@Controller
public class NewController implements WebMvcConfigurer{
	
	public void DEBUG(String s) {
		System.out.println(s);
	}

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/new").setViewName("new");
    }
    @Autowired //mora ici
	private CategoryRepository categoryRepository;
	
    @Autowired
    private JokeRepository jokeRepository;
    public List<Category> categories; 
    
    
    @GetMapping("/new")
    public String showForm(Model model) {
       DEBUG("showForm");
       JokeForm jokeForm = new JokeForm();
       
       categories = categoryRepository.findAll();
       DEBUG(categories.get(0).toString());
	   DEBUG(categories.get(1).toString());
	   
	   
	   jokeForm.setCategories(categories);
	   model.addAttribute("jokeForm", jokeForm);	      
	   //model.addAttribute("categories",categories);
	   
	   return "form";
    }
    
   /* @GetMapping("/new")
    public String showForm( JokeForm jokeForm) {
       DEBUG("showForm");
	   categories = categoryRepository.findAll();

       DEBUG(categories.get(0).toString());
	   DEBUG(categories.get(1).toString());
	   
	   jokeForm.setCategories(categories); //radi li se to tako?!
       
	   return "form";
    }*/
    
    
    
    @PostMapping("/new")
    @ResponseBody
    public String submitForm(@ModelAttribute JokeForm jokeForm) {

    	DEBUG("submitForm");
        //String content = jokeForm.getContent();
        //DEBUG(model.jokeForm.getContent());
        DEBUG(jokeForm.getContent());
        //DEBUG(jokeForm.getCategoryId().toString());
        DEBUG(Integer.toString(jokeForm.getCategoryId()));
        Joke j = new Joke();
		j.setContent(jokeForm.getContent());
		//j.setCategoryId(jokeForm.getCategoryId());
		
		//DEBUG(Integer.toString(jokeForm.getCategoryId()));
		System.out.println(Integer.toString(jokeForm.getCategoryId()));
		//j.setCategory(categoryRepository.findById(jokeForm.getCategoryId().intValue()).get(0));// bit će jedna
	//	j.setCategory(categoryRepository.findById(jokeForm.getCategoryId()).get(0));// bit će jedna
		
		jokeRepository.save(j); //save
		
		return "Saved";
    }
    
    
    /*
    @PostMapping("/new")
    @ResponseBody
    public String submitForm(@ModelAttribute JokeForm jokeForm) {
    	
    	DEBUG("submitForm");
        //String content = jokeForm.getContent();
        DEBUG(jokeForm.getContent());
        //DEBUG(jokeForm.getCategoryId().toString());
        DEBUG(Integer.toString(jokeForm.getCategoryId()));
        Joke j = new Joke();
		j.setContent(jokeForm.getContent());
		//j.setCategoryId(jokeForm.getCategoryId());
		
		//DEBUG(Integer.toString(jokeForm.getCategoryId()));
		System.out.println(Integer.toString(jokeForm.getCategoryId()));
		//j.setCategory(categoryRepository.findById(jokeForm.getCategoryId().intValue()).get(0));// bit će jedna
		j.setCategory(categoryRepository.findById(jokeForm.getCategoryId()).get(0));// bit će jedna
		
		jokeRepository.save(j); //save
		
		return "Saved";
    }*/
	
}
