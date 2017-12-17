/**  
 */
package com.taotao.common.pojo;

import java.io.Serializable;

/**
 * @Title:  EasyUITreeNode.java    
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: Jiazefeng    
 * @date:   2017年11月21日 下午9:46:36   
 * @version V1.0  
 */
public class EasyUITreeNode implements Serializable{
	private long id;
	private String text;
	private String state;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
