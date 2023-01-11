package dbpgjdbcdos;
import java.sql.*;

public class DbConsultar {
    /*
    Consultar datos de una tabla en la base de datos de PostgreSQL utilizando la API de JDBC.
    Para consultar datos de una tabla utilizando JDBC, es necesario seguir los siguientes pasos:
    1. Establezca una conexión de base de datos al servidor PostgreSQL.
    2. Crea una instancia del objeto Statement
    3. Ejecutar una declaración para obtener un objeto ResultSet
    4. Procese el objeto ResultSet.
    Cierra la conexión a la base de datos.
     */
    private static Connection connection;
     private static  Statement statement;

    public static int contarActores(){
        int contador = 0;
        try {
            connection = DbConection.abrirConexion();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DbQuerys.CONTARACTORES);
            resultSet.next();
            contador = resultSet.getInt(1);

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return  contador;
    }

    public static void getActores(){
        try{
            connection = DbConection.abrirConexion();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DbQuerys.GETACTORES);
            mostrarActores(resultSet);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void mostrarActores(ResultSet resultSet){
        try {
            while (resultSet.next()){
                String id = resultSet.getString("actor_id");
                String nombre = resultSet.getString("first_name");
                String apellido = resultSet.getString("last_name");
                System.out.println(id + " " + nombre + " " + apellido);
            }
        }catch (SQLException ex){
           System.out.println(ex.getMessage());
        }
    }

    public static void consultarActoresDePeliculas(){
        try{
            connection = DbConection.abrirConexion();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DbQuerys.SQL);
            mostrarActoresYPeliculas(resultSet);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }


    private static void mostrarActoresYPeliculas(ResultSet resultSet){
        try{
            while (resultSet.next()){
                int idP = resultSet.getInt("pelicula_id");
                String nombreP = resultSet.getString("pelicula");
                int releaseP = resultSet.getInt("release_year");
                int idA =  resultSet.getInt("actor_id");
                String nombreA = resultSet.getString("nombre");
                System.out.println(idP + " " + nombreP + " " + releaseP +" " +
                        idA + " " + nombreA);
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }



}
