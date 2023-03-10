package dbpgjdbcdos;

import java.util.Arrays;

public class DataModelPeliculas {

    //INSERT INTO public.film(
    //	film_id, title, description, release_year, language_id,
    //	rental_duration, rental_rate, length, replacement_cost,
    //	rating, last_update, special_features, fulltext)
    //	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
    private String title;
    private String description;
    private String release_year;
    private int language_id;
    private  int rental_duration;
    private int rental_rate;
    private  int replacement_cost;
    private String fulltext;
    private String last_update;
    private String [] full_text;

    public DataModelPeliculas(String title, String description, String release_year, int language_id, int rental_duration, int rental_rate, int replacement_cost, String fulltext, String last_update, String[] full_text) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language_id = language_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.replacement_cost = replacement_cost;
        this.fulltext = fulltext;
        this.last_update = last_update;
        this.full_text = full_text;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getRelease_year() {
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

    public String getFulltext() {
        return fulltext;
    }

    public String getLast_update() {
        return last_update;
    }

    public String[] getFull_text() {
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
                ", fulltext='" + fulltext + '\'' +
                ", last_update='" + last_update + '\'' +
                ", full_text=" + Arrays.toString(full_text) +
                '}';
    }
}
