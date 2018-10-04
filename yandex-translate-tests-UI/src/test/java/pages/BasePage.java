package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

   public WebDriver driver;

    public static By iframe = By.id("tableauFrame");

    public static By translateLogo = By.cssSelector("a.name");

    public static By mailBtn = By.cssSelector("div.menu span.button.button_login");


    public void moveToYandexLogo(){
        Actions actions = new Actions(driver);
        WebElement iframe = driver.findElement(this.iframe);

        WebElement element = (new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("logo"))));

        actions.moveToElement(element).build().perform();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().frame(iframe);

    }

    public void clickOnYandexMail(){
        moveToYandexLogo();
        driver.findElement(By.cssSelector("div.tableau__body a.service.service_name_mail")).click();

    }

    public void clickOnYandexWeather(){
        moveToYandexLogo();
        driver.findElement(By.cssSelector("div.tableau__body a.service.service_name_weather")).click();
    }

    public void clickOnYandexNews(){
        moveToYandexLogo();
        driver.findElement(By.cssSelector("div.tableau__body a.service.service_name_news")).click();
    }

    public void clickOnYandexDisk(){
        moveToYandexLogo();
        driver.findElement(By.cssSelector("div.tableau__body a.service.service_name_disk")).click();
    }

    public void clickOnYandexMaps(){
        moveToYandexLogo();
        driver.findElement(By.cssSelector("div.tableau__body a.service.service_name_maps")).click();
    }

    public void clickOnYandexImages(){
        moveToYandexLogo();
        driver.findElement(By.cssSelector("div.tableau__body a.service.service_name_images")).click();
    }

    public void clickOnYandexMoney(){
        moveToYandexLogo();
        driver.findElement(By.cssSelector("div.tableau__body a.service.service_name_money")).click();
    }

    public void clickOnYandexMarket(){
        moveToYandexLogo();
        driver.findElement(By.cssSelector("div.tableau__body a.service.service_name_market")).click();
    }

    public void clickOnYandexVideo(){
        moveToYandexLogo();
        driver.findElement(By.cssSelector("div.tableau__body a.service.service_name_video")).click();
    }

    public void clickOnYandexTranslate(){
        moveToYandexLogo();
        driver.findElement(By.cssSelector("div.tableau__body a.service.service_name_translate")).click();
    }

    public void clickOnYandexTV(){
        moveToYandexLogo();
        driver.findElement(By.cssSelector("div.tableau__body a.service.service_name_tv")).click();
    }

    public void clickOnYandexMusic(){
        moveToYandexLogo();
        driver.findElement(By.cssSelector("div.tableau__body a.service.service_name_music")).click();
    }

    public void clickOnTranslateLogo(){

        driver.findElement(translateLogo).click();
    }

    public void goToYandexAccount(){
        driver.findElement(mailBtn).click();
    }
}
