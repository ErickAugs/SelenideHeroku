package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ContaPage {

    private final SelenideElement menuContas = $(byClassName("dropdown-toggle"));
    private final ElementsCollection menusContas = $$(byXpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li/a"));
    private final SelenideElement campoConta = $(byId("nome"));
    private final SelenideElement btnSalvar = $(byClassName("btn-group"));
    private final ElementsCollection contasIncluidas = $$(byXpath("//*[@id=\"tabelaContas\"]/tbody/tr"));

    public void clicarMenuContas(){
        menuContas.click();
    }

    public void selecionarOpcaoMenu(String opcao){
        menusContas.find(text(opcao)).click();
    }

    public void incluirConta(String conta){
        campoConta.setValue(conta);
    }

    public void salvarConta(){
        btnSalvar.click();
    }

    public List<String> contasInclusas(){
        return contasIncluidas.texts();
    }

    public int excluirConta(){
        int index = contasIncluidas.size();
        return index;
    }
}
