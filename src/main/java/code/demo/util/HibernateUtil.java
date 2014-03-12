package code.demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// step 1. read hibernamte.cfg.xml
			Configuration con = new Configuration().configure();
			// step 2. create service registry object, load configuration
			StandardServiceRegistryBuilder regbulider = new StandardServiceRegistryBuilder()
					.applySettings(con.getProperties());
			// step 3. create service
			ServiceRegistry reg = regbulider.build();
			// step 4. create session factory.
			sessionFactory = con.buildSessionFactory(reg);
		}
		return sessionFactory;
	}

	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}
