package com.graduate.laborManager.common.base.baseDao.impl;

import com.graduate.laborManager.common.base.baseDao.IBaseDao;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"unchecked"})
public abstract class BaseDaoImpl<E> implements IBaseDao<E> {

    @PersistenceContext
    protected EntityManager em;
    private Class<E> entityClass;

    public BaseDaoImpl() {
        super();
        this.entityClass = null;
        this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Class<E> getEntityClass() {
        return this.entityClass;
    }

    protected String getEntityName() {
        return this.getEntityClass().getSimpleName();
    }

    @Transactional
    public void insert(E entity) throws Exception {
        this.em.persist(entity);
    }

    @Transactional
    public void insertList(List<E> entityList) throws Exception {
        for (int i=0;i<entityList.size();i++){
            E entity = entityList.get(0);
            this.em.persist(entity);
        }
    }

    @Transactional
    public void update(E entity) throws Exception {
        this.em.persist(entity);
    }

    @Transactional
    public void updateList(List<E> entityList) throws Exception {
        for (int i=0;i<entityList.size();i++){
            E entity = entityList.get(0);
            this.em.merge(entity);
        }
    }

    @Transactional
    public void delete(E entity) throws Exception {
        this.em.remove(this.em.merge(entity));
    }

    public List<?> selectNativeSqlList(String sql, Map<String, Object> params, Class<?> entityClass) throws Exception {
        Query query = this.em.createNativeQuery(sql);
        this.setParams(query, params);
        ((SQLQuery)query.unwrap(SQLQuery.class)).setResultTransformer(Transformers.aliasToBean(entityClass));
        return query.getResultList();
    }

    @Transactional
    public void createUpdateSql(String sql, Map<String, Object> params) throws Exception {
        Query query = this.em.createNativeQuery(sql);
        this.setParams(query, params);
        query.executeUpdate();
    }

    public List<E> selectList(String conditions, Map<String, Object> params, String orderFields) throws Exception {
        Query query = null;
        StringBuffer sbWhere = new StringBuffer("");
        if (conditions != null && conditions.length() > 0) {
            conditions = conditions.trim();
            sbWhere.append(" WHERE ").append(conditions);
        }

        String hql = "SELECT t FROM " + this.getEntityName() + " t ";
        query = this.em.createQuery(hql + sbWhere + (orderFields == null ? "" : " ORDER BY " + orderFields));
        if (params != null && params.size() > 0) {
            Iterator var7 = params.entrySet().iterator();

            while(var7.hasNext()) {
                Map.Entry<String, Object> e = (Map.Entry)var7.next();
                query.setParameter((String)e.getKey(), e.getValue());
            }
        }

        return query.getResultList();
    }

    public E findById(Object id) throws Exception {
        return this.em.find(this.getEntityClass(), id);
    }

    private void setParams(Query query, Map<String, Object> params) {
        if (params != null && params.size() > 0) {
            Iterator var3 = params.entrySet().iterator();

            while(var3.hasNext()) {
                Map.Entry<String, Object> e = (Map.Entry)var3.next();
                query.setParameter((String)e.getKey(), e.getValue());
            }
        }

    }
}
