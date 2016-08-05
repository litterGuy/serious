package com.serious.system.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.serious.system.model.Role;
import com.serious.system.model.Userinfo;
import com.serious.system.service.RoleService;
import com.serious.system.service.UserinfoService;

@Controller
@RequestMapping("user")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserinfoService userService;
	@Autowired
	private RoleService roleService;

	@SuppressWarnings("finally")
	@RequestMapping("addUserinfo")
	public String add(Userinfo user, HttpServletRequest request) {
		try {
			user.setCreatetime(new Date());
			String str = userService.add(user);
			logger.debug(str);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			logger.error(e.getMessage());
			request.setAttribute("InfoMessage", "添加信息失败！具体异常信息：" + e.getMessage());
		} finally {
			return "result";
		}
	}

	@RequestMapping("getUserinfoAll")
	public String getAddInfoAll(HttpServletRequest request, Model model, Integer pageNum, Integer pageSize, Long total,
			String paramRoleId) {
		// 获取session中的用户信息 设置用户权限
		Userinfo userinfo = (Userinfo) request.getSession().getAttribute("userinfo");
		if (userinfo == null) {
			return "pages/back/login";
		} else {
			// 值获取用户组下的数据
			Integer groupId = userinfo.getGroupId();
			if (groupId == null) {
				groupId = -1;
			}
			pageNum = pageNum == null ? 1 : pageNum;
			pageSize = pageSize == null ? 10 : pageSize;
			if (total == null || total > (pageNum - 1) * pageSize) {
				PageHelper.startPage(pageNum, pageSize, true);
				Map<String, Object> map = new HashMap<String, Object>();
				String roleId = request.getParameter("paramRoleId");
				if (roleId != null && roleId != "") {
					map.put("roleId", roleId);
				}
				map.put("group_id", groupId);
				List<Userinfo> list = userService.list(map);
				// 用PageInfo对结果进行包装
				if (total == null) {
					PageInfo<Userinfo> page = new PageInfo<Userinfo>(list);
					total = page.getTotal();
				}
				List<Role> roles = roleService.getAll();
				model.addAttribute("roles", roles);

				model.addAttribute("list", list);
				model.addAttribute("pageNum", pageNum);
				model.addAttribute("pageSize", pageSize);
				model.addAttribute("total", total);

				model.addAttribute("paramRoleId", roleId);
			}
			return "pages/back/User/index";
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("del")
	public String del(String tid, HttpServletRequest request) {
		try {
			String str = userService.delete(tid);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "删除信息失败！具体异常信息：" + e.getMessage());
		} finally {
			return "result";
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("delAll")
	public String delAll(String[] ids, HttpServletRequest request) {
		try {
			String str = userService.deleteByIds(ids);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			logger.error(e.getMessage());
			request.setAttribute("InfoMessage", "删除信息失败！具体异常信息：" + e.getMessage());
		} finally {
			return "result";
		}
	}

	@RequestMapping("modify")
	public String modify(String tid, HttpServletRequest request) {
		try {
			Userinfo user = userService.findById(tid);
			request.setAttribute("user", user);
			return "modify";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return "result";
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping("update")
	public String update(Userinfo user, HttpServletRequest request) {
		try {
			user.setUpdatetime(new Date());
			userService.update(user);
		} catch (Exception e) {
			logger.error(e.getMessage());
			request.setAttribute("InfoMessage", "更新信息失败！具体异常信息：" + e.getMessage());
		} finally {
			return "result";
		}
	}

	@RequestMapping("load")
	public Userinfo load(String tid, HttpServletRequest request, HttpServletResponse response){
		Userinfo user = userService.findById(tid);
		return user;
	}

	/**
	 * 检查用户名是否唯一
	 */
	@RequestMapping("isExistUser")
	public Map<String, Object> isExistUser(Userinfo user, HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> result = new HashMap<>();
		Userinfo user_bd = userService.loadByModel(user);
		result.put("flag", false);
		if (user_bd == null) {
			result.put("flag", true);
		}
		return result;
	}

}
