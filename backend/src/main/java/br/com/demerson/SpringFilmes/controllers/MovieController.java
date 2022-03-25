package br.com.demerson.SpringFilmes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.demerson.SpringFilmes.DTO.movieDTO;
import br.com.demerson.SpringFilmes.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService service;
    @GetMapping
	public Page<movieDTO> movieFindAll(Pageable pageable) {

		return service.movieFindAll(pageable);

	}
	
	
	 @GetMapping(value = "/{id}")
		public movieDTO movieFindById(@PathVariable Long id) {
			return service.movieFindById(id);

		}
}
