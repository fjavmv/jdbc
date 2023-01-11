package dbjdbcuno;

public class DbConfig {
    /*
        Configuración necesaria para establcer conexión con el servidor de PostgreSQL
     */
    public static final String URL = "jdbc:postgresql://localhost:5432/dvdrental";
    public static final String USER = "postgres";
    public static final String PASSWORD = "AXQWEZRT7";

    //Consulta
    public static final String QUERY = "SELECT * FROM get_pelicula(?,?)";

}
