package com.bw.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 * @author boildwater
 * 
 */
public class User {
	private Long id;
	private Department department;
	private Set<Role> roles = new HashSet<Role>();
	private String userName;
	private String userPwd;
	private String userSex;
	private String userRealName;
	private String userHobby;
	private String userTel;
	private String userOrgId;
	private String userRegDate;
	private String userLastLoginDate;
	private String userLastLoginIp;
	private String UserPhoneNumber; // 电话号码
	private String UserEmail; // 电子邮件
	private String UserDescription; // 说明
	public Long getId() {
		return id;
	}
	public Department getDepartment() {
		return department;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserSex() {
		return userSex;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public String getUserHobby() {
		return userHobby;
	}
	public String getUserTel() {
		return userTel;
	}
	public String getUserOrgId() {
		return userOrgId;
	}
	public String getUserRegDate() {
		return userRegDate;
	}
	public String getUserLastLoginDate() {
		return userLastLoginDate;
	}
	public String getUserLastLoginIp() {
		return userLastLoginIp;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public void setUserOrgId(String userOrgId) {
		this.userOrgId = userOrgId;
	}
	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}
	public void setUserLastLoginDate(String userLastLoginDate) {
		this.userLastLoginDate = userLastLoginDate;
	}
	public void setUserLastLoginIp(String userLastLoginIp) {
		this.userLastLoginIp = userLastLoginIp;
	}
	public String getUserPhoneNumber() {
		return UserPhoneNumber;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public String getUserDescription() {
		return UserDescription;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		UserPhoneNumber = userPhoneNumber;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public void setUserDescription(String userDescription) {
		UserDescription = userDescription;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", department=" + department + ", userName="
				+ userName + ", UserDescription=" + UserDescription + "]";
	}


}
