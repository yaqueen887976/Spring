package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;


//this is something which would be taling to the database
@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	static {
		users.add(new User(1,"Adam",new Date()));
		users.add(new User(2,"Eve",new Date()));
		users.add(new User(3,"Jack",new Date()));
	}
	
	
	//return all the users back
	public List<User> findAll(){
		return users;
	}
	
	
	
	//add the user to the list
	public User save(User user) {
		//the user ID calculated by the backend. the primary key is determined by the database
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	//return a specific user
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
