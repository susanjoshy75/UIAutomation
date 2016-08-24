package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utils.ExcelUtils;
import utils.rest.RESTUtil;

public class BaseApiTest extends BaseRestTest{
	public RESTUtil restUtil;
    public ExcelUtils excelUtils;

    @BeforeSuite
    public void beforeSuite() {
        restUtil = new RESTUtil(_config);
        excelUtils = new ExcelUtils();
    }

    @AfterSuite
    public void afterSuite() {
        restUtil = null;
        excelUtils = null;
    }


}
