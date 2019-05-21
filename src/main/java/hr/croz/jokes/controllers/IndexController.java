package hr.croz.jokes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hr.croz.jokes.Joke;
import hr.croz.jokes.repositories.JokeRepository;

@Controller
public class IndexController {

	public void DEBUG(String s) {
		System.out.println(s);
	}

	@Autowired //obavezno!
	private JokeRepository jokeRepository;
	private int jokesPerPage = 10;
	
	@GetMapping("/")
	public String showPage(Model model,@RequestParam (defaultValue="0") int page) {
		DEBUG(Integer.toString(page));		
		//model.addAttribute("data", jokeRepository.findAll(PageRequest.of(page,jokesPerPage , Sort.by(Direction.DESC,"likes")))); 
		//model.addAttribute(jokeRepository.findAll(JpaSort.unsafe("getScore()"))); //model.addAttribute(jokeRepository.findAll(JpaSort.unsafe("likes-dislikes")));	->ne radi

		//Gdje raditi sortiranje? Na client/server side -> kod paginacije preporuka server :https://stackoverflow.com/questions/10721430/where-data-sort-should-be-done-server-or-client
		
		model.addAttribute("data",jokeRepository.findAllByScore(PageRequest.of(page,jokesPerPage))); 			
		
		//model.addAttribute("data",jokeRepository.findAllByScore(PageRequest.of(page,jokesPerPage,Sort.by("score")) )); 	

		//DEBUG("***"+jokeRepository.findAllByScore(PageRequest.of(page,jokesPerPage)).getContent());

		model.addAttribute("jpp",jokesPerPage);
		model.addAttribute("currentpage",page);

		return "index";
	}
	
	@RequestMapping(value="/" , method=RequestMethod.POST, params="action=like")
	public String like(@RequestParam int id,  Model model, @RequestParam (defaultValue="0") int page) {
		DEBUG("like()");
		DEBUG(Integer.toString(page));
		Joke j = jokeRepository.findById(id).get(0);
		j.setLikes(j.getLikes()+1);
		jokeRepository.save(j);

		model.addAttribute("currentpage",page);
		//return "redirect:/?page="+page;
		return "redirect:/";
		//return model;
	}

	//@RequestMapping(value="/", method=RequestMethod.POST, params="action=dislike")
	@PostMapping(value="/",params="action=dislike")
	public String dislike(@RequestParam int id,  Model model, @RequestParam (defaultValue="0") int page) {
		DEBUG("dislike()");
		DEBUG(Integer.toString(page));
//		DEBUG(Integer.toString(joke.getId()));
		Joke j = jokeRepository.findById(id).get(0);
		j.setDislikes(j.getDislikes()+1);
		jokeRepository.save(j);
		
		model.addAttribute("currentpage",page);
		return "redirect:/?page="+page;

	}
	
	
}
