package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {
	
	public void init(){
		FileInputStream fis;
		Properties prop;
		try{
			fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\config.properties"));
			prop = new Properties();
			prop.load(fis);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
