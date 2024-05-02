package steps;

import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import constantes.Constants;
import io.cucumber.java.pt.Dado;
import pages.LoginPage;

public class LoginsStepdefs {
    @Dado("que esteja logado na pagina do seu barriga")
    public void queEstejaLogadoNaPaginaDoSeuBarriga() {

        Configuration.baseUrl = System.getProperty(Constants.VARIABLE_BASE_URL);
        Configuration.browser = System.getProperty(Constants.VARIABLE_BROWSER);
        Configuration.downloadsFolder = "relatorios";

        Configuration.headless = false;


        LoginPage loginPage = Selenide.open("", LoginPage.class);
        loginPage.informarEmail(System.getProperty(Constants.VARIABLE_USER));
        loginPage.informarSenha(System.getProperty(Constants.VARIABLE_PASSWORD));
        loginPage.acessarSeuBarriga();
    }
}
