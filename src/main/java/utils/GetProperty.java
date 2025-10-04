package utils;

import java.io.IOException;
import java.util.Properties;

public class GetProperty {

	public static String getProps(Properties props, String prop)
			throws IOException {

		return props.getProperty(prop);
	}

}
