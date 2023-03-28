package br.edu.ufape.musicpoint.register;

import br.edu.ufape.musicpoint.basic.User;
import br.edu.ufape.musicpoint.repository.RepositoryUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterUser {
    @Autowired
    private RepositoryUser repositoryUser;

    public User save(User user) {
        return repositoryUser.save(user);
    }

}
