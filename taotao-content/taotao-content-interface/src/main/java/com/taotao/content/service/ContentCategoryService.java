/**  
 */
package com.taotao.content.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

/**
 * @Title: ContentCategoryService.java
 * @Description: 内容分类Service
 * @author: Jiazefeng
 * @date: 2017年11月23日 下午10:12:09
 * @version V1.0
 */
public interface ContentCategoryService {
	/**
	 * 内容分类列表信息
	 * 
	 * @param parentId
	 * @return
	 */
	List<EasyUITreeNode> getContentCategoryList(long parentId);

	TaotaoResult addContentCategory(Long parentId, String name);

}
