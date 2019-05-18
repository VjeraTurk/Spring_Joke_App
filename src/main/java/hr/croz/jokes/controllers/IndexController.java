package hr.croz.jokes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hr.croz.jokes.Joke;
import hr.croz.jokes.repositories.JokeRepository;

@Controller
public class IndexController {

	@Autowired //obavezno!
	private JokeRepository jokeRepository;
	
	@GetMapping("/")
	public String showPage(Model model,@RequestParam (defaultValue="0") int page) {
		model.addAttribute("data", jokeRepository.findAll(PageRequest.of(page,10,Sort.by("likes"))));
		//Sort by likes-dislikes
		return "index";
	}
	
	public String like(Joke joke) {
		
		joke.setLikes(joke.getLikes()+1);
		jokeRepository.save(joke);
		return "redirect:/";
	}
	
	public String dislike(Joke joke) {
		joke.setDislikes(joke.getDislikes()+1);
		//jokeRepository.save(joke);
		return "redirect:/";
	}
	
	/*
	@GetMapping(path="")
	public @ResponseBody Iterable<Joke> getAllUsers() {
		// This returns a JSON or XML with the users
		System.out.println(jokeRepository.findAll().toString());
		return jokeRepository.findAll();
	}*/
	
	
}
