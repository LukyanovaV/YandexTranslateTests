package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ImageTranslationTest.class,
        MainMenuTest.class,
        SiteTranslationTest.class,
        TestTranslationToRus.class,
        ToolsButtonsTest.class,
        TestTranslationToLangs.class
})
public class RunAllInBrowser {
}
