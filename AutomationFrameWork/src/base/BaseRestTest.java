package base;

import org.apache.log4j.Logger;

import utils.Configuration;

public class BaseRestTest {
	public static final Configuration _config;

    static {
        _config = new Configuration(false);
    }

    //Rally connection
    public Logger _logger;

    public BaseRestTest() {
        _logger = Logger.getLogger(BaseRestTest.class);

    }

}
