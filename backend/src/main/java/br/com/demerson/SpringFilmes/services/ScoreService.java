package br.com.demerson.SpringFilmes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.demerson.SpringFilmes.DTO.ScoreDTO;
import br.com.demerson.SpringFilmes.DTO.movieDTO;
import br.com.demerson.SpringFilmes.entities.Movie;
import br.com.demerson.SpringFilmes.entities.Score;
import br.com.demerson.SpringFilmes.entities.User;
import br.com.demerson.SpringFilmes.respositories.MovieRepository;
import br.com.demerson.SpringFilmes.respositories.ScoreRepository;
import br.com.demerson.SpringFilmes.respositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public movieDTO saveScore(ScoreDTO dto) {

		User user = userRepository.findByEmail(dto.getEmail());

		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}

		Movie movie = movieRepository.findById(dto.getMovieId()).get();

		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		score = scoreRepository.saveAndFlush(score);

		double sum = 0.0;
		for (Score s : movie.getScoreAll()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScoreAll().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScoreAll().size());
		
		movie = movieRepository.save(movie);
		
		return new movieDTO(movie);
	}
}
