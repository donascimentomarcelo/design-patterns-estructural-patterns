package br.com.cod3r.adapter.hexagonal.infrastructure;

import br.com.cod3r.adapter.hexagonal.core.model.User;
import br.com.cod3r.adapter.hexagonal.core.ports.UserRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMemoryDatabaseAdapter implements UserRepository {

    private Map<String, User> memoryUser = new HashMap<String, User>();

    @Override
    public void save(final User user) {
        this.memoryUser.put(user.getEmail(), user);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<User>(this.memoryUser.values());
    }
}
