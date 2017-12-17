/**  
 */
package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;

/**
 * @Title: ItemCatService.java
 * @Description: 商品分类Service
 * @author: Jiazefeng
 * @date: 2017年11月21日 下午9:52:10
 * @version V1.0
 */
public interface ItemCatService {
	List<EasyUITreeNode> getItemCatList(long parentId);
}
