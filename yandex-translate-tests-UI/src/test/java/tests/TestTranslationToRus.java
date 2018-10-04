package tests;

import environment.DataForTestWithCSV;
import environment.RunnerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.TextTranslatePage;

import java.io.IOException;
import java.util.Collection;

@RunWith(Parameterized.class)
@Parameterized.UseParametersRunnerFactory(RunnerFactory.class)
public class TestTranslationToRus extends BaseTest{

    private String id;
    private String originLang;
    private String originText;
    private String expectedTranslation;


    public TestTranslationToRus(String id, String originLang, String originText, String expectedTranslation){
        this.id = id;
        this.originLang = originLang;
        this.originText = originText;
        this.expectedTranslation = expectedTranslation;
    }

@Parameterized.Parameters
public static Collection testData() throws IOException {
    Collection<String[]> inputdata = DataForTestWithCSV.getTestData("resources/TranslateToRus.csv");
    return inputdata;
}


    @Test
    public void testTranslationToRus(){
        TextTranslatePage textTranslatePage = new TextTranslatePage(driver);
        textTranslatePage.changeLangOrigin(originLang);
        textTranslatePage.inputOriginText(originText);

        Assert.assertEquals(textTranslatePage.getTranslation(), expectedTranslation);
    }

}
