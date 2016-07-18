package com.bw.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 实体：岗位
 * 
 * @author boildwater
 * 
 */
public class Role {
	private Long id;
	private String name;
	private String description;
	private Set<User> users = new HashSet<User>();
	private Set<Menu> roleMenus=new HashSet<Menu>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Menu> getRoleMenus() {
		return roleMenus;
	}

	public void setRoleMenus(Set<Menu> roleMenus) {
		this.roleMenus = roleMenus;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}

}
