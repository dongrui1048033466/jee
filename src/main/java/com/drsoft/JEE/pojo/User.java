package com.drsoft.JEE.pojo;

import java.util.Date;

public class User {
	private Integer id;
	private String loginName;
	private String loginPwd;
	private String userName;
	private String phone;
	private String email;
	private String idCard;
	private Integer sex;
	private Integer rIds;
	private Date	createTime;
	private Integer isDelete;
	private Integer count;
	private String roles;
	private String jIds;
	//分页相关属性
	//启始行
	private Integer start;
	//读取的行数
	private Integer rows;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getrIds() {
		return rIds;
	}

	public void setrIds(Integer rIds) {
		this.rIds = rIds;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getjIds() {
		return jIds;
	}

	public void setjIds(String jIds) {
		this.jIds = jIds;
	}
}
