package es.upm.miw.apiArchitectureSport.daos;

import java.util.List;

import es.upm.miw.apiArchitectureSport.entities.User;

public interface UserDao extends GenericDao<User, String> {
	List<User> findValueBySportName(String sportName);
}
