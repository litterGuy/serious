package com.serious.system.service;



import java.util.List;
import java.util.Map;

import com.serious.system.model.Role;

public interface RoleService {
	
	String add(Role role);
	
	List<Role> getAll();
	
	String delete(String id);
	
	String deleteByIds(String[] ids);
	
	Role findById(String id);
	
	String update(Role role);
	
	List<Role> getAllByRole(Role role);
	
	
	List<Role> list(Map<String, Object> map);
	List<Role> listPage(Map<String, Object> map);
	
}
