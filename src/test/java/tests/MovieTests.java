package tests;

import hooks.GeneralHooks;
import models.MovieModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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

       MovieModel movieData = new MovieModel(
               "Senhor dos Aneis",
               "Pré-venda",
               2022,
               "16/01/2022",
               Arrays.asList("Orlando Blum", "Kevin Hart", "Dannyy Glover"),
               "A sociedade do ano ressurge para lutar contra mordor",
               "jumanji2.ppg");

        movie.adcFilme().title(movieData);
    }
}
