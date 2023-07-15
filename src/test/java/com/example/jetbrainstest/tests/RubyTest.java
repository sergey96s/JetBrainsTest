package com.example.jetbrainstest.tests;

// page_url = https://www.jetbrains.com/ruby/

import com.example.jetbrainstest.AllureAttachmentsManager;
import com.example.jetbrainstest.MyExtension;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

 @ExtendWith(MyExtension.class)
 public class RubyTest extends BaseTest {

    @BeforeEach
    @Override
    @Step
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/ruby/");
    }
    @Test
    @DisplayName("Проверка, что кнопка скачивания активна")
    public void buttonCheck() {
        assertTrue(getRubyPage().checkIfDownloadButtonIsClickable(), "Кнопка скачивания не активна");
    }

    @Test
    @DisplayName("Проверка урла после клика")
    public void checkUrlAfterClickPyCharmButton() {
        Assertions.assertEquals(getRubyPage().clickrubyMineButtonCheckUrl(), "https://www.jetbrains.com/ruby/", "Урл не тот");
    }
    @Test
    @DisplayName("Проверяю активность кнопки акции на бесплатные 30 дней")
    public void buttonPromotionCheck() {
        assertTrue(getRubyPage().checkPromotionButtonIsClickable(), "Кнопка акции не активна");
        }
    @Test
    @DisplayName("Проверяю видимость первого скриншота")
    public void firstScreenshotIsVisible() {
        assertTrue(getRubyPage().checkFirstScreenshotIsVisible(), "Первый скриншот не виден");
    }
}