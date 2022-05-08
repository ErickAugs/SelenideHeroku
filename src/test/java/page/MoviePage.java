package page;

import static com.codeborne.selenide.Selenide.$;

public class MoviePage {

    public MoviePage adcFilme(){
        $(".movie-add").click();
        return this;
    }

    public MoviePage title(String filme){
        $("input[name=title]").sendKeys(filme);
        return this;
    }
}
