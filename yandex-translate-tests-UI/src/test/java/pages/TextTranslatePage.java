package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TextTranslatePage extends BasePage{

    public static String URL_HOME = "https://translate.yandex.ru/";


    public List<WebElement> scrLangList;

    public List<WebElement> dstnLangList;

    //Елементы навигации
    @FindBy(css = "div.tabs span")
    public   WebElement textMenu;

    @FindBy(css = "div.tabs a:nth-child(2)")
    public  WebElement siteMenu;

    @FindBy(css = "div.tabs a:nth-child(3)")
    public WebElement pictureMenu;

    @FindBy(css = "div.menu div:nth-child(1) span")
    WebElement collectionBtn;

    @FindBy(css = "div.menu div:nth-child(2) span")
    WebElement settingsBtn;


    //Елементы окна оригинального текста
    @FindBy(id = "fakeArea")
    public WebElement originalText;

    @FindBy(id = "clearButton")
    public WebElement clearButton;

    @FindBy(id = "keyboardButton")
    public WebElement keyboardButton;

    @FindBy(id = "spellerButton")
    public WebElement spellerButton;

    @FindBy(id = "srcLangButton")
    public WebElement srcLangButton;

    @FindBy(id = "srcLangListboxContent")
    public WebElement srcLangListboxContent;


    //Элементы окна перевода текста
    @FindBy(id = "translation")
    public WebElement translationText;

    @FindBy(id = "editorButton")
    public WebElement editorButton;

    @FindBy(id = "badVoteButton")
    public WebElement badVoteButton;

    @FindBy(id = "goodVoteButton")
    public WebElement goodVoteButton;

    @FindBy(id = "shareButton")
    public WebElement shareButton;

    @FindBy(id = "copyButton")
    public WebElement copyButton;

    @FindBy(id = "favButton")
    public WebElement favButton;

    @FindBy(id = "dstLangButton")
    public WebElement dstLangButton;



    public TextTranslatePage(WebDriver driver){
        this.driver = driver;
        driver.get(URL_HOME);
        PageFactory.initElements(driver, this);

        scrLangList = driver.findElements(By.cssSelector("#srcLangListboxContent div.listbox-option"));
        dstnLangList = driver.findElements(By.cssSelector("#dstLangListboxContent div.listbox-option"));
    }

    public void inputOriginText(String origintext){
        originalText.clear();
        originalText.sendKeys(origintext);
        new WebDriverWait(driver,10).until(ExpectedConditions.textToBePresentInElement((originalText),origintext));
    }

    public String getTranslation(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return translationText.getText();
    }

    public void changeLangOrigin(String langOrg) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(srcLangButton));
        if (!(srcLangButton.getText().equalsIgnoreCase(langOrg))) {
            srcLangButton.click();
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.id("srcLangListbox")));
            scrLangList.stream().filter((s) -> s.getText().equals(langOrg)).findFirst().get().click();
        }
    }

    public List<String> getLangOriginList(){
        srcLangButton.click();
        return scrLangList.stream().map((s)->s.getText()).collect(Collectors.toList());
    }

    public void changeLangTranslation(String texttransl){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(dstLangButton));

        if(!(dstLangButton.getText().equalsIgnoreCase(texttransl))) {
            dstLangButton.click();
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.id("dstLangListbox")));
            dstnLangList.stream().filter((s) -> s.getText().equals(texttransl)).findFirst().get().click();
        }
    }

    public List<String> getLangTranslationList(){
        dstLangButton.click();
        return dstnLangList.stream().map((s)->s.getText()).collect(Collectors.toList());
    }

    public void clickOnClearButton(){
        clearButton.click();
    }

    public void clickSpellerButton(){
        spellerButton.click();
    }


}
