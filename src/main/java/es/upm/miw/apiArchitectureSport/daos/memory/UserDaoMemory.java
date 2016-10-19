package es.upm.miw.apiArchitectureSport.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureSport.daos.UserDao;
import es.upm.miw.apiArchitectureSport.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<String, User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getNick();
	}

	@Override
	protected void setId(User entity, String nick) {
		entity.setNick(nick);
	}

	@Override
	public List<String> findValueBySportName(String sportName) {
		List<User> users = this.findAll();
		List<String> userNicks = new ArrayList<>();
		for (User user : users) {
			if (user.getSports().contains(sportName)) {
				userNicks.add(user.getNick());
			}
		}
		return userNicks;
	}

	@Override
	public User read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setId(User entity, Integer id) {
		// TODO Auto-generated method stub
		
	}

}