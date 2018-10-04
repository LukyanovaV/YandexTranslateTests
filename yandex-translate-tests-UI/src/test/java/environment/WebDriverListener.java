package environment;

import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class WebDriverListener extends RunListener implements WebDriverEventListener {

    static final Logger logger = Logger.getLogger(WebDriverListener.class);



    @Override
    public void testRunStarted(Description description){
        System.out.println("Before test run:" + description);
        logger.info("Before test run:"+description);
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        logger.info("Result of the test run:");
        logger.info("Run time: " + result.getRunTime() + " ms");
        logger.info("Run count: " + result.getRunCount());
        logger.info("Failure count: " + result.getFailureCount());
        logger.info("Ignored count: " + result.getIgnoreCount());

    }

    @Override
    public void testStarted(Description description) throws Exception {
        logger.addAppender(new FileAppender(new PatternLayout(), "results/"+description+".log", false));
        logger.info("Test starts: " + description);

    }

    @Override
    public void testFinished(Description description) throws Exception {
        super.testFinished(description);
        logger.info("Test finished: " + description);
        logger.info("--------------------------------------");
    }

    @Override
    public void testFailure(Failure failure) throws Exception {

        logger.error("Test failed with: "
                + failure.getException());
    }

    @Override
    public void testAssumptionFailure(Failure failure) {
        logger.info("Test assumes: " + failure.getException());
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        logger.info("Test ignored: " + description);
        logger.info("--------------------------------------");
    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {

    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        logger.info("WebDriver was navigated to "+webDriver.getCurrentUrl()+".");
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info(by.toString() +" element was found.");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("WebDriver click on element - " + webElement.getText());
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        logger.error("Exception occured at "+throwable.getMessage());
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }
}
