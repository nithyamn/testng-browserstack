package com.browserstack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocalTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
        driver.get("http://bs-local.com:45691/check");
        //driver.get("http://localhost:8000/");
        //Assert.assertTrue(driver.getTitle().contains("Demo Site"));
    }
}
