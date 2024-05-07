package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Rule;

import java.io.UnsupportedEncodingException;

public class Hooks {

    public static Scenario scenario;
    ExtentReports extentReports = new ExtentReports();

    @Before
    public void retornarScenario(Scenario _scenario) throws UnsupportedEncodingException {
        scenario = _scenario;
        extentReports.setGherkinDialect("pt");
    }

    @After
    public void finalizarTestes(){
        Selenide.closeWebDriver();
    }


}