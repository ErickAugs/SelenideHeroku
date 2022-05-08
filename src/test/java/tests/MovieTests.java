package tests;

import hooks.GeneralHooks;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class MovieTests extends GeneralHooks {

    @BeforeMethod
    public void setup(){

        login
                .open()
                .with("erickaugs@ninjaplus.com", "pwd123");
        side.loggerUser().shouldHave(text("erickaugs"));
    }

    @Test
    public void registrarNovoFilme(){
        String title = "Senhor dos Aneis";
        movie.adcFilme().title(title);
    }
}
