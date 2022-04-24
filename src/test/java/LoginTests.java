import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class LoginTests {

    @Test
    public void loginSucess(){
        isChrome();
        open("http://ninjaplus-web:5000/login");

        $("#emailId").setValue("erickaugs@ninjaplus.com");
        $("#passId").setValue("pwd123");
        $(byId("login")).click();

        $(".user .info span").shouldHave(text("erickaugs"));
        Selenide.closeWebDriver();
    }
    @Test
    public void passwordInvalid(){
        isChrome();
        open("http://ninjaplus-web:5000/login");

        $("#emailId").setValue("erickaugs@ninjaplus.com");
        $("#passId").setValue("123pwd");
        $(byId("login")).click();

        $(".alert span").shouldHave(text("Usuário e/ou senha inválidos"));
        Selenide.closeWebDriver();
    }

    @Test
    public void userInvalid(){
        isChrome();
        open("http://ninjaplus-web:5000/login");

        $("#emailId").setValue("404@ninjaplus.com");
        $("#passId").setValue("pwd123");
        $(byId("login")).click();

        $(".alert span").shouldHave(text("Usuário e/ou senha inválidos"));
        Selenide.closeWebDriver();
    }

    @Test
    public void emailNotFound(){
        isChrome();
        open("http://ninjaplus-web:5000/login");

        $("#emailId").setValue("");
        $("#passId").setValue("123pwd");
        $(byId("login")).click();

        $(".alert span").shouldHave(text("Opps. Cadê o email?"));
        Selenide.closeWebDriver();
    }

    @Test
    public void passwordNotFound(){
        isChrome();
        open("http://ninjaplus-web:5000/login");

        $("#emailId").setValue("erickaugs@ninjaplus.com");
        $("#passId").setValue("");
        $(byId("login")).click();

        $(".alert span").shouldHave(text("Opps. Cadê a senha?"));
        Selenide.closeWebDriver();
    }
}
