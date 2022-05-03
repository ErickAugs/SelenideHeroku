package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class LoginPage {

    public LoginPage open() {
        Selenide.open("/login");
        return this;
    }

    public LoginPage with(String email, String pass) {
        $("#emailId").setValue(email);
        $("#passId").setValue(pass);
        $(byId("login")).click();
        return this;
    }

    public SelenideElement alert() {
        return $(".alert span");
    }

    public void clearSession(){
        executeJavaScript("localStorage.clear();");
    }


}
