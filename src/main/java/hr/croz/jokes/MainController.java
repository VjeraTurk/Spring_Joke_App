package hr.croz.jokes;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* Main difference between POST and GET method is that GET carries request parameter appended in URL string 
while POST carries request parameter in message body 
which makes it more secure way of transferring data from client to server in http protocol.*/

@Controller    // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class MainController implements WebMvcConfigurer{

	public void DEBUG(String s) {
		System.out.println(s);
	}
		
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	DEBUG("addViewControllers");
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/new").setViewName("new");
    }
   @GetMapping("/new")
    public String showForm(JokeForm jokeForm) {
	   DEBUG("showForm");
	  // System.out.println("this is content" + content);
	   //ne radi validacija
	   return "form";
    }

    //@PostMapping("/new") <- smijem imati vise PostMapping anotacija?
    @PostMapping("/new")
    public String checkJokeInfo(@Valid JokeForm jokeForm, BindingResult bindingResult) {
    	DEBUG("checkJokeInfo");
    	
        if (bindingResult.hasErrors()) {
            return "form";
        }
    
        return "redirect:/results";
    }
	
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name) {
		DEBUG("addNewUser");
		//	, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		String email = "this is a test";
		Customer n = new Customer();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n); //save
		return "Saved";
	}
	
	@GetMapping(path="/")
	public @ResponseBody Iterable<Customer> getAllUsers() {
		// This returns a JSON or XML with the users
		System.out.println(userRepository.findAll().toString());
		return userRepository.findAll();
	}
	
	
	
	
	
	//Serving Web Content with Spring MVC
	//gs-serving-web-content
	
	@GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
	
	//The value of the name parameter is added to a Model object, ultimately making it accessible to the view template.

	   /*
    //Handling Form Submission
    //gs-handling-form-submission
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }
	*/

	
}


