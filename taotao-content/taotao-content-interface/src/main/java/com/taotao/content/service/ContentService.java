/**  
 */
package com.taotao.content.service;

import java.util.List;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * @Title: ContentService.java
 * @Description: 内容Service
 * @author: Jiazefeng
 * @date: 2017年11月24日 上午11:29:19
 * @version V1.0
 */
public interface ContentService {

	TaotaoResult addContent(TbContent content);

	List<TbContent> getContentListByCid(long cid);
}
