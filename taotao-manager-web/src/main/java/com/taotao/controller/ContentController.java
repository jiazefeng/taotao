/**  
 */
package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;

/**
 * @Title: ContentController.java
 * @Description: 内容管理Controller
 * @author: Jiazefeng
 * @date: 2017年11月24日 上午11:34:40
 * @version V1.0
 */
@Controller
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/content/save")
	@ResponseBody
	public TaotaoResult addContent(TbContent content) {
		TaotaoResult result = contentService.addContent(content);
		return result;
	}
}
