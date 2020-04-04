package org.fkit.hrm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fkit.hrm.domain.User;
import org.fkit.hrm.service.HrmService;
import org.fkit.hrm.util.common.HrmConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;

/**
* @author Empirefree 胡宇乔:
* @version 创建时间：2019年1月23日 下午7:49:06
*/
@Controller
@RequestMapping("/user")
public class UserloginController {
	
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	 @RequestMapping(value="/userlogin")
	 public ModelAndView login(@RequestParam("loginname") String loginname,
			 @RequestParam("password") String password,
			 @RequestParam("captchaCode") String captchaCode,
			 HttpSession session,
			 ModelAndView mv, HttpServletRequest request, HttpServletResponse response){
		 
		// 调用业务逻辑组件判断用户是否可以登录
    	response.setCharacterEncoding("UTF-8");
    	response.setHeader("Pragma", "No-cache");
    	response.setHeader("Cache-Control", "no-cache");
    	response.setDateHeader("Expires", 0);
    	
    	String generateCode =(String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		User user = hrmService.login(loginname, password);
		System.out.println(captchaCode + "输入验证码\n标准验证码:" + generateCode);
		
		//用户基本信息和验证码的验证
		if(user != null && generateCode.toLowerCase().equals(captchaCode.toLowerCase())){
			// 将用户保存到HttpSession当中
			session.setAttribute(HrmConstants.USER_SESSION, user);
			// 客户端跳转到main页面
			mv.setViewName("redirect:/");
			System.out.println("成功登录·~~~");
		}else{
			// 设置登录失败提示信息
			mv.addObject("message", "警告！信息有误");
			// 服务器内部跳转到登录页面（还是别跳转了吧.）
			mv.setViewName("forward:/");
		}
	 
		return mv;
		
	}
		/**
		 * 处理注销退出请求
		 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
		 * @param User user  要添加用户的对象
		 * @param ModelAndView mv
		 * */
		@RequestMapping(value="/logout")
		 public ModelAndView logout(
				 ModelAndView mv,
				 HttpSession session) {
			// 注销session
			session.invalidate();
			// 跳转到登录页面
			mv.setViewName("redirect:/");
			return mv;
		}
	 
}
