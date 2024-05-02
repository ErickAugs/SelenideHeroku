package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public final SelenideElement campoEmail = $(byId("email"));
    public final SelenideElement campoSenha = $(byId("senha"));
    public final SelenideElement btnEntrar = $(byXpath("//*[@class=\"jumbotron col-lg-4\"]//*[@class=\"btn btn-primary\"]"));


    public void informarEmail(String email){
        campoEmail.setValue(email);
    }

    public void informarSenha(String senha){
        campoEmail.setValue(senha);
    }

    public void acessarSeuBarriga(){
        btnEntrar.click();
    }
}
