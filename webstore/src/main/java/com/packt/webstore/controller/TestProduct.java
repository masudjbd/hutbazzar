package com.packt.webstore.controller;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.bangla.store.domain.Product;

public class TestProduct {

	private static final SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		// fill the database

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
			iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
			iphone.setCategory("Smart Phone");
			iphone.setManufacturer("Apple");
			iphone.setUnitsInStock(1000);
			session.save(iphone);
			
			// TODO update HQL
			@SuppressWarnings("unchecked")
			Query query = session
					.getNamedQuery("Product.All");
			List<Product> plist = query.list();
			
			for(Product p: plist)
				System.out.println("name: "+p.getName());


			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace(System.err);
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
}
