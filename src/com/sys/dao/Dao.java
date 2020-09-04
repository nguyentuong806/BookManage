package com.sys.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	List<T> getAll();
	T get(int id);
	boolean insert(T t);
	boolean update(T t);
	boolean delete(int id);
}
