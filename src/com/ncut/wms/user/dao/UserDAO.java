package com.ncut.wms.user.dao;

import java.util.List;

import com.ncut.wms.user.model.User;

public interface UserDAO {
	
	//ע���û�����
	public void save(User user);
	
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public List<User> findAll();

}
