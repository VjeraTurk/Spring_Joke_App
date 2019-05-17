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
    //@RequestMapping(value = "new")
    public String showForm(/*JokeForm jokeForm,*/ Model model) {
	   
       JokeForm form = new JokeForm();
       model.addAttribute("jokeForm", form);
    	
       DEBUG("showForm");

	   categories = categoryRepository.findAll();
	   model.addAttribute("categories",categories);
	   return "form";
    }
    /*
    @GetMapping("/new")
    public String jokeForm(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "new";
    } */
    
    @PostMapping("/new")
    @ResponseBody
    public String submitForm(@ModelAttribute JokeForm jokeForm) {
    	DEBUG("submitForm");
        String content = jokeForm.getContent();
    	return content; //name of the View
    }
	
}
