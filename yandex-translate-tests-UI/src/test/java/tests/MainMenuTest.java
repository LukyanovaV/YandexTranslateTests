package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.TextTranslatePage;

public class MainMenuTest extends BaseTest {
    public TextTranslatePage translatePage;


    @Test
    public void clickOnMenuToMail() {
        translatePage = new TextTranslatePage(driver);
        translatePage.clickOnYandexMail();
        Assert.assertEquals("https://mail.yandex.ru/?source=tableau_translate", driver.getCurrentUrl());
    }

    @Test
    public void clickOnMenuToWeather() {
        translatePage = new TextTranslatePage(driver);
        translatePage.clickOnYandexWeather();
        Assert.assertEquals("https://yandex.ru/pogoda/taganrog/?source=tableau_translate&from=home", driver.getCurrentUrl());
    }

    @Test
    public void clickOnMenuToNews() {
        translatePage = new TextTranslatePage(driver);
        translatePage.clickOnYandexNews();
        Assert.assertEquals("https://news.yandex.ru/?source=tableau_translate", driver.getCurrentUrl());
    }

    @Test
    public void clickOnMenuToDisk() {
        translatePage = new TextTranslatePage(driver);
        translatePage.clickOnYandexDisk();
        Assert.assertEquals("https://disk.yandex.ru/?source=tableau_translate", driver.getCurrentUrl());
    }

    @Test
    public void clickOnMenuToMaps() {
        translatePage = new TextTranslatePage(driver);
        translatePage.clickOnYandexMaps();
        Assert.assertEquals("https://yandex.ru/maps/?source=tableau_translate", driver.getCurrentUrl());
    }

    @Test
    public void clickOnMenuToImages() {
        translatePage = new TextTranslatePage(driver);
        translatePage.clickOnYandexImages();
        Assert.assertEquals("https://yandex.ru/images/?source=tableau_translate", driver.getCurrentUrl());
    }

    @Test
    public void clickOnMenuToMoney() {
        translatePage = new TextTranslatePage(driver);
        translatePage.clickOnYandexMoney();
        Assert.assertEquals("https://money.yandex.ru/?source=tableau_translate", driver.getCurrentUrl());
    }

    @Test
    public void clickOnMenuToMarket() {
        translatePage = new TextTranslatePage(driver);
        translatePage.clickOnYandexMarket();
        Assert.assertEquals("https://market.yandex.ru/?source=tableau_translate", driver.getCurrentUrl());
    }

    @Test
    public void clickOnMenuToVideo() {
        translatePage = new TextTranslatePage(driver);
        translatePage.clickOnYandexVideo();
        Assert.assertEquals("https://yandex.ru/video/?source=tableau_translate", driver.getCurrentUrl());
    }

    @Test
    public void clickOnMenuToTranslate() {
        translatePage = new TextTranslatePage(driver);
        translatePage.clickOnYandexTranslate();
        Assert.assertEquals("https://translate.yandex.ru/?source=tableau_translate", driver.getCurrentUrl());
    }

    @Test
    public void clickOnMenuToTV() {
        translatePage = new TextTranslatePage(driver);
        translatePage.clickOnYandexTV();
        Assert.assertEquals("https://tv.yandex.ru/?source=tableau_translate", driver.getCurrentUrl());
    }

    @Test
    public void clickOnMenuToMusic() {
        translatePage = new TextTranslatePage(driver);
        translatePage.clickOnYandexMusic();
        Assert.assertEquals("https://music.yandex.ru/home?source=tableau_translate", driver.getCurrentUrl());
    }
}
