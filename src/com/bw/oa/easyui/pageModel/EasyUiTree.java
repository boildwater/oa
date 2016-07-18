/**
 * 
 */
package com.bw.oa.easyui.pageModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BoiledWater
 *
 */
public class EasyUiTree {
	private String id;
	private String text;
	private String iconCls;
	private String state;
	private String checked;
	private String pid;
	private Map<String,Object> attributes=new HashMap<String,Object>();
	public String getId() {
		return id;
	}
	public String getText() {
		return text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public String getState() {
		return state;
	}
	public String getChecked() {
		return checked;
	}
	public String getPid() {
		return pid;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	
	
}
