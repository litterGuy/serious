package com.serious.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serious.system.dao.RoleMapper;
import com.serious.system.model.Role;
import com.serious.system.service.RoleService;



@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public String add(Role role) {
		if (roleMapper.insertSelective(role) == 1) {
			return "添加成功";
		}
		return "添加失败";
	}
	@Override
	public List<Role> getAll() {
		return roleMapper.getAll();
	}
	
	@Override
	public List<Role> getAllByRole(Role role){
		return roleMapper.getAllByRole(role);
	}
	@Override
	public String delete(String id) {
		if (roleMapper.deleteByPrimaryKey(id) == 1) {
			return "删除成功";
		}
		return "删除失败";
	}
	
	@Override
	public String deleteByIds(String[] ids) {
		if (roleMapper.deleteByIds(ids) == 1) {
			return "删除成功";
		}
		return "删除失败";
	}
	@Override
	public Role findById(String id) {
		return roleMapper.selectByPrimaryKey(id);
	}
	@Override
	public String update(Role role) {
		if (roleMapper.updateByPrimaryKeySelective(role) == 1) {
			return "更新成功";
		}
		return "更新失败";
	}
	@Override
	public List<Role> list(Map<String, Object> map) {
		return roleMapper.list(map);
	}

	@Override
	public List<Role> listPage(Map<String, Object> map) {
		return roleMapper.listPage(map);
	}
	
}
