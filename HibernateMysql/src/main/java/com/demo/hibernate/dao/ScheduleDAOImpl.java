package com.demo.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.demo.hibernate.beans.Schedule;
import com.demo.hibernate.util.HibernateSessionFactory;
import com.demo.hibernate.util.Pager;

public class ScheduleDAOImpl implements ScheduleDAO {
	public Pager list(String username, int pageSize, int pageNo) {
		Session session = null;
		Pager pager = null;
		try {
			session = HibernateSessionFactory.currentSession();

			Criteria criteria = session.createCriteria(Schedule.class);
			criteria.add(Restrictions.eq("username", username));

			int rowCount = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
			criteria.setProjection(null);

			int startIndex = pageSize * (pageNo - 1);

			criteria.addOrder(Order.desc("year"));
			criteria.addOrder(Order.desc("month"));
			criteria.addOrder(Order.desc("day"));
			criteria.setFirstResult(startIndex);
			criteria.setMaxResults(pageSize);
			List<?> result = criteria.list();
			pager = new Pager(pageSize, pageNo, rowCount, result);
		} catch (HibernateException e) {
			pager = new Pager(pageSize, pageNo, 0, new ArrayList<Object>());
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return pager;
	}

	public Schedule select(Integer id) {
		Session session = null;
		Schedule record = null;
		try {
			session = HibernateSessionFactory.currentSession();
			Query query = session.createQuery("from Schedule where id=?");
			query.setInteger(0, id);
			record = (Schedule) query.uniqueResult();
			query = null;
		} catch (HibernateException e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return record;
	}

	public Integer insert(Schedule record) {
		Session session = null;
		Transaction tx = null;
		Integer id = null;
		try {
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			session.save(record);
			id = record.getId();
			tx.commit();
			tx = null;
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

	public boolean update(Schedule record) {
		Session session = null;
		Transaction tx = null;
		boolean b = true;
		try {
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			session.update(record);
			tx.commit();
			tx = null;
		} catch (HibernateException e) {
			b = false;
			throw e;
		} finally {
			if (tx != null) {
				tx.rollback();
			}
			HibernateSessionFactory.closeSession();
		}
		return b;
	}

	public boolean delete(Schedule record) {
		Session session = null;
		Transaction tx = null;
		boolean b = true;
		try {
			session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			session.delete(record);
			tx.commit();
			tx = null;
		} catch (HibernateException e) {
			b = false;
			throw e;
		} finally {
			if (tx != null) {
				tx.rollback();
			}
			HibernateSessionFactory.closeSession();
		}
		return b;
	}

}
