package com.app.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
/*
import com.app.shayari.model.ShayariLanguages;
import com.app.shayari.model.Shayari;
*/



//this class is use to create session factory
//but 

public class HibernateUtil {

	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	//hibernate 5;
	public static SessionFactory buildSessionFactory() {
           try {
            Configuration configuration = new Configuration();
            // Hibernate settings equivalent to hibernate.cfg.xml's properties
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/temp");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "manoj");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            settings.put(Environment.SHOW_SQL, true);
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "org.springframework.orm.hibernate5.SpringSessionContext");
            settings.put(Environment.HBM2DDL_AUTO, "create");
            configuration.setProperties(settings);
         /*   configuration.addAnnotatedClass(Shayari.class);
            configuration.addAnnotatedClass(ShayariLanguages.class);*/
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
            
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
         // return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    //return sessionFactory;
}	
	
	
	//return session factory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//close cache and  connection pool
	public static void shutdown() {
		getSessionFactory().close();
	}
	
	
	
	
	
	
}
