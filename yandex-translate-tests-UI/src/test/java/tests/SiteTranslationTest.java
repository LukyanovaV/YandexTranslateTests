package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SiteTranslatePage;


public class SiteTranslationTest extends BaseTest {

    public static String testUrl = "aussie-info.ru/index.php?userif=2";
    public static String firstPartForTr ="https://z5h64q92x9.net/proxy_u/en-ru.ru/";

    public SiteTranslatePage siteTranslatePage;

    @Category(SmokeTests.class)
    @Test
    public void testUrlTranslate(){
        siteTranslatePage = new SiteTranslatePage(driver);
        siteTranslatePage.inputUrlForTranslation(testUrl);

        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(By.id("progress"), "100%"));
        driver.switchTo().frame(siteTranslatePage.iframe);

        String afterTranslateText = driver.findElement(By.cssSelector("p.p_text")).getText();

        Assert.assertEquals(afterTranslateText, "Наш сайт посвящен слиянию данных об австралийских Пастухах. Мы поместили в базу данных всех известных предков русских Кисков и других Кисков со всего мира. Приглашаем всех владельцев Aussie к сотрудничеству в заполнении базы данных!");
    }


}


