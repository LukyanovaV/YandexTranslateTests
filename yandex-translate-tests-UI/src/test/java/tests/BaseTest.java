package tests;

import environment.JUnitRunListener;
import environment.WebDriverListener;
import environment.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;

@RunWith(JUnitRunListener.class)
public class BaseTest {

    public WebDriver driver;
    public EventFiringWebDriver event;
    String browserName = System.getProperty("browser");

    @Rule
    public TestRule testWatcher = new TestWatcher() {

        public void finished(Description desc) {
            driver.quit();
        }

        @Override

        protected void failed(Throwable e, Description description) {
            super.failed(e, description);
           /* File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File outputFile = new File("results/", description.toString()+".png");
            try {
                org.apache.commons.io.FileUtils.copyFile(saveScreenshot().,outputFile);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            */
           saveScreenshot();
        }
    };

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

    }


    @Before
    public void setUp(){


        WebDriverManager driverManager = new WebDriverManager(driver);
        driver = driverManager.getInstance(browserName);
        event = new EventFiringWebDriver(driver);
        event.register(new WebDriverListener());


    }


}
