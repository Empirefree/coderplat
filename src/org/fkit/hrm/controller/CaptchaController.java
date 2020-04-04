package org.fkit.hrm.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fkit.hrm.util.common.HrmConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
/**
* @author Empirefree 胡宇乔:
* @version 创建时间：2019年1月23日 下午1:49:56
*/
@Controller
public class CaptchaController {
	    private Producer kaptchaProducer=null;
	 
	    @Autowired
	    public void setCaptchaProducer(Producer kaptchaProducer) {
	        this.kaptchaProducer = kaptchaProducer;
	    }
	    @RequestMapping("/kmycode")
	    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
	    	System.out.println("正在进行验证码业务~~~~~");
	        response.setDateHeader("Expires",0);
	        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
	        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	        response.setHeader("Pragma", "no-cache");
	        response.setContentType("image/jpeg");
	        String capText = kaptchaProducer.createText();
	        
	        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
	        BufferedImage bi = kaptchaProducer.createImage(capText);
	        ServletOutputStream out = response.getOutputStream();
	        ImageIO.write(bi, "jpg", out);
	        try {
	            out.flush();
	        } finally {
	            out.close();
	        }
	        return null;
	    }
	    
//	    //验证验证码
//	    @RequestMapping("checkCaptchaCode")
//	    public void checkCaptchaCode(HttpServletRequest request, HttpServletResponse response,@RequestParam("captchaCode") String captchaCode){
//	    	System.out.println("页面输入验证码===="+captchaCode);
//	    	response.setCharacterEncoding("UTF-8");
//	    	response.setHeader("Pragma", "No-cache");
//	    	response.setHeader("Cache-Control", "no-cache");
//	    	response.setDateHeader("Expires", 0);
//	    	
//	    	 String generateCode =(String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//	    	 String result = "";
//	    	 
//	    	 if(generateCode.equals(captchaCode)){
//	    		 result = "验证成功";
//	    	 }else{
//	    		 result = "输入错误";
//	    	 }
//	    	 PrintWriter out = null;
//	    	 try{
//	    		 out = response.getWriter();
//	    	 }catch (IOException e) {
//	    		 e.printStackTrace();
//	    	 }
//	    	 //返回结果
//	    	 out.print(result);
//	    	 out.flush();
//	    }
}

