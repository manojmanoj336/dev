package com.app.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import com.app.shayari.dao.AppDao;



@Configuration
@SpringBootApplication
@EnableAutoConfiguration(exclude = { //
        DataSourceAutoConfiguration.class, //
        DataSourceTransactionManagerAutoConfiguration.class, //
        HibernateJpaAutoConfiguration.class })
@ComponentScan("com.app")

public class AppConfiguration  { //implements CommandLineRunner{

	@Autowired
	Environment env;
	
	@Autowired
	PropertiesFile p;
	
	 @Value("${dsdriverclassname}")
	 private String appTitle;	// jus for check that value is loaded or not by this way , it is loaded checked
	
	 @Bean
	 public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                .allowedOrigins("http://localhost:3000")
	                .allowedMethods("GET", "POST");
	                //.allowedOrigins("http://ec2-15-206-153-90.ap-south-1.compute.amazonaws.com:3000/");
	                
	            }
	        };
	    }
	
	@Bean   //@PostConstrut remove bcoz it has been completely removed from java 11
	public PropertiesFile getPropertiesFille()	
	{
		PropertiesFile  p=null;
		p = new PropertiesFile();
		
		try{
			PropertiesFile.setDsdriverclassname(env.getProperty("dsdriverclassname").isEmpty()?"" : env.getProperty("dsdriverclassname"));
			PropertiesFile.setDspassword((env.getProperty("spring.datasource.password").isEmpty()?"" : env.getProperty("spring.datasource.password")));
			PropertiesFile.setDsurl(env.getProperty("spring.datasource.url").isEmpty()?"" : env.getProperty("spring.datasource.url"));
			PropertiesFile.setDsusername(env.getProperty("spring.datasource.username").isEmpty()?"" : env.getProperty("spring.datasource.username"));
		
			PropertiesFile.setShowSql(env.getProperty("spring.jpa.show-sql").isEmpty()?"" : env.getProperty("spring.jpa.show-sql"));
			PropertiesFile.setDdlAuto(env.getProperty("spring.jpa.hibernate.ddl-auto").isEmpty()?"" : env.getProperty("spring.jpa.hibernate.ddl-auto"));
			PropertiesFile.setDialect(env.getProperty("spring.jpa.properties.hibernate.dialect").isEmpty()?"" : env.getProperty("spring.jpa.properties.hibernate.dialect"));
			PropertiesFile.setContextclass(env.getProperty("spring.jpa.properties.hibernate.current_session_context_class").isEmpty()?"" : env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
			
		
		
		
		
		
		}catch(Exception e){
		//	Log.notice.info("Exception occured during loading  Property file........ |Exception: "+ e);
			System.out.println("Exception occured during loading  Property file........ |Exception: "+ e);
			System.out.println("Exception occuered while properites loading");
		}		
		return p;
	}
	
	
	
	
	
	
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
        System.out.println("inside datasource: "+ PropertiesFile.getDsdriverclassname());
        dataSource.setDriverClassName(PropertiesFile.getDsdriverclassname());
        dataSource.setUrl(PropertiesFile.getDsurl());
        dataSource.setUsername(PropertiesFile.getDsusername());
        dataSource.setPassword(PropertiesFile.getDspassword());
 
        System.out.println("## getDataSource: " + dataSource);
 
        return dataSource;
    }
	
	@Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();
      //  properties.put("hibernate.hbm2ddl.auto", PropertiesFile.getDdlAuto());
        properties.put("hibernate.dialect", PropertiesFile.getDialect());
        properties.put("hibernate.show_sql", PropertiesFile.getShowSql());
        properties.put("current_session_context_class",PropertiesFile.getContextclass());
        return properties;        
    }
    
	@Bean(name="sessionFactory")
	SessionFactory getSessionFactory()	{
		try{
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan(new String[] { "" });
		factoryBean.setDataSource(getDataSource());
		factoryBean.setHibernateProperties(getHibernateProperties());
		factoryBean.afterPropertiesSet();
		SessionFactory sf = factoryBean.getObject();
		System.out.println("## getSessionFactory: " + sf);
		return sf;
		}catch(Exception e)
		{
		System.out.println("exception occured duing creation of sessionFactory...."+ e);
		}
		return null;
	}
	
	@Bean(name="trasactionManager")
   // @Autowired
    public HibernateTransactionManager transactionManager() {
		try{
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(getSessionFactory());
       return txManager;
		}catch(Exception e)
		{
			System.out.println("error whiletransactionManager "+ e);
		}
		return null;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {	
		
		SpringApplication.run(AppConfiguration.class, args);		
	}



	/*@Autowired
	AppDao d;
*/

	/*@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		AppDao dao = new AppDao();
		try{
			System.out.println("helo------------");
			//d.dataInserted();
			dao.dataInserted(getSessionFactory());
		}catch(Exception e)
		{
			//System.out.println("==============="+ d);
		
			System.out.println(e);
		}
		
		
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
}
