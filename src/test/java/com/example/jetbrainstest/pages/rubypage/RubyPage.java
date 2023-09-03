package com.example.jetbrainstest.pages.rubypage;


import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RubyPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(RubyPage.class));
    //    private final Logger LOG = LoggerFactory.getLogger(RubyPage.class);

    WebDriver driver;

    public RubyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".menu-second-title-box__title.wt-h3")
    private WebElement rubyMineButton;
    @FindBy(css = "a[data-test='button' ][href ='/ruby/download/']")
    private WebElement downloadButton;
    @FindBy(xpath = "//a[contains(text(), 'Get free 30‐day trial')]")
    private WebElement promotionButton;
    @FindBy(css = "img[src ='/ruby/img/screenshots/smart_editor@2x.png']")
    private WebElement firstScreenshot;
    @FindBy(xpath = "//div[contains(@class,'wt-container wt-offset-top-96')]")
    private List<WebElement> screenshotsInWhyBlock;
    @FindBy(css = "a[data-test='button'][href = '/ruby/features/']")
    private WebElement featureButton;
    @FindBy(css = "a[data-test='button'][href = '/ruby/whatsnew/']")
    private WebElement newFeatureButton;
    @FindBy(xpath = "//a[contains(@class, 'in-place-banner in-place-banner_ruby wt-h3 wt-h3_theme_dark banner js-banner inplace-banner')]")
    private WebElement statisticRubyBanner;
    @FindBy(xpath = "//input[contains(@placeholder, 'Business email address')]")
    private WebElement inputEmail;
    @FindBy(xpath = "//button[contains(text(), 'Request a call')]")
    private WebElement buttonRequestACall;
    @FindBy(xpath = "//div[contains(text(), 'Please enter a valid email address.')]")
    private WebElement errorMessageInvalidEmail;
    @FindBy(xpath = "//div[contains(text(), 'This field is required.')]")
    private WebElement errorMessageEmptyEmail;

    public Boolean checkIfDownloadButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public void clickFeaturesButton() {
        LOG.info("Переход на страницу Features");
        featureButton.click();
    }

    public void clickRubyMineButton() {
        LOG.info("Клик по кнопке 'RubyMine'");
        rubyMineButton.click();
    }

    public String сheckUrl() {
        LOG.info("Проверка урла страницы");
        return driver.getCurrentUrl();
    }

    public Boolean checkPromotionButtonIsClickable() {
        LOG.info("Проверка активности кнопки акции");
        return promotionButton.isEnabled();
    }

    public Boolean checkFirstScreenshotIsVisible() {
        LOG.info("Проверка отображения первого скриншота");
        return firstScreenshot.isDisplayed();
    }

    public Integer getCountOfScreenshotsInWhyBlock() {
        LOG.info("Проверка количества скриншотов в блоке Why Ruby");
        return screenshotsInWhyBlock.size();
    }

    public Boolean checkFeatureButtonIsClickable() {
        LOG.info("Проверка активности кнопки 'See All Features'");
        return featureButton.isEnabled();
    }

    public String clickFeatureButtonCheckUrl() {
        featureButton.click();
        LOG.info("Проверка урла страницы при переходе по кнопке 'See all feature'");
        return driver.getCurrentUrl();
    }

    public Boolean checkNewFeatureButtonIsClickable() {
        LOG.info("Проверка активности кнопки 'Discover All the New Features'");
        return newFeatureButton.isEnabled();
    }

    public String clickNewFeatureButtonCheckUrl() {
        newFeatureButton.click();
        LOG.info("Проверка урла страницы при переходе по кнопке 'Discover All the New Features'");
        return driver.getCurrentUrl();
    }

    public Boolean checkStatisticBannerIsClickable() {
        LOG.info("Проверка активности кнопки 'Nearly half of Ruby developers use RubyMine'");
        return statisticRubyBanner.isEnabled();
    }

    public Boolean checkStatisticBannerIsVisible() {
        LOG.infoWithScreenshot("Проверка видимости баннера, переводящего на страницу со статистикой использования разработчиками");
        return statisticRubyBanner.isDisplayed();
    }

    public String clickStatisticBannerCheckUrl() {
        statisticRubyBanner.click();
        LOG.info("Проверка урла страницы при переходе по кнопке 'Nearly half of Ruby developers use RubyMine'");
        return driver.getCurrentUrl();
    }

    public void enterBussinesEmail(String email) {
        LOG.infoWithScreenshot("Ввод email");
        inputEmail.sendKeys(email);
        buttonRequestACall.click();
    }

    public String enterInvalidBussinesEmailAndGetWarning(String email) {
        enterBussinesEmail(email);
        LOG.infoWithScreenshot("Получение сообщения при вводе невалидного email");
        return errorMessageInvalidEmail.getText();
    }

    public String enterEmptyBussinesEmailAndGetWarning(String email) {
        enterBussinesEmail(email);
        LOG.infoWithScreenshot("Получение сообщения при вводе пустого email");
        return errorMessageEmptyEmail.getText();
    }


}