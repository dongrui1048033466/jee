package com.drsoft.JEE.pojo;

import java.util.Date;

public class Role {
	private Integer rId;
	private Integer uId;
	private Integer u_rId;
	private String roles;
	private String role;
	private String jurisdiction;
	private Integer jId;
	private String jurisdictions;
	private Integer count;
	private String content;
	private Date createTime;
	//分页相关属性
	//启始行
	private Integer start;
	//读取的行数
	private Integer rows;

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Integer getU_rId() {
		return u_rId;
	}

	public void setU_rId(Integer u_rId) {
		this.u_rId = u_rId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public Integer getjId() {
		return jId;
	}

	public void setjId(Integer jId) {
		this.jId = jId;
	}

	public String getJurisdictions() {
		return jurisdictions;
	}

	public void setJurisdictions(String jurisdictions) {
		this.jurisdictions = jurisdictions;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
}
