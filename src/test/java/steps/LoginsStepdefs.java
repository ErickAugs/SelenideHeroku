package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.pt.Dado;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import java.io.InputStream;
import java.util.Properties;

public class LoginsStepdefs {

    private Properties prop = new Properties();

    public LoginsStepdefs() {
        try {
            // Carrega o arquivo properties do classpath
            InputStream input = LoginsStepdefs.class.getClassLoader().getResourceAsStream("config.properties");
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("que esteja logado na pagina do seu barriga")
    @Dado("que esteja logado na pagina do seu barriga")
    public void que_esteja_logado_na_pagina_do_seu_barriga() {
        Configuration.baseUrl = "https://seubarriga.wcaquino.me/login";
        Configuration.browser = "chrome";

        Configuration.downloadsFolder = "relatorios";

        Configuration.headless = false;
        //Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless=new");
//        Configuration.browserCapabilities = chromeOptions;

        LoginPage loginPage = open("", LoginPage.class);
        loginPage.informarEmail(prop.getProperty("userName"));
        loginPage.informarSenha(prop.getProperty("password"));
        loginPage.acessarSeuBarriga();
    }
}
