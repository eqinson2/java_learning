package com.eqinson.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.eqinson.hibernate.beans.User;
import com.eqinson.hibernate.util.HibernateSessionFactory;

public class UserDAOImpl implements UserDAO {
	// 按用户名查询
	public User select(String username) {
		Session session = null;
		User record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from User where username=:username");
			query.setString("username", username.trim());
			record = (User) query.uniqueResult();
			query = null;
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return record;
	}

	// 插入用户
	public Integer insert(User record) {
		Session session = null;
		Transaction tx = null;
		Integer id = null;
		try {
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			session.save(record);
			id = record.getId();
			tx.commit();
		} catch (HibernateException e) {
			throw e;
		} finally {
			if (tx != null) {
				tx.rollback();
			}
			HibernateSessionFactory.closeSession();
		}
		return id;
	}
}
