/**
 * 
 */
package com.bw.oa.service;

import java.util.List;

import com.bw.oa.domain.Menu;

/**
 * @author BoiledWate
 *
 */
public interface MenuService {
	public List<Menu> getMenuTreeNode(String menuId);
	
}
