package es.upm.miw.apiArchitectureSport.api;

import java.util.List;

import es.upm.miw.apiArchitectureSport.controllers.UserController;
import es.upm.miw.apiArchitectureSport.exceptions.AlreadyExistsException;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidSportFieldException;
import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.entities.User;
import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.UserWrapper;

public class UserResource {
	// POST **/users body="nick:email"
	public void createUser(String nick, String email) throws InvalidSportFieldException, AlreadyExistsException {
		this.validateField(nick);
		new UserController().createUser(nick, email);
	}

	// TODO-1 GET **/users
	public UserListWrapper userList() {
		return new UserController().userList();
	}

	// TODO-2 GET **/user/search?sport=*
	public UserListWrapper userList(String sport) {
		return new UserController().userList(sport);
	}
	// TODO-3 PUT **/user/{nick}/sport body="sportName"
	public void addSport(String nick,String sportName){
		new UserController().addSport(nick,sportName);
	}

	// TODO Revisar si esto se puede elevar (esta en los dos resources)
	private void validateField(String field) throws InvalidSportFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidSportFieldException(field);
		}
	}
}