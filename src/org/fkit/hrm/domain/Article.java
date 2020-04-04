package org.fkit.hrm.domain;
/**
* @author Empirefree 胡宇乔:
* @version 创建时间：2019年1月28日 下午3:17:19
*/

import java.util.Date;

public class Article{
	private Integer id;			//id
	private User user;			//用户ID
	private String title;		//标题
	private String content;		//文章内容
	private Integer view_count;		//浏览量
	private Integer comment_count;  //评论量
	private Integer like_count;		//推荐量
	private Integer is_comment;		//私密或公开
	private Integer status;			//状态
	private Integer order;			//关注量
	private Date update_time;			//注册时间
	private Date create_time;			//创建时间
	
	
	// 无参数构造器
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Integer getView_count() {
		return view_count;
	}


	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}


	public Integer getComment_count() {
		return comment_count;
	}


	public void setComment_count(Integer comment_count) {
		this.comment_count = comment_count;
	}


	public Integer getLike_count() {
		return like_count;
	}


	public void setLike_count(Integer like_count) {
		this.like_count = like_count;
	}


	public Integer getIs_comment() {
		return is_comment;
	}


	public void setIs_comment(Integer is_comment) {
		this.is_comment = is_comment;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getOrder() {
		return order;
	}


	public void setOrder(Integer order) {
		this.order = order;
	}


	public Date getUpdate_time() {
		return update_time;
	}


	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}


	public Date getCreate_time() {
		return create_time;
	}


	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}


	@Override
	public String toString() {
		return "Article [id=" + id + ", user=" + user + ", title=" + title + ", content=" + content + ", view_count="
				+ view_count + ", comment_count=" + comment_count + ", like_count=" + like_count + ", is_comment="
				+ is_comment + ", status=" + status + ", order=" + order + ", update_time=" + update_time
				+ ", create_time=" + create_time + "]";
	}
}
