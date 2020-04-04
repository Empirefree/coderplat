package org.fkit.hrm.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;


// 域对象，实现序列化接口
public class User2 implements Serializable{

	private static final long serialVersionUID = 1L;

	private String username;
	
	// 对应上传的file，类型为MultipartFile，上传文件会自动绑定到image属性当中
	private MultipartFile image;

	public User2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	

	
	
}
