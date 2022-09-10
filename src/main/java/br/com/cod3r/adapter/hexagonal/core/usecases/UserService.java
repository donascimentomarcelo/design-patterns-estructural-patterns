package br.com.cod3r.adapter.hexagonal.core.usecases;

import br.com.cod3r.adapter.hexagonal.core.model.User;
import br.com.cod3r.adapter.hexagonal.core.ports.UserRepository;
import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        final boolean alreadyUsedEmail = this.userRepository.getAll()
                .stream()
                .anyMatch(x -> x.getEmail().equalsIgnoreCase(user.getEmail()));

        if (alreadyUsedEmail) throw new RuntimeException("Email address already exists");

        this.userRepository.save(user);
    }


    public List<User> getAll() {
        return this.userRepository.getAll();
    }
}
