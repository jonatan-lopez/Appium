package helpers;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesHandler {

	public static String getProperty(File file, String property) {

		String value = "";
		try {

			FileReader reader = new FileReader(file);
			Properties properties = new Properties();
			properties.load(reader);
			value = properties.getProperty(property);
			System.out.println("value is : " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public static String readPropertyFile(String fileName, String property) {
		String value = "";
		try {

			FileReader reader = new FileReader(fileName);
			Properties properties = new Properties();
			properties.load(reader);
			value = properties.getProperty(property);
			System.out.println("value is : " + value);
			// return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

	public static Properties getProperties(String filePath) {
		Properties properties = new Properties();
		System.out.println(filePath);
		try {
			FileReader reader = new FileReader(filePath);
			properties.load(reader);
			// return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
}
