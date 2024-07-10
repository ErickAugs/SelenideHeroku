package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.After;
import utils.Utils;

import java.io.UnsupportedEncodingException;

public class GeneralHooks {

    public static Scenario scenario;
    static ExtentReports extentReports = new ExtentReports();

    public static synchronized ExtentTest startTest(String testName){
        ExtentTest test = extentReports.createTest(testName);
        return test;
    }

    @Before
    public void retornarScenario(Scenario _scenario) throws UnsupportedEncodingException {
        scenario = _scenario;
        extentReports.setGherkinDialect("pt");
        startTest(scenario.getName());
    }

    @After
    public void finalizarTestes(){
        Selenide.closeWebDriver();
    }

    @AfterStep
    public void evidenciaFalhou(){
        if(scenario.isFailed()){
            Utils.salvarEvidencia();
        }
    }
}