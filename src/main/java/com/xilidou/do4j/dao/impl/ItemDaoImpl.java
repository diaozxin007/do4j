package com.xilidou.do4j.dao.impl;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import com.xilidou.do4j.dao.ItemDao;
import com.xilidou.do4j.entity.ItemEntity;
import org.springframework.stereotype.Repository;


@Repository
public class ItemDaoImpl implements ItemDao {

	@Override
	public ItemEntity get(String id) {

		AVQuery<ItemEntity> query = AVObject.getQuery(ItemEntity.class);

		return query.get(id);

	}

	@Override
	public long save(ItemEntity itemEntity) {

		itemEntity.save();

		return 0;
	}
}
