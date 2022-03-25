package br.com.demerson.SpringFilmes.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.demerson.SpringFilmes.entities.Movie;

public interface MovieRepository extends  JpaRepository<Movie, Long> {

}
