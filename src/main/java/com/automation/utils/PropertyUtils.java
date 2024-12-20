package com.automation.utils;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.automation.enums.ConfigProperties;

public class PropertyUtils {

	static Map<String, String> map = new HashMap<String, String>();
	
	
	
static {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Data/configProperties");
			prop.load(fis);
			
			for(Object key : prop.keySet())
			{
				map.put((String.valueOf(key)), (String.valueOf(prop.get(key))));
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperty(ConfigProperties key)
	{
		String value = map.get(key.name().toLowerCase());
		if(value!=null)
		{
			return value.toLowerCase();
		}
		else
		return "Key not found";
		
	
		
	
		
	}
	
//	public static void main(String[] args) {
//	
//		
//		System.out.println(getConfig(ConfigProperties.BROWSER));
//	}
}
