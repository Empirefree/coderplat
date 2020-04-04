package org.fkit.hrm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.fkit.hrm.domain.Article;
import org.fkit.hrm.domain.Article;
import org.fkit.hrm.service.HrmService;
import org.fkit.hrm.util.common.HrmConstants;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
* @author Empirefree 胡宇乔:
* @version 创建时间：2019年1月28日 下午4:39:53
*/
@Controller
public class ArticleController {

	/**
	 * 自动注入hrmService
	 * */
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;

	/***************************************Article**********************************************************/
	
	@RequestMapping(value="res/index")
	 public String resIndex(Integer pageIndex,
			 @ModelAttribute Article article,
			 Model model){
		System.out.println("已成功获取文章~~~~~");
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}

		/** 查询文章信息     */
		List<Article> articles = hrmService.findArticle(article, pageModel);
		model.addAttribute("articles", articles);
		model.addAttribute("pageModel", pageModel);
		return "article";
		
	}
	
	
	/**
	 * 处理查询请求
	 * @param pageIndex 请求的是第几页
	 * @param employee 模糊查询参数
	 * @param Model model
	 * */
	@RequestMapping(value="/article/selectArticle")
	 public String selectArticle(Integer pageIndex,
			 @ModelAttribute Article article,
			 Model model){
		System.out.println("article = " + article);
		System.out.println("正在获取下一页~~~~");
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<Article> articles = hrmService.findArticle(article, pageModel);
		model.addAttribute("articles", articles);
		model.addAttribute("pageModel", pageModel);

		return "article";
		
	}
	
	/**
	 * 处理删除用户请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/article/removeArticle")
	 public ModelAndView removeArticle(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除员工
			hrmService.removeArticleById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/article/selectArticle");
		// 返回ModelAndView
		return mv;
	}
	
	
	/**
	 * 处理修改用户请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Article article  要修改用户的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/article/updateArticle")
	 public ModelAndView updateArticle(
			 String flag,
			 @ModelAttribute Article article,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据id查询用户
			Article target = hrmService.findArticleById(article.getId());
			// 设置Model数据
			mv.addObject("article", target);
			// 返回修改员工页面
			mv.setViewName("article/showUpdateArticle");
		}else{
			// 执行修改操作
			hrmService.modifyArticle(article);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/article/selectArticle");
		}
		// 返回
		return mv;
	}
	
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param Article article  要添加用户的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/article/addArticle")
	 public ModelAndView addArticle(
			 String flag,
			 @ModelAttribute Article article,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 设置跳转到添加页面
			mv.setViewName("article/showAddArticle");
		}else{
			// 执行添加操作
			hrmService.addArticle(article);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/article/selectArticle");
		}
		// 返回
		return mv;
	}
	

}
