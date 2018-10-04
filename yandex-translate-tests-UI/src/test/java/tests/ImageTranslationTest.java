package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ImageTranslatePage;

import java.io.File;
import java.util.ArrayList;

public class ImageTranslationTest extends BaseTest{

    public ImageTranslatePage imageTranslatePage;
    public static String imagePath="D:\\testImage\\wel.jpg";

    @Category(SmokeTests.class)
    @Test
    public void imageTranslationTest() {
        imageTranslatePage = new ImageTranslatePage(driver);
        imageTranslatePage.selectFileImg.click();

        File file = new File(imagePath);
        String name = file.getAbsolutePath();
        imageTranslatePage.setLoadedFile(name);
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(imageTranslatePage.openTranslateBtn)).click();

        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.id("fakeArea")));
        Assert.assertEquals(driver.findElement(By.id("fakeArea")).getText(),"WELCOME");
        Assert.assertEquals(driver.findElement(By.id("translation")).getText(),"ПРИВЕТСТВОВАТЬ");
    }

    @Test
    public void imageClearTest(){
        imageTranslatePage = new ImageTranslatePage(driver);
        imageTranslatePage.selectFileImg.click();

        File file = new File(imagePath);
        imageTranslatePage.setLoadedFile(file.getAbsolutePath());
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(imageTranslatePage.resetImgBtn)).click();
        Assert.assertFalse(imageTranslatePage.imagePlace.isDisplayed());
    }




}
