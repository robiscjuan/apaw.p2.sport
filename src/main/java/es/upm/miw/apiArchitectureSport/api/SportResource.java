package es.upm.miw.apiArchitectureSport.api;

import es.upm.miw.apiArchitectureSport.controllers.SportController;
import es.upm.miw.apiArchitectureSport.exceptions.InvalidSportFieldException;
import es.upm.miw.apiArchitectureSport.exceptions.NotFoundUserNickException;

public class SportResource {

	// POST **/sport body="name"
	public void createSport(String name) throws InvalidSportFieldException {
		this.validateField(name);
		new SportController().createSport(name);
	}

	//TODO Revisar si esto se puede elevar (esta en los dos resources)
	private void validateField(String field) throws InvalidSportFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidSportFieldException(field);
		}
	}
}
