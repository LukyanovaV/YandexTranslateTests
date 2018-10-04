package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImageTranslatePage extends BasePage {

    public String imageTranslateURL = "https://translate.yandex.ru/ocr";

    public List<WebElement> scrLangList;

    public List<WebElement> dstnLangList;

    @FindBy(css = "div.tabs a[href^=\"/\"]")
    public WebElement textButton;

    @FindBy(css = "div.tabs a[href^=\"/translate\"]")
    public WebElement siteButton;

    @FindBy(css = "#header div.service div span")
    public WebElement imageButton;

    @FindBy(id = "sourceLangButton")
    public WebElement sourceLangButton;

    @FindBy(id = "targetLangButton")
    public WebElement targetLangButton;

    @FindBy(css = "span[data-action^=selectImage]")
    public WebElement selectFileImg;

    @FindBy(css="span[data-action^=resetImage]")
    public WebElement resetImgBtn;

    @FindBy(id = "imageRectGroup")
    public WebElement imagePlace;

    @FindBy(id = "fileInput")
    public WebElement fileInputId;

    @FindBy(css="span[data-action^=\"paste\"]")
    public WebElement openTranslateBtn;

    public ImageTranslatePage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(imageTranslateURL);
        PageFactory.initElements(driver, this);

        scrLangList = driver.findElements(By.cssSelector("#sourceLangListboxContent div.listbox-option"));
        dstnLangList = driver.findElements(By.cssSelector("#targetLangListbox div.listbox-option"));

    }

    public void setLoadedFile(String filePath){
        File autoIt = new File("resources/loadImage.exe");

        try {
            // запуск exe с передачей пути к загружаемому файлу
            // в качестве параметра
            Process p = Runtime.getRuntime().exec(
                    autoIt.getAbsolutePath() + " " + filePath);
            // ожидание выполнения запроса
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }







}
