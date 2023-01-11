package dbpgjdbcdos;

public class DbQuerys {
    final static String CONTARACTORES = "SELECT count(*) FROM actor";
    final static String GETACTORES = "SELECT actor_id,first_name, last_name FROM actor";
    final static String GETFILMACTOR = "SELECT * FROM film_actor";
   final static String SQL= "SELECT \n" +
           "f.film_id AS pelicula_id,\n" +
           "f.title   AS pelicula,\n" +
           "f.release_year AS release_year,\n" +
           "a.actor_id AS actor_id,\n" +
           "a.first_name AS nombre\n" +
           "FROM film f, actor a\n" +
           "WHERE f.film_id = a.actor_id;";


}
