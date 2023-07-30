package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.rubypage.RubyFeaturesPage;
import com.example.jetbrainstest.pages.rubypage.RubyPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriver getDriver(){
        if (driver == null)
            createDriver();
        if (driver.toString().contains("(null)"))
            createDriver();
        return driver;
    }

    private static void createDriver(){
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\serzh\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }
    public RubyPage getRubyPage(){
        return new RubyPage(driver);
    }
    public RubyFeaturesPage getRubyFeaturesPage(){
        return new RubyFeaturesPage(driver);
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
