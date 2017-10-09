package com.websystique.spring.service;

import java.util.Set;


public interface CustomService {

	void saveObject(Object o);

	Set<Object> findAllObject();

	void deleteObjectById(long id);

	Object findById(long id);

	void updateObject(Object o);
}
