package com.bw.oa.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 实体：岗位
 * 
 * @author boildwater
 * 
 */
public class Menu {
	private Long id;
	private String menuName;
	private String menuIcon;
	private String menuUrl;
	private Set<Role> menuRoles = new HashSet<Role>();
	private Menu parentMenu;
	private Set<Menu> childMenus=new HashSet<Menu>();
	public Long getId() {
		return id;
	}
	public String getMenuName() {
		return menuName;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public Set<Role> getMenuRoles() {
		return menuRoles;
	}
	public Menu getParentMenu() {
		return parentMenu;
	}
	public Set<Menu> getChildMenus() {
		return childMenus;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public void setMenuRoles(Set<Role> menuRoles) {
		this.menuRoles = menuRoles;
	}
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}
	public void setChildMenus(Set<Menu> childMenus) {
		this.childMenus = childMenus;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuName=" + menuName + ", menuIcon="
				+ menuIcon + ", menuUrl=" + menuUrl + ", menuRoles="
				+ menuRoles + ", parentMenu=" + parentMenu + "]";
	}



	
}
