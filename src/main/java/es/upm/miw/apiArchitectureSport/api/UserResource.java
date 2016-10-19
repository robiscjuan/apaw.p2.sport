package es.upm.miw.apiArchitectureSport.api;

import java.util.List;

import es.upm.miw.apiArchitectureSport.controllers.UserController;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidSportFieldException;
import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.entities.User;
import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.UserWrapper;

public class UserResource {
	// POST **/users body="nick:email"
	public void createUser(String nick) throws InvalidSportFieldException {
		this.validateField(nick);
		new UserController().createUser(nick);
	}

	// TODO-1 GET **/users
	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return userListWrapper;
	}

	// TODO-2 GET **/user/search?sport=*

	// TODO-3 PUT **/user/{nick}/sport body="sportName"

	// TODO Revisar si esto se puede elevar (esta en los dos resources)
	private void validateField(String field) throws InvalidSportFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidSportFieldException(field);
		}
	}
}