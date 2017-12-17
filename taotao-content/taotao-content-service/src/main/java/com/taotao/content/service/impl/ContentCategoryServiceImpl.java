/**  
 */
package com.taotao.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;

/**
 * @Title: ContentCategoryServiceImpl.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: Jiazefeng
 * @date: 2017年11月23日 下午10:21:44
 * @version V1.0
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.taotao.content.service.ContentCategoryService#getContentCategoryList(
	 * long)
	 */
	@Override
	public List<EasyUITreeNode> getContentCategoryList(long parentId) {
		// 根据parentID查询子节点列表
		TbContentCategoryExample contentCategoryExample = new TbContentCategoryExample();
		// 设置查询条件
		Criteria criteria = contentCategoryExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(contentCategoryExample);
		List<EasyUITreeNode> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
			// 返回列表信息
			resultList.add(node);
		}
		return resultList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.taotao.content.service.ContentCategoryService#addContentCategory(java
	 * .lang.Long, java.lang.String)
	 */
	@Override
	public TaotaoResult addContentCategory(Long parentId, String name) {
		// 创建一个pojo对象
		TbContentCategory contentCategory = new TbContentCategory();
		// 补全对象的属性
		contentCategory.setParentId(parentId);
		contentCategory.setName(name);
		// 状态 1(正常)，2(删除)
		contentCategory.setStatus(1);
		// 默认排序为 1
		contentCategory.setSortOrder(1);
		contentCategory.setIsParent(false);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		// 插入数据库
		contentCategoryMapper.insert(contentCategory);
		// 判断父节点的状态
		TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
		if (!parent.getIsParent()) {
			// 如果父节点为叶子节点应该改为父节点
			parent.setIsParent(true);
			// 更新父节点
			contentCategoryMapper.updateByPrimaryKey(parent);
		}
		// 返回结果
		return TaotaoResult.ok(contentCategory);
	}

}
