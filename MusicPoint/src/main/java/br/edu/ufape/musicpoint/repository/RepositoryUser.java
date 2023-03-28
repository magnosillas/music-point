package br.edu.ufape.musicpoint.repository;

import br.edu.ufape.musicpoint.basic.Album;
import br.edu.ufape.musicpoint.basic.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long > {
}
