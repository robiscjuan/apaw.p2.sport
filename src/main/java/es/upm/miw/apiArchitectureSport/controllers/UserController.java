package es.upm.miw.apiArchitectureSport.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureSport.daos.DaoFactory;
import es.upm.miw.apiArchitectureSport.entities.User;
import es.upm.miw.apiArchitectureSport.exceptions.AlreadyExistsException;
import es.upm.miw.apiArchitectureSport.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureSport.wrappers.UserWrapper;

public class UserController{
	
	public void createUser(String nick,String email)throws AlreadyExistsException {
		if(DaoFactory.getFactory().getUserDao().read(nick) == null){
		DaoFactory.getFactory().getUserDao().create(new User(nick,email));
		}else{
			throw new AlreadyExistsException();
		}
	}

	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return userListWrapper;
	}
}
