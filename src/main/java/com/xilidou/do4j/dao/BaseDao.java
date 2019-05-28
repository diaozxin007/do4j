package com.xilidou.do4j.dao;

public interface BaseDao<T> {

	T get(String id);

	long save(T t);

}
