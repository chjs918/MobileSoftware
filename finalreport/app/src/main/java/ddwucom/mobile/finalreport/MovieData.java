package ddwucom.mobile.finalreport;

import java.io.Serializable;

public class MovieData implements Serializable {
    long _id;
    String title;
    int grade;
    String genre;
    String director;
    String year;

    public MovieData(String title, String director, String year, String genre, int grade) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.grade = grade;
    }

    public MovieData(long _id, String title, String director, String year, String genre, int grade) {
        this._id = _id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.grade = grade;
    }


    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
