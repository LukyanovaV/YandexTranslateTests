package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TextTranslatePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ToolsButtonsTest extends BaseTest {

    public static TextTranslatePage translatePage;

    @Test
    public void clearButtonTest(){
        translatePage = new TextTranslatePage(driver);
        translatePage.inputOriginText("Hello Word!");
        Assert.assertTrue(!translatePage.getTranslation().equals(""));
        translatePage.clickOnClearButton();
        Assert.assertTrue(translatePage.getTranslation().equals("")&&translatePage.originalText.getText().equals(""));
    }

    @Test
    public void spellerButtonTest(){
        translatePage = new TextTranslatePage(driver);
        translatePage.clickSpellerButton();
        translatePage.inputOriginText("Helo");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("predictor")));
        driver.findElement(By.cssSelector("#predictor div")).click();
        Assert.assertTrue(translatePage.originalText.getText().equals("Hello"));
    }

    @Test
    public void langHistoryBoxTest(){
        translatePage = new TextTranslatePage(driver);
        List<String> listOrigLangs = translatePage.getLangOriginList();

        Random random = new Random();
        Integer sizeLangs = 7;
        List<String> listLangs = new ArrayList<>(sizeLangs);

        for (Integer i=1;i <=7;i++){
            listLangs.add(listOrigLangs.get(random.nextInt(listOrigLangs.size())));
        }


        for (Integer i=0;i <=6;i++){
            String value = listLangs.get(i);
            translatePage.changeLangOrigin(value);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Integer i=1;i <=7;i++){
            translatePage.srcLangButton.click();
           String exeptionLang = driver.findElement(By.cssSelector("#srcLangHistoryContent > div:nth-child("+i.toString()+")")).getText();
           Assert.assertTrue(exeptionLang.equals(listLangs.get(sizeLangs-1)));
           sizeLangs--;
        }

    }

    @Test
    public void shareButtonTest(){
        translatePage = new TextTranslatePage(driver);
        translatePage.inputOriginText("Welcome test");
        String translate = translatePage.getTranslation();

        WebElement or = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button_icon_collections")));
        or.click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("addCollectionButton")));
        or.click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.id("addCollectionButton"))));
        WebElement icon = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("shareButton")));
        icon.click();

        driver.findElement(By.cssSelector("#share span")).click();
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));
        WebElement result = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".input__control")));
        Assert.assertTrue(result.getAttribute("value").equals("\""+translate+"\""));

    }




}
