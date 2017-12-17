package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.service.SearchItemService;

/**
 * 
 * Title: IndexManagerController
 * 
 * @Description: 索引库维护Controller
 * @author: Jiazefeng
 * @date: 2017年11月24日 上午11:34:40
 * @version V1.0
 */
@Controller
public class IndexManagerController {

	@Autowired
	private SearchItemService searchItemService;

	@RequestMapping("/index/import")
	@ResponseBody
	public TaotaoResult importIndex() {
		TaotaoResult taotaoResult = searchItemService.importItemsToIndex();
		return taotaoResult;
	}
}
