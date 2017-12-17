/**  
 */
package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: PageController.java
 * @Description:页面展示Controller
 * @author: Jiazefeng
 * @date: 2017年11月21日 下午4:26:05
 * @version V1.0
 */
@Controller
public class PageController {
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
}
