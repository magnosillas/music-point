package br.edu.ufape.musicpoint.repository;

import br.edu.ufape.musicpoint.basic.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFriend extends JpaRepository<Friend, Long > {
}
