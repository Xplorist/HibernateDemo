package com.voidx.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
  *	Hibernate Session Factory 工具類
  * @author C3005579
  * @date 2019年2月25日 下午4:26:26 
  */
public class HibernateSessionUtil {
	private static SessionFactory sessionFactory = null;
	
	private static void initSessionFactory() {
		//File file = new File("/hibernate.cfg.xml");
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
			e.printStackTrace();
		}
	}
	
	public static Session openSession() {
		if(sessionFactory == null) {
			initSessionFactory();
		}
		
		return sessionFactory.openSession();
	}
	
}
