/**
 * 
 */
package com.bw.oa.view.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.bw.oa.base.baseServletAction;
import com.bw.oa.domain.Menu;
import com.bw.oa.easyui.pageModel.EasyUiTree;
import com.bw.oa.easyui.pageModel.EasyUiTreeGrid;
import com.bw.oa.service.MenuService;
import com.bw.oa.utils.BwUtil;

/**
 * @author BoiledWater
 *
 */
@SuppressWarnings("serial")
//加上注解，交给spring进行管理.
@Controller
@Scope("prototype")
@Transactional
public class MenuAction extends baseServletAction {
	@Resource
	private MenuService menuServiceImpl;
	public String execute() throws Exception {
		String menuId=request.getParameter("id");
		String moduleId=request.getParameter("moduleId");
		if (BwUtil.isEmptyString(menuId) && !BwUtil.isEmptyString(moduleId)) {
			menuId = moduleId;
		}
		List<Menu> menus=menuServiceImpl.getMenuTreeNode(menuId);
		List<EasyUiTree> tree=new ArrayList<EasyUiTree>();
		for (Menu m : menus) {
			EasyUiTree t = new EasyUiTree();
			t.setId(m.getId().toString());
			if (m.getParentMenu() != null) {
				t.setPid(m.getParentMenu().getId().toString());
			}
			if(m.getChildMenus()!=null && !m.getChildMenus().isEmpty()){
				t.setState("closed");
			}
			t.setText(m.getMenuName());
			t.getAttributes().put("url", m.getMenuUrl());
			t.setIconCls(m.getMenuIcon());
			tree.add(t);
		}
		super.writeJson(tree);
		return null;
	}
	public String getMenuTreeGrid(){
		String treeGridId=request.getParameter("id");
		List<Menu> menus=menuServiceImpl.getMenuTreeNode(treeGridId);
		List<EasyUiTreeGrid> treeGrid=new ArrayList<EasyUiTreeGrid>();
		for(Menu m:menus){
			EasyUiTreeGrid t=new EasyUiTreeGrid();
			t.setName(m.getMenuName());
			t.setId(m.getId().toString());
			t.setIconCls(m.getMenuIcon());
			t.setUrl(m.getMenuUrl());
			treeGrid.add(t);
		}
		super.writeJson(treeGrid);
		return null;
	}

}
