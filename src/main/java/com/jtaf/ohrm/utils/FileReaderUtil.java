package com.jtaf.ohrm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class FileReaderUtil {

	public static Logger log = Logger.getLogger("devpinoyLogger");

	public static Properties properties = new Properties();
	public static File configFileObj, ObjectRepoFileObj;
	public static FileInputStream configfileInputStream, ObjectRepofileInputStream;
	// public static String objectRepoPath =
	// "\\src\\test\\resources\\com\\jtaf\\properties\\objectrepo.properties";
	public static String configPath = "\\src\\test\\resources\\com\\jtaf\\properties\\config.properties";

	public static void loadPropertyFiles() {

		configFileObj = new File(System.getProperty("user.dir") + configPath);
		// ObjectRepoFileObj = new File(System.getProperty("user.dir") +
		// objectRepoPath);
		try {
			configfileInputStream = new FileInputStream(configFileObj);
			// ObjectRepofileInputStream = new FileInputStream(ObjectRepoFileObj);
			properties.load(configfileInputStream);
			// properties.load(ObjectRepofileInputStream);
			log.debug("Config & Object Repository property files are loaded !!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDataFromPropFile(String key) {

		String dataFromPropFile = null;
		if (key != null && properties != null) {
			dataFromPropFile = properties.getProperty(key).trim();
		}
		return dataFromPropFile;
	}
}
