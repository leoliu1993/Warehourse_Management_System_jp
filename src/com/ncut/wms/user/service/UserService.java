package com.ncut.wms.user.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Component;

import com.ncut.wms.user.dao.UserDAO;
import com.ncut.wms.user.model.User;

@Component("userService")
public class UserService {

	/* ======以下业务逻辑======== */
	public void add(User user) {
		userDAO.add(user);
	}
	
	public User login(String username) {
		return userDAO.getUser(username);
	}
	
	public List<User> getUserList() {
		List<User> userList = userDAO.findAll();
		return userList;
	}
	
	public String getUserListJson() {
		List<User> userList = userDAO.findAll();
		String json = JSONArray.fromObject(userList).toString();
		return json;
	}
	
	public User findById(Integer id) {
		return userDAO.load(id);
	}

	/* ======以下声明======== */
	private UserDAO userDAO;
	
	@Resource
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
