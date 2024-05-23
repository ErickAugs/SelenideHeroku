package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PageBase {

    WebDriver driver;


        /********* Link ************/

        public void clicarLink(String link) {
            $(byLinkText(link)).click();
        }

        /************** Tabela *********************/

        public SelenideElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
            // Procurar coluna do registro
            SelenideElement tabela = $("#" + idTabela);
            int idColuna = obterIndiceColuna(colunaBusca, tabela);

            // Encontrar a linha do registro
            int idLinha = obterIndiceLinha(valor, tabela, idColuna);

            // Procurar coluna do botao
            int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

            // Retornar a célula encontrada
            SelenideElement celula = tabela.$x(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]");
            return celula;
        }

    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        SelenideElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
        celula.$x(".//input").click();
    }

    protected int obterIndiceLinha(String valor, SelenideElement tabela, int idColuna) {
        ElementsCollection linhas = tabela.$$x("./tbody/tr/td[" + idColuna + "]");
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).text().equals(valor)) {
                idLinha = i + 1;
                break;
            }
        }
        return idLinha;
    }

    protected int obterIndiceColuna(String coluna, SelenideElement tabela) {
        ElementsCollection colunas = tabela.$$x(".//th");
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).text().equals(coluna)) {
                idColuna = i + 1;
                break;
            }
        }
        return idColuna;
    }
}
