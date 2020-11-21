package com.app.configuration;

public class PropertiesFile {

	private static String dsusername;		
	private static String dspassword;		
	private static String dsurl;			
	private static String dsdriverclassname;
	
	//hibernate
	private static String showSql;		
	private static String ddlAuto;;		
	private static String dialect;			
	private static String contextclass;
	
	
	
	
	
	
	
	
	public static String getDsusername() {
		return dsusername;
	}
	public static void setDsusername(String dsusername) {
		PropertiesFile.dsusername = dsusername;
	}
	public static String getDspassword() {
		return dspassword;
	}
	public static void setDspassword(String dspassword) {
		PropertiesFile.dspassword = dspassword;
	}
	public static String getDsurl() {
		return dsurl;
	}
	public static void setDsurl(String dsurl) {
		PropertiesFile.dsurl = dsurl;
	}
	public static String getDsdriverclassname() {
		return dsdriverclassname;
	}
	public static void setDsdriverclassname(String dsdriverclassname) {
		PropertiesFile.dsdriverclassname = dsdriverclassname;
	}
	public static String getShowSql() {
		return showSql;
	}
	public static void setShowSql(String showSql) {
		PropertiesFile.showSql = showSql;
	}
	public static String getDdlAuto() {
		return ddlAuto;
	}
	public static void setDdlAuto(String ddlAuto) {
		PropertiesFile.ddlAuto = ddlAuto;
	}
	public static String getDialect() {
		return dialect;
	}
	public static void setDialect(String dialect) {
		PropertiesFile.dialect = dialect;
	}
	public static String getContextclass() {
		return contextclass;
	}
	public static void setContextclass(String contextclass) {
		PropertiesFile.contextclass = contextclass;
	}
	
	
	
	
	
	
}
