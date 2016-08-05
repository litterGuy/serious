package com.serious.system.dao;


import java.util.List;
import java.util.Map;

import com.serious.system.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role role);

    int insertSelective(Role role);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role role);

    int updateByPrimaryKey(Role role);
    
    List<Role> getAll();
    
    List<Role> getAllByRole(Role role);
    
    int deleteByIds(String[] ids);
    
    List<Role> list(Map<String, Object> map);
	
	List<Role> listPage(Map<String, Object> map);
	
}