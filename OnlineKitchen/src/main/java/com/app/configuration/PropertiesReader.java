package com.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesReader {
	
	@Autowired
	Environment env;

	@Value("${spring.datasource.username}")
	private static String dsusername;
	
	@Value("${spring.datasource.password}")	
	private static String dspassword;
	
	@Value("${spring.datasource.url}")
	private static String dsurl;	
	
	@Value("${dsdriverclassname}")
	private static String dsdriverclassname;
	
	@Value("${spring.jpa.show-sql}")
	private static String showSql;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private static String ddlAuto;	
	
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private static String dialect;
	
	@Value("${spring.jpa.properties.hibernate.current_session_context_class}")
	private static String contextclass;

	public static String getDsusername() {
		System.out.println("--------------: "+ dsusername);
		return dsusername;
	}

	public static String getDspassword() {
		return dspassword;
	}

	public static String getDsurl() {
		return dsurl;
	}

	public static String getDsdriverclassname() {
		System.out.println("===========");
		return dsdriverclassname;
	}

	public static String getShowSql() {
		return showSql;
	}

	public static String getDdlAuto() {
		return ddlAuto;
	}

	public static String getDialect() {
		return dialect;
	}

	public static String getContextclass() {
		return contextclass;
	}
	
	
	
	
}
