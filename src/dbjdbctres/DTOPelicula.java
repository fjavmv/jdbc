package dbjdbctres;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DTOPelicula {

    //INSERT INTO public.film(
    //	film_id, title, description, release_year, language_id,
    //	rental_duration, rental_rate, length, replacement_cost,
    //	rating, last_update, special_features, fulltext)
    //	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
    private String title;
    private String description;
    private int release_year;
    private int language_id;
    private  int rental_duration;
    private int rental_rate;
    private  int replacement_cost;
    private String last_update;
   // private String full_text;
    private Vector <String> full_text;
   // private Map<String,Integer> full_text_map = new HashMap<>();

    public DTOPelicula(String title, String description, int release_year, int language_id, int rental_duration, int rental_rate, int replacement_cost,  String last_update, Vector<String> full_text) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language_id = language_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.replacement_cost = replacement_cost;
        this.last_update = last_update;
        this.full_text = full_text;
       // this.full_text_map = full_text_map;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public int getRental_rate() {
        return rental_rate;
    }

    public int getReplacement_cost() {
        return replacement_cost;
    }

    public String getLast_update() {
        return last_update;
    }

    public Vector<String> getFull_text() {
        return full_text;
    }

    @Override
    public String toString() {
        return "DataModelPeliculas{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", release_year='" + release_year + '\'' +
                ", language_id=" + language_id +
                ", rental_duration=" + rental_duration +
                ", rental_rate=" + rental_rate +
                ", replacement_cost=" + replacement_cost +
                ", last_update='" + last_update + '\'' +
                ", full_text=" + full_text +
                '}';
    }
}
