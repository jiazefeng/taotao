/**  
 */
package com.taotao.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.content.service.ContentService;
import com.taotao.jedis.JedisClient;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;

/**
 * @Title: ContentServiceImpl.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: Jiazefeng
 * @date: 2017年11月24日 上午11:30:27
 * @version V1.0
 */
@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private TbContentMapper contentMapper;

	@Autowired
	private JedisClient jedisClient;

	@Value("${INDEX_CONTENT}")
	private String INDEX_CONTENT;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.taotao.content.service.ContentService#addContent(com.taotao.pojo.
	 * TbContent)
	 */
	@Override
	public TaotaoResult addContent(TbContent content) {
		// 补全pojo属性
		content.setCreated(new Date());
		content.setUpdated(new Date());
		// 插入数据库
		contentMapper.insert(content);
		// 同步缓存
		// 删除对应的缓存信息
		jedisClient.hdel(INDEX_CONTENT, content.getCategoryId().toString());
		return TaotaoResult.ok();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.taotao.content.service.ContentService#getContentListByCid(long)
	 */
	@Override
	public List<TbContent> getContentListByCid(long cid) {
		// 先查询缓存
		// 添加缓存不能影响正常业务逻辑
		try {
			// 查询缓存
			String json = jedisClient.hget(INDEX_CONTENT, cid + "");
			// 查询到结果，把json转换成List返回
			if (StringUtils.isNotBlank(json)) {
				List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 缓存中没有命中，需要查询数据库
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		// 设置查询条件
		criteria.andCategoryIdEqualTo(cid);
		// 执行查询
		List<TbContent> list = contentMapper.selectByExample(example);
		// 把结果添加到缓存
		try {
			jedisClient.hset(INDEX_CONTENT, cid + "", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回结果
		return list;
	}

}
