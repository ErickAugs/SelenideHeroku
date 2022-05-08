package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;
import page.MoviePage;
import page.SideBar;

import java.io.UnsupportedEncodingException;

public class GeneralHooks {

    protected static LoginPage login;
    protected static SideBar side;
    protected static MoviePage movie;

    @BeforeMethod
    public void start(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://ninjaplus-web:5000";

        login = new LoginPage();
        side = new SideBar();
        movie = new MoviePage();
    }

    @After
    public void aposExecucao(){
        Selenide.closeWebDriver();
    }
}
