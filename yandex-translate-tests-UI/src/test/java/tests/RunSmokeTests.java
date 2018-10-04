package tests;

import org.junit.BeforeClass;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.BasePage;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTests.class)
@Suite.SuiteClasses({ ImageTranslationTest.class, SiteTranslationTest.class, TestTranslationTextPage.class})
public class RunSmokeTests {
    @BeforeClass
    public static void setUpBrowser(){
        System.setProperty("browser", "Chrome");
    }
}
