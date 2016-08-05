package com.serious.system.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serious.system.dao.UserinfoMapper;
import com.serious.system.model.Userinfo;
import com.serious.system.service.UserinfoService;

@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {
	
	@Autowired
	private UserinfoMapper userinfoMapper;

	public UserinfoMapper getUserinfoMapper() {
		return userinfoMapper;
	}
	
	@Override
	public Userinfo loadByModel(Userinfo userinfo) {
		return userinfoMapper.loadByModel(userinfo);
	}
	
	@Override
	public String add(Userinfo user) {
		if (userinfoMapper.insertSelective(user) == 1) {
			return "添加成功";
		}
		return "添加失败";
	}
	@Override
	public List<Userinfo> getAll() {
		return userinfoMapper.getAll();
	}
	
	@Override
	public String delete(String id) {
		if (userinfoMapper.deleteByPrimaryKey(id) == 1) {
			return "删除成功";
		}
		return "删除失败";
	}
	
	@Override
	public String deleteByIds(String[] ids) {
		if (userinfoMapper.deleteByIds(ids) == 1) {
			return "删除成功";
		}
		return "删除失败";
	}
	@Override
	public Userinfo findById(String id) {
		return userinfoMapper.selectByPrimaryKey(id);
	}
	

	@Override
	public List<Userinfo> list(Map<String,Object> map) {
		return userinfoMapper.list(map);
	}
	@Override
	public void update(Userinfo userinfo) {
		userinfoMapper.update(userinfo);
	}
	
	@Override
	public void updateUserGroupBatch(String[] idArray) {
		userinfoMapper.updateUserGroupBatch(idArray);
	}
	
}
