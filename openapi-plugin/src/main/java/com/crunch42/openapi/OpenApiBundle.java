package com.crunch42.openapi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class OpenApiBundle {

	private static final URL BASE_URL = OpenAPIAbstractUIPlugin.getInstance().getBundle().getEntry("/");
	private static ResourceBundle resourceBundle = null;

    static {
		try {
			URL url = new URL(BASE_URL, "resources/messages/OpenApiBundle.properties");
			InputStream inputStream = OpenApiBundle.class.getResourceAsStream(url.getFile());
			resourceBundle = new PropertyResourceBundle(inputStream);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static String message(String key) {
		try {
			return resourceBundle.getString(key);
		} 
		catch (MissingResourceException e) {
			return key;
		} 
		catch (NullPointerException e) {
			return "!" + key + "!";
		}	
    }
}