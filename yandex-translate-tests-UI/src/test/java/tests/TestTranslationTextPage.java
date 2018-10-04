package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TextTranslatePage;

public class TestTranslationTextPage extends BaseTest{

    public static String originLang = "Английский";
    public static String originText = "Hello";
    public static String expectedTranslation = "Привет";

    @Category(SmokeTests.class)
    @Test
    public void testTranslationToRus(){
        TextTranslatePage textTranslatePage = new TextTranslatePage(driver);
        textTranslatePage.changeLangOrigin(originLang);
        textTranslatePage.inputOriginText(originText);

        Assert.assertEquals(textTranslatePage.getTranslation(), expectedTranslation);
    }


    @Test
    public void testSynonymsOriginText(){
        TextTranslatePage textTranslatePage = new TextTranslatePage(driver);
        textTranslatePage.changeLangOrigin(originLang);
        textTranslatePage.inputOriginText(originText);
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(By.cssSelector("div.synonyms-title"), originText.toLowerCase()));
        String synonyms = driver.findElement(By.cssSelector("#synonymsContent  ul  li  ul  li:nth-child(1)")).getText();
        Assert.assertEquals(synonyms, "hi · hallo · salut");
    }

    @Test
    public void testSynonymsTranslateText(){
        TextTranslatePage textTranslatePage = new TextTranslatePage(driver);
        textTranslatePage.changeLangOrigin(originLang);
        textTranslatePage.inputOriginText(originText);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("dictionary")));
        String synonyms = driver.findElement(By.cssSelector("div.dictionary-meanings-value")).getText();
        Assert.assertEquals(synonyms, "привет, добрый день, Здравствуйм");
    }

    @Test
    public void testExamplesConversations(){
        TextTranslatePage textTranslatePage = new TextTranslatePage(driver);
        textTranslatePage.changeLangOrigin(originLang);
        textTranslatePage.inputOriginText(originText);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-value^=\"examples\"]"))).click();
        String examples = driver.findElement(By.cssSelector("div.dictionary-example_source :nth-child(1)")).getText();
        Assert.assertTrue(examples.equalsIgnoreCase(originText));

    }

    @Category(SmokeTests.class)
    @Test
    public void testClickOnSiteBtn(){
        TextTranslatePage textTranslatePage = new TextTranslatePage(driver);
        textTranslatePage.siteMenu.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://translate.yandex.ru/translate");

    }

    @Category(SmokeTests.class)
    @Test
    public void testClickOnImageBtn(){
        TextTranslatePage textTranslatePage = new TextTranslatePage(driver);
        textTranslatePage.pictureMenu.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://translate.yandex.ru/ocr");

    }



}
