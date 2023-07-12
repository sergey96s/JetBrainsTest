package com.example.jetbrainstest.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RubyPage {
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
        System.out.println("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public String clickrubyMineButtonCheckUrl() {
        driver.get("https://www.jetbrains.com/ruby/");
        rubyMineButton.click();
        System.out.println("Проверка урла страницы при переходе по кнопке 'RubyMine'");
        return driver.getCurrentUrl();
    }
    public Boolean checkPromotionButtonIsClickable() {
        System.out.println("Проверка активности кнопки загрузки");
        return promotionButton.isEnabled();
    }
    public RubyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public Boolean checkFirstScreenshotIsVisible() {
        System.out.println("Проверка отображения первого скриншота");
        return firstScreenshot.isDisplayed();
    }
}
