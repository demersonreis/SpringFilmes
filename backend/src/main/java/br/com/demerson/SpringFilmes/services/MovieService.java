package br.com.demerson.SpringFilmes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.demerson.SpringFilmes.DTO.movieDTO;
import br.com.demerson.SpringFilmes.entities.Movie;
import br.com.demerson.SpringFilmes.respositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
    
	@Transactional(readOnly = true)
	public Page<movieDTO> movieFindAll(Pageable pageable) {
	
		Page<Movie> result = repository.findAll(pageable);
		Page<movieDTO> page = result.map(x -> new movieDTO(x));
		return page;
}
	
	@Transactional(readOnly = true)
	public movieDTO movieFindById(Long id) {
	
		Movie result = repository.findById(id).get();
		movieDTO dto = new movieDTO(result);
		return dto;
}
}
