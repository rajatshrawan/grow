package utilitypackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigData {
Properties prop;
public  ReadConfigData() {
	File src=new File("./config.properties");
	try {
	FileInputStream fis=new FileInputStream(src);
	prop=new Properties();
	prop.load(fis);
	}
	catch(Exception e){
		System.out.println("Exception is "+e.getMessage());
	}
}
	public String getApplicationUrl() 
	{
		String url=prop.getProperty("url");
		return url;
	}
	public String getUsername() 
	{
		String uname=prop.getProperty("username");
		return uname;
	}
	public String getPassword() 
	{
		String pwd=prop.getProperty("password");
		return pwd;
	}
	public String getChromePath()
	{
	String chromepath=prop.getProperty("chromepath");
	return chromepath;
	}
	public String getFireFox()
	{
	String firefox=prop.getProperty("firefoxpath");
	return firefox;
	}
	
}

