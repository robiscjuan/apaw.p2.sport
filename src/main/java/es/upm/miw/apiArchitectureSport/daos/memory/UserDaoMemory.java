package es.upm.miw.apiArchitectureSport.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureSport.daos.UserDao;
import es.upm.miw.apiArchitectureSport.entities.Sport;
import es.upm.miw.apiArchitectureSport.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<String, User>());
	}

	@Override
	protected String getId(User entity) {
		return entity.getNick();
	}

	@Override
	protected void setId(User entity, String nick) {
		entity.setNick(nick);
	}

	@Override
	public List<User> findValueBySportName(Sport sport) {
		List<User> users = this.findAll();
		List<User> usersFiltered = new ArrayList<>();
		for (User user : users) {
			if (user.getSports().contains(sport)) {
				usersFiltered.add(user);
			}
		}
		return usersFiltered;
	}

	@Override
	public void create(User entity) {
		super.getMap().put(entity.getNick(), entity);
		this.setId(entity, entity.getNick());

	}

	@Override
	public void addSport(User entity, Sport sport) {
		List<Sport> sportList = entity.getSports();
		sportList.add(sport);
	}

}