package tests;

import hooks.GeneralHooks;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;


public class LoginTests extends GeneralHooks {

    @DataProvider(name = "login-alerts")
    public Object[][] loginProvider() {
        return new Object[][]{
                {"erickaugs@ninjaplus.com", "123pwd", "Usuário e/ou senha inválidos"},
                {"404@ninjaplus.com", "pwd123", "Usuário e/ou senha inválidos"},
                {"", "pwd123", "Opps. Cadê o email?"},
                {"erickaugs@ninjaplus.com", "", "Opps. Cadê a senha?"},
        };
    }

    @Test
    public void loginSucess() {
        login
                .open()
                .with("erickaugs@ninjaplus.com", "pwd123");

                side.loggerUser().shouldHave(text("erickaugs"));
    }

    @Test(dataProvider = "login-alerts")
    public void shouldSeeLoginAlerts(String email, String pass, String expectAlert){

        login
                .open()
                .with(email,pass)
                .alert().shouldHave(text(expectAlert));
    }

    @AfterMethod
    public void clearUp(){
        login.clearSession();
    }
}
