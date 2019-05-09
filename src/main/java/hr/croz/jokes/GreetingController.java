package hr.croz.jokes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
	/*
	  @GetMapping("/new")
	    public String inputJoke(@RequestParam(name="content", required=false, defaultValue="World") String content, Model model) {
	        model.addAttribute("content", content);
	        return "new";
	    }
	*/

}
