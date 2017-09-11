package com.transavia.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @author venisridhar
 */
public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static homePage home;


    @BeforeClass(alwaysRun = true)
    public void startBrowser() {

        try {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\venisridhar\\IdeaProjects\\transavia\\src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get("https://www.transavia.com/en-NL/home/");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 5);
            setDriver(driver);
             home = PageFactory.initElements(driver, homePage.class);
            // setDriver(driver);
        } catch (Throwable t) {
            driver.close();
            Assert.fail("Exception thrown while opening browser");
            Reporter.log("Exception thrown while opening browser");

        }
    }
    /**
     * Get Driver
     *
     * @return
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Set Driver
     *
     * @param driver
     */
    public static void setDriver(WebDriver driver) {
        TestBase.driver = driver;
    }
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();
        } catch (Exception e) {
            Reporter.log("Completed the execution");
        }
    }
    public static String getCurrentdate(){
        DateFormat dateformat = new SimpleDateFormat("ddMMyyyyhhmmss", Locale.ENGLISH);
        Calendar actual = Calendar.getInstance();
        return dateformat.format(actual.getTime());
    }
}
