package com.serious.system.dao;

import java.util.List;
import java.util.Map;

import com.serious.system.model.Userinfo;


public interface UserinfoMapper {
	
	public Userinfo loadByModel(Userinfo userinfo);
	
	int deleteByPrimaryKey(String id);

    int insert(Userinfo user);

    int insertSelective(Userinfo user);

    Userinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Userinfo user);

    int updateByPrimaryKey(Userinfo user);
    
    List<Userinfo> getAll();
    
    int deleteByIds(String[] ids);
	
	void update(Userinfo userinfo);
	
	void updateUserGroupBatch(String[] idArray);
	
	List<Userinfo> list(Map<String, Object> map);
}