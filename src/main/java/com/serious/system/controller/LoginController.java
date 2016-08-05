package com.serious.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.serious.system.model.Userinfo;
import com.serious.system.service.UserinfoService;

@Controller
@RequestMapping("admin")
public class LoginController {
	
	@Autowired
	private UserinfoService userinfoService;
	
	/**
	 * 跳往登录页
	 * @param request
	 * @return
	 */
	@RequestMapping("login")
	public String login(HttpServletRequest request){
		
		return "pages/back/login";
	}
	/**
	 * 登录
	 * @param userinfo
	 * @param request
	 * @return
	 */
	@RequestMapping("logon")
	public String logon(Userinfo userinfo, HttpServletRequest request){
		userinfo = userinfoService.loadByModel(userinfo);
		if(userinfo != null){
			request.getSession().setAttribute("userinfo", userinfo);
			return "pages/back/index";
		}else{
			return "pages/back/login";
		}
	}
	/**
	 * 登出
	 * @param request
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("userinfo");
		return "pages/back/login";
	}
	
	/**
	 * 首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, Model model){
		Userinfo userinfo = (Userinfo) request.getSession().getAttribute("userinfo");
		if(userinfo!=null){
			//TODO ...
		}
		return "pages/back/main";
	}

}
