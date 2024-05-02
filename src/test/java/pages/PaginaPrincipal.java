package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PaginaPrincipal {

    public final SelenideElement nomeUser = $(byXpath("/html/body/div[1]"));

    public String getNomeUser(){
        return nomeUser.getText();
    }
}
