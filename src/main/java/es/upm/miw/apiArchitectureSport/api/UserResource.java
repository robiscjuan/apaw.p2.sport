package es.upm.miw.apiArchitectureSport.api;

import java.util.List;

import es.upm.miw.apiArchitectureSport.controllers.UserController;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidSportFieldException;
import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Theme;
import es.upm.miw.apiArchitectureTheme.wrappers.ThemeListWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.ThemeWrapper;

public class UserResource {
	// POST **/users body="nick:email"
	public void createUser(String nick) throws InvalidSportFieldException {
		this.validateField(nick);
		new UserController().createUser(nick);
	}

	// TODO-1 GET **/users
	/*public UserListWrapper userList() {
		List<User> themeList = DaoFactory.getFactory().getThemeDao().findAll();
		ThemeListWrapper themeListWrapper = new ThemeListWrapper();
		for (Theme theme : themeList) {
			themeListWrapper.addThemeWrapper(new ThemeWrapper(theme.getId(), theme.getName()));
		}
		return themeListWrapper;
	}*/

	// TODO-2 GET **/user/search?sport=*

	// TODO-3 PUT **/user/{nick}/sport body="sportName"

	// TODO Revisar si esto se puede elevar (esta en los dos resources)
	private void validateField(String field) throws InvalidSportFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidSportFieldException(field);
		}
	}
}