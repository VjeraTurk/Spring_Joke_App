package hr.croz.jokes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hr.croz.jokes.Joke;
import hr.croz.jokes.repository.JokeRepository;

@Controller
public class IndexController {

	@Autowired //obavezno!
	private JokeRepository jokeRepository;
	
	@GetMapping(path="")
	public @ResponseBody Iterable<Joke> getAllUsers() {
		// This returns a JSON or XML with the users
		System.out.println(jokeRepository.findAll().toString());
		return jokeRepository.findAll();
	}
	
	
}
