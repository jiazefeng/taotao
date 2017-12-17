/**  
 */
package com.taotao.search.mapper;

import java.util.List;

import com.taotao.common.pojo.SearchItem;

/**
 * @Title: SearchItemMapp.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: Jiazefeng
 * @date: 2017年11月24日 下午10:42:18
 * @version V1.0
 */
public interface SearchItemMapper {
	
	List<SearchItem> getItemList();
	SearchItem getItemById(long itemId);
}
