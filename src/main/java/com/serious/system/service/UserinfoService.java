package com.serious.system.service;

import java.util.List;
import java.util.Map;

import com.serious.system.model.Userinfo;


public interface UserinfoService {
	
	public Userinfo loadByModel(Userinfo userinfo);
	
	String add(Userinfo user);
	
	List<Userinfo> getAll();
	
	String delete(String id);
	
	String deleteByIds(String[] ids);
	
	Userinfo findById(String id);
	
	
	void update(Userinfo userinfo);
	
	void updateUserGroupBatch(String[] idArray);
	
	List<Userinfo> list(Map<String, Object> map);
	
}
