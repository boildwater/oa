/**
 * 
 */
package com.bw.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.oa.dao.MenuDao;
import com.bw.oa.domain.Menu;
import com.bw.oa.service.MenuService;
import com.bw.oa.utils.BwUtil;

/**
 * @author BoiledWater
 *
 */
@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {
	@Resource
	private MenuDao menuDaoImpl;
	@Override
	public List<Menu> getMenuTreeNode(String menuId) {
		if(BwUtil.isEmptyString(menuId)){
			return menuDaoImpl.getByHql("where parentMenu is null");
		}else
		{
			return menuDaoImpl.getByHql("where parentMenu.id="+menuId);
		}
	}
	
}
