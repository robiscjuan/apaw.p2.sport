package es.upm.miw.apiArchitectureSport.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.entities.Sport;
import es.upm.miw.apiArchitectureSport.entities.User;
import es.upm.miw.apiArchitectureSport.exceptions.AlreadyExistsException;
import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.UserWrapper;

public class UserController {

	public void createUser(String nick, String email) throws AlreadyExistsException {
		if (DaoFactory.getFactory().getUserDao().read(nick) == null) {
			DaoFactory.getFactory().getUserDao().create(new User(nick, email));
		} else {
			throw new AlreadyExistsException();
		}
	}

	public void addSport(String nick, String sportName) {
		if (DaoFactory.getFactory().getSportDao().read(sportName) != null) {
			User user = DaoFactory.getFactory().getUserDao().read(nick);
			Sport sport = DaoFactory.getFactory().getSportDao().read(sportName);
			DaoFactory.getFactory().getUserDao().addSport(user, sport);
		} else {
			// TODO Throws error
		}
	}

	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		return getUsersWrapper(userList);
	}

	public UserListWrapper userList(String sport) {
		Sport sportEntity = DaoFactory.getFactory().getSportDao().read(sport);
		List<User> userList = DaoFactory.getFactory().getUserDao().findValueBySportName(sportEntity);
		return getUsersWrapper(userList);
	}

	private UserListWrapper getUsersWrapper(List<User> userList) {
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return userListWrapper;
	}
}
