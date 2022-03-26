package br.com.demerson.SpringFilmes.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.demerson.SpringFilmes.entities.Movie;
import br.com.demerson.SpringFilmes.entities.Score;
import br.com.demerson.SpringFilmes.entities.ScorePK;
import br.com.demerson.SpringFilmes.entities.User;

public interface ScoreRepository extends  JpaRepository<Score, ScorePK> {

}
