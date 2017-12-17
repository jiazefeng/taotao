/**  
 */
package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Title:  EasyUIDataGridResult.java    
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: Jiazefeng    
 * @date:   2017年11月21日 下午4:58:47   
 * @version V1.0  
 */
public class EasyUIDataGridResult implements Serializable{
	private  long total;
	private List rows;
	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	/**
	 * @return the rows
	 */
	public List getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(List rows) {
		this.rows = rows;
	}
	

}
