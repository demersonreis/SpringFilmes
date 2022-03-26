package br.com.demerson.SpringFilmes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.demerson.SpringFilmes.DTO.ScoreDTO;
import br.com.demerson.SpringFilmes.DTO.movieDTO;
import br.com.demerson.SpringFilmes.services.MovieService;
import br.com.demerson.SpringFilmes.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService service;

	@PutMapping
	public movieDTO saveScore(@RequestBody ScoreDTO dto) {

		movieDTO movieDTO = service.saveScore(dto);
		return movieDTO;

	}
}
