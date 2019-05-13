package hr.croz.jokes;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import hr.croz.model.Joke;

@Controller
public class WebController implements WebMvcConfigurer {
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/new").setViewName("new");
    }

    @GetMapping("/new")
    public String showForm(JokeForm jokeForm) {
        return "form";
    }

    @PostMapping("/new")
    public String checkJokeInfo(@Valid JokeForm jokeForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }
    /*
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private JokeRepository jokeRepository;

	@GetMapping(path="/")
	public @ResponseBody Iterable<Joke> getAllJokes() {
		// This returns a JSON or XML with the users
		return jokeRepository.findAll();
	}*/
}
	 