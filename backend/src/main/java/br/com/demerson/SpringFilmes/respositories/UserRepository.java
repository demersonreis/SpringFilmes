package br.com.demerson.SpringFilmes.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.demerson.SpringFilmes.entities.Movie;
import br.com.demerson.SpringFilmes.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
