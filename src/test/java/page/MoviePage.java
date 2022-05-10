package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.MovieModel;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MoviePage {

    public MoviePage adcFilme(){
        $(".movie-add").click();
        return this;
    }

    public MoviePage title(MovieModel movieModel){
        $("input[name=title]").sendKeys(movieModel.title);
        this.selectStatus(movieModel.status);
        $("input[name=year]").setValue(movieModel.year.toString());
        $("input[name=release_date]").setValue(movieModel.releaseDate);
        this.imputCast(movieModel.cast);
        $("textarea[name=overview]").setValue(movieModel.plot);

        return this;
    }

    private void imputCast(List<String> cast){
        SelenideElement element = $(".cast");
        for (String actor : cast){
            element.setValue(actor);
            element.sendKeys(Keys.TAB);
        }
    }

    private void selectStatus(String status){
        $("input[placeholder=Status").click();
        $$("ul li span").findBy(text(status)).click();
    }
}
