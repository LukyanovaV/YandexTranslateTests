package tests;

import environment.DataForTestWithCSV;
import environment.RunnerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.TextTranslatePage;

import java.io.IOException;
import java.util.Collection;

@RunWith(Parameterized.class)
@Parameterized.UseParametersRunnerFactory(RunnerFactory.class)
public class TestTranslationToLangs extends BaseTest {

    public String id;
    public String originLang;
    public String originText;
    public String dstnLang;
    public String dstnText;

    public TestTranslationToLangs(String id, String originLang, String originText, String dstnLang, String dstnText){
        this.id = id;
        this.originLang = originLang;
        this.originText = originText;
        this.dstnLang = dstnLang;
        this.dstnText = dstnText;
    }
    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        Collection<String[]> inputdata = DataForTestWithCSV.getTestData("resources/TranslateToOtherLangs.csv");
        return inputdata;
    }

    @Test
    public void testTranslationToOtherLangs(){
        TextTranslatePage textTranslatePage = new TextTranslatePage(driver);
        textTranslatePage.changeLangTranslation(dstnLang);
        textTranslatePage.changeLangOrigin(originLang);
        textTranslatePage.inputOriginText(originText);
        Assert.assertEquals(textTranslatePage.getTranslation(), dstnText);
    }
}
