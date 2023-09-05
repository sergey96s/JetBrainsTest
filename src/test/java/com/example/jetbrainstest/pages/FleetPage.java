package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FleetPage {

    WebDriver driver;

    @FindBy(css = "a[data-test='button' ][href='/fleet/download/']")
    private WebElement downloadButton;

    public Boolean checkIfDownloadButtonIsClickable() {
        System.out.println("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public FleetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css ="span > button:nth-child(2)")
    private WebElement DistributedButton;

        public Boolean checkIfDistributedButtonIsClickable () {
            System.out.println("Проверка кликабельности кнопки 'Distributed'");
            return DistributedButton.isEnabled();
        }
    }
