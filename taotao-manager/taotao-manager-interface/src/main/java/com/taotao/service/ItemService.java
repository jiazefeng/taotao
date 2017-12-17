package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;

public interface ItemService {
	/**
	 * 根据ID获取商品信息
	 * 
	 * @param itemId
	 * @return
	 */
	TbItem getItemById(long itemId);

	/**
	 * 分页获取商品列表
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGridResult getItemList(int page, int rows);

	/**
	 * 新增商品
	 * 
	 * @param item
	 * @param desc
	 * @return
	 */
	TaotaoResult addItem(TbItem item, String desc);

	/**
	 * 获取商品详情
	 * 
	 * @param itemId
	 * @return
	 */
	TbItemDesc getItemDescById(long itemId);
}
