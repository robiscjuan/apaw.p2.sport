package es.upm.miw.apiArchitectureSport.exceptions;

public class NotFoundUserNickException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = "El nick del usuario no existe";

	public NotFoundUserNickException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public NotFoundUserNickException() {
		this(DESCRIPTION);
	}
}
