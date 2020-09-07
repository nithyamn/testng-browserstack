package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
        String username = BrowserStackTestNGTest.username;
        String accesskey = BrowserStackTestNGTest.accessKey;

        
        driver.get("https://www.google.com/ncr");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack");
        element.submit();
        SessionId session = ((RemoteWebDriver) driver).getSessionId();
        System.out.println(session);

        if(title.contains("BrowserStack"))
            TestStatus.mark(session,"passed", username, accesskey);
        else
            TestStatus.mark(session,"failed", username, accesskey);
    }
}
