package hr.croz.jokes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hr.croz.model.JokeForm;

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

    
	
	/* The @GetMapping annotation ensures that HTTP GET requests to 
	 /greeting are mapped to the greeting() method.
	
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(value="")
	public String index() {
		return "index";
	}

	@RequestMapping(value="goodbye")
	@ResponseBody
	public String goodbye() {
		return "goodbye";
	}
    */

}
	 


/*

@Controller
public class WebController {

	  @GetMapping("/new")
	    public String inputJoke(@RequestParam(name="content", required=false, defaultValue="World") String content, Model model) {
	        model.addAttribute("content", content);
	        return "new";
	    }
	

}
*/