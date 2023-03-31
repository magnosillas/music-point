package br.edu.ufape.musicpoint.register;

import br.edu.ufape.musicpoint.basic.Friend;
import br.edu.ufape.musicpoint.repository.RepositoryFriend;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterFriend {
    @Autowired
    private RepositoryFriend repositoryFriend;

    public Friend save(Friend friend) {
        return repositoryFriend.save(friend);
    }
}
