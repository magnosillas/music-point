package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long > {
    public User findByNumero(long id);
}
