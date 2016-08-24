package base;


import org.apache.log4j.Logger;

import utils.Configuration;

public abstract class BaseTest {

public static final Configuration _config;

static {
    _config = new Configuration(true);
}

//Rally connection
public Logger _logger;

public BaseTest() {
    _logger = Logger.getLogger(BaseTest.class);

}
}
