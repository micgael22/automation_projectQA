package com.ultimateQA.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
@Listeners({TestListeners.class})

public class BaseTest {
    protected WebDriver driver;
    protected Logger log;
    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @Parameters({ "browser", "chromeProfile", "deviceName" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, @Optional String profile, @Optional String deviceName, ITestContext ctx) {

        System.out.println("[---------ON SETUP ---------]");

        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        if (profile != null) {
            driver = factory.createChromeWithProfile(profile);
        } else if (deviceName != null) {
            driver = factory.createChromeWithMobileEmulation(deviceName);
        } else {
            driver = factory.createDriver();
        }

        // This sleep is (optional).
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();

        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();

        System.out.println("[---------SETUP DONE---------]");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("[---------CLOSE DRIVER & TEARDOWN---------]");
        driver.quit();
    }
}
