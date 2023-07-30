package com.example.jetbrainstest.pages.rubypage;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RubyFeaturesPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(RubyFeaturesPage.class));
    WebDriver driver;
    public RubyFeaturesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li/a[contains(@data-test,'toc-item')]")
    private List<WebElement> sideBar;
    @FindBy(xpath = "//button[contains(@class,'_main_12yxkch_17 _modeClassic_12yxkch_135 _sizeM_12yxkch_99 _alignIconRight_12yxkch_81 _light_12yxkch_59 _flatLeft_12yxkch_130 _withIcon_12yxkch_119 _wtDownloadButton__right_7zoad _wtDownloadButton__right_95rvc')]")
    private WebElement exeListButton;
    @FindBy(xpath = "//span[contains(text(), '.exe (Windows)')]")
    private WebElement exeWindowsDownloadButton;
    @FindBy(xpath = "//div[contains(@class, 'f-img')]")
    private List<WebElement> imgFeatures;
    @FindBy(xpath = "//a[contains(@href, 'https://www.jetbrains.com/help/ruby/auto-completing-code.html')]")
    private WebElement buttonMoreIsAutocomplete;
    @FindBy(xpath = "//span[contains(text(), '.exe (Windows ARM64)')]")
    private WebElement exeWindowsArm64DownloadButton;
    public Integer getCountOfPointsSideBar() {
        LOG.infoWithScreenshot("Проверка, что на боковой панели 10 заголовков");
        return sideBar.size();
    }
    public void clickListExe() {
        LOG.infoWithScreenshot("Клик по выпадающему списку .exe");
        exeListButton.click();
    }
    public boolean checkWindowsExeDownloadButton() {
        LOG.infoWithScreenshot("Проверка работоспособности кнопки '.exe (Windows)' в выпадающем списке");
        return exeWindowsDownloadButton.isEnabled();
    }
    public Integer getCountOfImgFeatures() {
        LOG.infoWithScreenshot("Проверка количества изображений на странице");
        return imgFeatures.size();
    }
    public boolean checkButtonMoreIsAutocomplete() {
        LOG.infoWithScreenshot("Проверка работоспособности кнопки 'More' в блоке 'Autocomplete'");
        return buttonMoreIsAutocomplete.isEnabled();
    }
    public boolean checkVisibledButtonMoreIsAutocomplete() {
        LOG.infoWithScreenshot("Проверка видимости кнопки 'More' в блоке 'Autocomplete'");
        return buttonMoreIsAutocomplete.isDisplayed();
    }
    public boolean checkWindowsArm64ExeDownloadButton() {
        LOG.infoWithScreenshot("Проверка видимости кнопки '.exe (Windows ARM64)' в выпадающем списке");
        return exeWindowsArm64DownloadButton.isDisplayed();
    }
}
