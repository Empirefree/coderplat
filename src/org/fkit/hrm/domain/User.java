package org.fkit.hrm.domain;

import java.util.Date;

/**
* @author Empirefree 胡宇乔:
* @version 创建时间：2019年1月24日 下午1:49:41
*/
public class User {
	private Integer id;			// id
	private String loginname;	// 用户名
	private String password;	// 密码
	private String nickname;	// 登录名
	private String eamil;		//邮箱
	
	private String url;			//链接
	private String avatar;		//头像
	private String last_login_ip;		//上次登录IP
	private Date register_time;			//注册时间
	private Date last_login_time;		//上次登录时间	
	private Integer status;				// 状态
	
	// 无参数构造器
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getLast_login_ip() {
		return last_login_ip;
	}
	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}
	public Date getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", loginname=" + loginname + ", password=" + password + ", nickname=" + nickname
				+ ", eamil=" + eamil + ", url=" + url + ", avatar=" + avatar + ", last_login_ip=" + last_login_ip
				+ ", register_time=" + register_time + ", last_login_time=" + last_login_time + ", status=" + status
				+ "]";
	}
	
}
