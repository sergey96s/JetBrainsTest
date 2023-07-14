package com.example.jetbrainstest.pages;


import com.example.jetbrainstest.AllureLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RubyPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(RubyPage.class));
//    private final Logger LOG = LoggerFactory.getLogger(RubyPage.class);
    WebDriver driver;
    @FindBy(css = ".menu-second-title-box__title.wt-h3")
    private WebElement rubyMineButton;
    @FindBy(css = "a[data-test='button' ][href ='/ruby/download/']")
    private WebElement downloadButton;

    @FindBy(xpath = "//a[contains(@class,'_main_1e63mqc_17 _modeRock_1e63mqc_208 _sizeM_1e63mqc_99 _alignIconLeft_1e63mqc_77 _light_1e63mqc_59 wt-offset-top-48')]")
    private WebElement promotionButton;
    @FindBy(css = "img[src ='/ruby/img/screenshots/smart_editor@2x.png']")
    private WebElement firstScreenshot;

    public Boolean checkIfDownloadButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }
    public String clickrubyMineButtonCheckUrl() {
        driver.get("https://www.jetbrains.com/ruby/");
        rubyMineButton.click();
        LOG.info("Проверка урла страницы при переходе по кнопке 'RubyMine'");
        return driver.getCurrentUrl();
    }
    public Boolean checkPromotionButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки");
        return promotionButton.isEnabled();
    }
    public Boolean checkFirstScreenshotIsVisible() {
        LOG.info("Проверка отображения первого скриншота");
        return firstScreenshot.isDisplayed();
    }
    public RubyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
