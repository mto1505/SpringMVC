/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.Properties;

/**
 *
 * @author MinhTo
 */
public class PropertiseUtil {
private static Properties properties;
	static{
		try {
		    //Get the current classPath path
			String url =  PropertiseUtil.class.getResource("/").toString().replace("file:/", "");
			File file=new File(url);
			//Get all *.properties files under the project
			File[] files = file.listFiles(new FilenameFilter(){ /// danh sách file bên trong thu mục của project

				@Override
				public boolean accept(File dir, String name) {
					if(name.endsWith(".properties")){
						return true;
					}
					return false;
				}
				
			});
			properties=new Properties();
			for(File f:files){ // lọc qua từng file
				Properties p=new Properties();
				FileInputStream in=new FileInputStream(f);// tạo luồng đọc file f
				p.load(in); //tải dữ liệu từ đối tượng in FileinputStream 
				properties.putAll(p); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Get the configured value according to the key
	*/
	public String getValue(String key,String defaultValue){
		String value = properties.getProperty(key, defaultValue);
		return value;
	}
    
}
