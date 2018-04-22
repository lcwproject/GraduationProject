package com.graduate.laborManager.common.base.baseDao;

import java.util.List;
import java.util.Map;

public interface IBaseDao<E> {

    void insert(E entity) throws Exception;

    void insertList(List<E> entityList) throws Exception;

    void update(E entity) throws Exception;

    void updateList(List<E> entityList) throws Exception;

    void delete(E entity) throws Exception;

    List<E> selectList(String conditions, Map<String, Object> params, String orderFields) throws Exception;

    E findById(Object id) throws Exception;

}
