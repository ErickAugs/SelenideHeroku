package models;

import java.util.List;

public class MovieModel {

    public String title;
    public String status;
    public Integer year;
    public String releaseDate;
    public List<String> cast;
    public String plot;
    public String cover;

    public MovieModel(String title, String status, Integer year, String releaseDate, List<String> cast, String plot, String cover) {
        this.title = title;
        this.status = status;
        this.year = year;
        this.releaseDate = releaseDate;
        this.cast = cast;
        this.plot = plot;
        this.cover = this.coverPath() + cover;
    }

    private String coverPath(){
        String executaPath = System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        String target = null;
        if(os.contains("Windows")){
           target = executaPath = "src\\test\\resources\\cover\\";
        }
        else{
            target = executaPath + "src/test/resources/cover/";
        }
        return target;
    }
}
