package dbjdbctres;

public class DbQuerys {
   final static String SQL= "INSERT INTO libro_t(titulo_libro,editorial_libro, autor_id)"
           + "VALUES(?,?,?)";

   final static  String OBTENERAUTORES = "SELECT * FROM autor_t ORDER BY autor_id ASC";
   final static String GETACTORESA = "SELECT actor_id,first_name, last_name, last_update FROM actor ORDER BY actor_id ASC";
   final static String QUERYUPDATE = "UPDATE libro_t " +
           "SET titulo_libro = ?, " +
           "editorial_libro = ? " +
           "WHERE libro_id = ?;";

   final static String QUERYELIMINAR = "DELETE FROM libro_t WHERE libro_id = ?;";

}
