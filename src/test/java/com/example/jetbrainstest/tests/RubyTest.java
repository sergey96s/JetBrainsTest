package com.example.jetbrainstest.tests;

// page_url = https://www.jetbrains.com/ruby/
import com.example.jetbrainstest.pages.IntellijIdeaPage;
import com.example.jetbrainstest.pages.PyCharmPage;
import com.example.jetbrainstest.pages.RubyPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RubyTest extends BaseTest {
    private RubyPage rubyPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/ruby/");
        rubyPage = new RubyPage(getDriver());
    }

    @Test
    @DisplayName("Проверка, что кнопка скачивания активна")
    public void buttonCheck() {
        assertTrue(rubyPage.checkIfDownloadButtonIsClickable(), "Кнопка скачивания не активна");
    }

    @Test
    @DisplayName("Проверка урла после клика")
    public void checkUrlAfterClickPyCharmButton() {
        rubyPage = new RubyPage(getDriver());
        Assertions.assertEquals(rubyPage.clickrubyMineButtonCheckUrl(), "https://www.jetbrains.com/ruby/", "Урл не тот");
    }
    @Test
    @DisplayName("Проверяю активность кнопки акции на бесплатные 30 дней")
    public void buttonPromotionCheck() {
        assertTrue(rubyPage.checkPromotionButtonIsClickable(), "Кнопка акции не активна");
        }
    @Test
    @DisplayName("Проверяю видимость первого скриншота")
    public void firstScreenshotIsVisible() {
        assertTrue(rubyPage.checkFirstScreenshotIsVisible(), "Первый скриншот не виден");
    }
}