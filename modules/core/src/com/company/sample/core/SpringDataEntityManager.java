package com.company.sample.core;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;

public class SpringDataEntityManager implements EntityManager {

    private com.haulmont.cuba.core.EntityManager cubaEm;

    public SpringDataEntityManager(com.haulmont.cuba.core.EntityManager cubaEm) {
        this.cubaEm = cubaEm;
    }

    @Override
    public void persist(Object entity) {
        cubaEm.persist((com.haulmont.cuba.core.entity.Entity) entity);
    }

    @Override
    public Object merge(Object entity) {
        return cubaEm.merge((com.haulmont.cuba.core.entity.Entity) entity);
    }

    @Override
    public void remove(Object entity) {
        cubaEm.remove((com.haulmont.cuba.core.entity.Entity) entity);
    }

    @Override
    public Object find(Class entityClass, Object primaryKey) {
        return cubaEm.find(entityClass, primaryKey);
    }

    @Override
    public Object find(Class entityClass, Object primaryKey, Map properties) {
        return cubaEm.find(entityClass, primaryKey);
    }

    @Override
    public Object find(Class entityClass, Object primaryKey, LockModeType lockMode) {
        return cubaEm.find(entityClass, primaryKey);
    }

    @Override
    public Object find(Class entityClass, Object primaryKey, LockModeType lockMode, Map properties) {
        return cubaEm.find(entityClass, primaryKey);
    }

    @Override
    public Object getReference(Class entityClass, Object primaryKey) {
        return cubaEm.getReference(entityClass, primaryKey);
    }

    @Override
    public void flush() {
        cubaEm.flush();
    }

    @Override
    public void setFlushMode(FlushModeType flushMode) {
        cubaEm.getDelegate().setFlushMode(flushMode);
    }

    @Override
    public FlushModeType getFlushMode() {
        return cubaEm.getDelegate().getFlushMode();
    }

    @Override
    public void lock(Object entity, LockModeType lockMode) {
        cubaEm.getDelegate().lock(entity, lockMode);
    }

    @Override
    public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {
        cubaEm.getDelegate().lock(entity, lockMode, properties);
    }

    @Override
    public void refresh(Object entity) {
        cubaEm.getDelegate().refresh(entity);
    }

    @Override
    public void refresh(Object entity, Map<String, Object> properties) {
        cubaEm.getDelegate().refresh(entity, properties);
    }

    @Override
    public void refresh(Object entity, LockModeType lockMode) {
        cubaEm.getDelegate().refresh(entity, lockMode);
    }

    @Override
    public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
        cubaEm.getDelegate().refresh(entity, lockMode, properties);
    }

    @Override
    public void clear() {
        cubaEm.getDelegate().clear();
    }

    @Override
    public void detach(Object entity) {
        cubaEm.getDelegate().detach(entity);
    }

    @Override
    public boolean contains(Object entity) {
        return cubaEm.getDelegate().contains(entity);
    }

    @Override
    public LockModeType getLockMode(Object entity) {
        return cubaEm.getDelegate().getLockMode(entity);
    }

    @Override
    public void setProperty(String propertyName, Object value) {
        cubaEm.getDelegate().setProperty(propertyName, value);
    }

    @Override
    public Map<String, Object> getProperties() {
        return cubaEm.getDelegate().getProperties();
    }

    @Override
    public Query createQuery(String qlString) {
        com.haulmont.cuba.core.Query query = cubaEm.createQuery(qlString);
        return query.getDelegate();
    }

    @Override
    public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
        return cubaEm.getDelegate().createQuery(criteriaQuery);
    }

    @Override
    public Query createQuery(CriteriaUpdate updateQuery) {
        return cubaEm.getDelegate().createQuery(updateQuery);
    }

    @Override
    public Query createQuery(CriteriaDelete deleteQuery) {
        return cubaEm.getDelegate().createQuery(deleteQuery);
    }

    @Override
    public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
        com.haulmont.cuba.core.Query query = cubaEm.createQuery(qlString, resultClass);
        return (TypedQuery<T>) query.getDelegate();
    }

    @Override
    public Query createNamedQuery(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Query createNativeQuery(String sqlString) {
        com.haulmont.cuba.core.Query query = cubaEm.createNativeQuery(sqlString);
        return query.getDelegate();
    }

    @Override
    public Query createNativeQuery(String sqlString, Class resultClass) {
        com.haulmont.cuba.core.Query query = cubaEm.createNativeQuery(sqlString, resultClass);
        return query.getDelegate();
    }

    @Override
    public Query createNativeQuery(String sqlString, String resultSetMapping) {
        return cubaEm.getDelegate().createNativeQuery(sqlString, resultSetMapping);
    }

    @Override
    public StoredProcedureQuery createNamedStoredProcedureQuery(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String procedureName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String procedureName, Class... resultClasses) {
        throw new UnsupportedOperationException();
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String procedureName, String... resultSetMappings) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void joinTransaction() {
        cubaEm.getDelegate().joinTransaction();
    }

    @Override
    public boolean isJoinedToTransaction() {
        return cubaEm.getDelegate().isJoinedToTransaction();
    }

    @Override
    public <T> T unwrap(Class<T> cls) {
        return cubaEm.getDelegate().unwrap(cls);
    }

    @Override
    public Object getDelegate() {
        return cubaEm.getDelegate().getDelegate();
    }

    @Override
    public void close() {
        cubaEm.getDelegate().close();
    }

    @Override
    public boolean isOpen() {
        return cubaEm.getDelegate().isOpen();
    }

    @Override
    public EntityTransaction getTransaction() {
        return cubaEm.getDelegate().getTransaction();
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return cubaEm.getDelegate().getEntityManagerFactory();
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        return cubaEm.getDelegate().getCriteriaBuilder();
    }

    @Override
    public Metamodel getMetamodel() {
        return cubaEm.getDelegate().getMetamodel();
    }

    @Override
    public <T> EntityGraph<T> createEntityGraph(Class<T> rootType) {
        return cubaEm.getDelegate().createEntityGraph(rootType);
    }

    @Override
    public EntityGraph<?> createEntityGraph(String graphName) {
        return cubaEm.getDelegate().createEntityGraph(graphName);
    }

    @Override
    public EntityGraph<?> getEntityGraph(String graphName) {
        return cubaEm.getDelegate().getEntityGraph(graphName);
    }

    @Override
    public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass) {
        return cubaEm.getDelegate().getEntityGraphs(entityClass);
    }
}
