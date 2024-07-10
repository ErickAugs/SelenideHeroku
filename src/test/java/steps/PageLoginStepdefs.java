package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.PaginaPrincipal;
import utils.Utils;

public class PageLoginStepdefs {
    PaginaPrincipal paginaPrincipal = Selenide.page(PaginaPrincipal.class);
    String nome;
    @Quando("acessar a pagina e capturar o nome")
    public void acessarAPaginaECapturarONome() {
        nome = paginaPrincipal.getNomeUser();
        //Utils.salvarEvidencia();
    }

    @Então("o nome estará {}")
    public void oNomeEstaraBemVindoXiaomi(String nomePage) {
        Assert.assertEquals("nome está divergente", nome, nomePage);
        //Utils.salvarEvidencia();
    }

}
