package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SiteTranslatePage extends BasePage {

    public static String URL = "https://translate.yandex.ru/translate";

    public List<WebElement> scrLangList;

    public List<WebElement> dstnLangList;

    @FindBy(css = "div.tabs a[href^=\"/\"]")
    public WebElement textButton;

    @FindBy(css = "#header div.service div span")
    public WebElement siteButton;

    @FindBy(id = "urlInput")
    public WebElement urlInput;

    @FindBy(css = "span[data-action^=\"submitUrl\"]")
    public WebElement urlSubmitButton;

    @FindBy(id = "dstLangButton")
    public WebElement dstnLangButton;

    @FindBy(id = "srcLangButton")
    public WebElement srcLangButton;

    @FindBy(id="targetFrame")
    public WebElement iframe;


    public SiteTranslatePage(WebDriver driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        PageFactory.initElements(driver, this);


        scrLangList = driver.findElements(By.cssSelector("#srcLangListboxContent div.listbox-option"));
        dstnLangList = driver.findElements(By.cssSelector("#dstLangListboxContent div.listbox-option"));
    }

    public void inputUrlForTranslation(String urlForTranslation){
        urlInput.sendKeys(urlForTranslation);
        urlSubmitButton.click();
    }

    public void changeDstnLang(String dstnLang){
        dstnLangButton.click();
        dstnLangList.stream().filter((s) -> s.getText().equals(dstnLang)).findFirst().get().click();
    }

    public void changeSrcLang(String srcLang){
        srcLangButton.click();
        scrLangList.stream().filter((s) -> s.getText().equals(srcLang)).findFirst().get().click();
    }



}
