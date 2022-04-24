package hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.UnsupportedEncodingException;

public class GeneralHooks {
    public static Scenario scenario;
//    ExtentReports extentReports = new ExtentReports();

    @Before
    public void retornarScenario(Scenario _scenario) throws UnsupportedEncodingException{
        scenario = _scenario;
//        extentReports.setGherkinDialect("pt");
    }

    @After
    public void aposExecucao(){
        Selenide.closeWebDriver();
    }
}
