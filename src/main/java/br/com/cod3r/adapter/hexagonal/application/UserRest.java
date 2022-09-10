package br.com.cod3r.adapter.hexagonal.application;

import br.com.cod3r.adapter.hexagonal.core.model.User;
import br.com.cod3r.adapter.hexagonal.core.usecases.UserService;
import br.com.cod3r.adapter.hexagonal.infrastructure.UserMemoryDatabaseAdapter;
import java.util.List;
import java.util.Map;

public class UserRest {

	private UserService userFacade;
	
	public UserRest() {
		final UserMemoryDatabaseAdapter adapter = new UserMemoryDatabaseAdapter();
		userFacade = new UserService(adapter);
	}

	public Integer post(Map<String, String> values) {
		try {
			final User user = new User(values.get("name"), values.get("email"), values.get("password"));
			this.userFacade.save(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 400;
		}
		return 201;
	}
	
	public Integer get() {
		final List<User> users = this.userFacade.getAll();
		users.forEach(System.out::println);
		return 200;
	}
}
