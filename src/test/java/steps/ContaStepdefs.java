package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.qameta.allure.Step;
import org.junit.Assert;
import pages.ContaPage;

public class ContaStepdefs {

    ContaPage contaPage = Selenide.page(ContaPage.class);
    boolean result;
    @Step("acessar o menu conta - opção {0}")
    @Quando("acessar o menu conta - opção {}")
    public void acessarOMenuContaOpçãoAdicionar(String opcao) {
        contaPage.clicarMenuContas();
        contaPage.selecionarOpcaoMenu(opcao);
    }

    @Step("digitar o nome da nova conta: {0}")
    @E("digitar o nome da nova conta: {}")
    public void digitarONomeDaNovaConta(String conta) {
        contaPage.incluirConta(conta);
        contaPage.salvarConta();
    }

    @Step("deverá ser incluída com sucesso: {0}")
    @Então("deverá ser incluída com sucesso: {}")
    public void deveráSerIncluídaComSucesso(String conta) {
        int size = contaPage.contasInclusas().size();
        result = false;
        for(int i =0; i < size; i++){
            String retorno = contaPage.contasInclusas().get(i);
            while (retorno.contains(conta)){
                result = true;
                break;
            }
        }
        Assert.assertTrue("Conta inserida não está na lista", result);
    }
}
