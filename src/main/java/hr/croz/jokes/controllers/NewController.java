package hr.croz.jokes.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hr.croz.jokes.Category;
import hr.croz.jokes.Joke;
import hr.croz.jokes.JokeForm;
import hr.croz.jokes.repositories.CategoryRepository;
import hr.croz.jokes.repositories.JokeRepository;
@Controller
public class NewController implements WebMvcConfigurer{
	
	public void DEBUG(String s) {
		System.out.println(s);
	}

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/new").setViewName("new");
    }
    
    @Autowired 
	private CategoryRepository categoryRepository;
    public List<Category> categories; 	
    @Autowired
    private JokeRepository jokeRepository;
    public List<Joke> jokes; 	
    
    @GetMapping("/new")
    public String showForm(@ModelAttribute JokeForm jokeForm ) { 
       DEBUG("showForm");
       categories = categoryRepository.findAll();
       DEBUG(categories.get(0).toString());
	   DEBUG(categories.get(1).toString());
	   //model.addAttribute("categories",categories); 
	   jokeForm.setCategories(categories);
//	   model.addAttribute("jokeForm", jokeForm);	      
	   
	   return "form";
    }
    
    @PostMapping("/new")
    public String submitForm(@ModelAttribute @Valid JokeForm jokeForm, BindingResult bindingResult) { //Model model?

    	DEBUG("submitForm");

        if (bindingResult.hasErrors()) {
        	jokeForm.setCategories(categories); // izgubi se
            return "form";
        }
    	DEBUG(jokeForm.getContent());
        DEBUG(jokeForm.getCategoryId().toString());
        
        Joke j = new Joke();
		j.setContent(jokeForm.getContent());
		Category c = categoryRepository.findById(jokeForm.getCategoryId().intValue()).get(0);
		j.setCategory(c);
		jokeRepository.save(j);
		
		return "redirect:/";
    }
}
