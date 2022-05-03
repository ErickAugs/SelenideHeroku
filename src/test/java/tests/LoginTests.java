package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.Before;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LoginPage;
import page.SideBar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class LoginTests {

    @DataProvider(name = "login-alerts")
    public Object[][] loginProvider() {
        return new Object[][]{
                {"erickaugs@ninjaplus.com", "123pwd", "Usuário e/ou senha inválidos"},
                {"404@ninjaplus.com", "pwd123", "Usuário e/ou senha inválidos"},
                {"", "pwd123", "Opps. Cadê o email?"},
                {"erickaugs@ninjaplus.com", "", "Opps. Cadê a senha?"},
        };
    }
    protected static LoginPage Login;
    protected static SideBar side;

    @BeforeMethod
    public void start(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://ninjaplus-web:5000";

        Login = new LoginPage();
        side = new SideBar();
    }

    @Test
    public void loginSucess() {
        Login
                .open()
                .with("erickaugs@ninjaplus.com", "pwd123")
                .alert();

                side.loggerUser().shouldHave(text("erickaugs"));
    }

    @Test(dataProvider = "login-alerts")
    public void shouldSeeLoginAlerts(String email, String pass, String expectAlert){

        Login
                .open()
                .with(email,pass)
                .alert().shouldHave(text(expectAlert));
    }

    @AfterMethod
    public void clearUp(){
        Login.clearSession();
    }
}
