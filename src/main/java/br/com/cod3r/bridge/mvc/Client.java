package br.com.cod3r.bridge.mvc;

import br.com.cod3r.bridge.mvc.dao.UserMongoDao;
import br.com.cod3r.bridge.mvc.dao.UserMysqlDao;
import br.com.cod3r.bridge.mvc.dao.UserOracleDao;
import br.com.cod3r.bridge.mvc.dao.UserPostgresDao;
import br.com.cod3r.bridge.mvc.model.User;
import br.com.cod3r.bridge.mvc.services.UserEJB;
import br.com.cod3r.bridge.mvc.services.UserRest;
import br.com.cod3r.bridge.mvc.services.UserSoap;

public class Client {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		User user = new User("user", "user@email.com", "passwd");

		final UserRest userRest = new UserRest(new UserOracleDao());
		userRest.save(user);

		final UserEJB userEJB = new UserEJB(new UserMongoDao());
		userEJB.save(user);

		final UserSoap userSoap = new UserSoap(new UserPostgresDao());
		userSoap.save(user);

		final UserRest userRestMysql = new UserRest(new UserMysqlDao());
		userRestMysql.save(user);
	}
}
