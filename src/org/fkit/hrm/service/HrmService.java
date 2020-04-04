package org.fkit.hrm.service;

import java.util.List;

import org.fkit.hrm.domain.Article;
import org.fkit.hrm.domain.User;
import org.fkit.hrm.util.tag.PageModel;

public interface HrmService {	
	
	/***************************User**********************************************/
	/**
	 * 用户登录
	 * @param  loginname
	 * @param  password
	 * @return User对象
	 * */
	User login(String loginname,String password);
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return 用户对象
	 * */
	User findUserById(Integer id);
	
	int findUserByLoginname(String loginname);
	/**
	 * 获得所有用户
	 * @return User对象的List集合
	 * */
	List<User> findUser(User user,PageModel pageModel);
	
	/**
	 * 根据id删除用户
	 * @param id
	 * */
	void removeUserById(Integer id);
	
	/**
	 * 修改用户
	 * @param User 用户对象
	 * */
	void modifyUser(User user);
	
	/**
	 * 添加用户
	 * @param User 用户对象
	 * */
	void addUser(User user);
	/*****************************************************************************/
	
	/***************************Article*******************************************/
	List<Article> findArticle(Article article,PageModel pageModel);
	
	/**
	 * 根据id查询公告
	 * @param id
	 * @return 公告对象
	 * */
	Article findArticleById(Integer id);
	
	/**
	 * 根据id删除公告
	 * @param id
	 * */
	public void removeArticleById(Integer id);
	
	/**
	 * 添加公告
	 * @param Article 公告对象
	 * */
	void addArticle(Article article);
	
	/**
	 * 修改公告
	 * @param Article 公告对象
	 * */
	void modifyArticle(Article article);
	/*********************************************************************************/
	
}
