package dbjdbctres;

import java.sql.*;
import java.util.ArrayList;

public class DAOOperaciones {
    public static void insertarLibros(DTOLibro DTOLibro){
        try{
            /*
        Insertar una fila en una tabla
        1. Establezca una conexión de base de datos para obtener un objeto Connection.
        2. Cree un objeto Declaración a partir del objeto Conexión.
        3. Ejecute la sentencia INSERT .
        4. Cierra la conexión a la base de datos.

        //NOTA
        Lenguaje de Definición de Datos (DDL) (CREATE, ALTER, DROP)
        Lenguaje de Manipulación de Datos (DML) (SELECT, INSERT, UPDATE, DELETE)
        Lenguaje de Control de Datos (DCL) (GRANT, REVOKE)
     */
            Connection connection = DbConection.abrirConexion();
            PreparedStatement preparedStatement = connection.prepareStatement(DbQuerys.SQL);

            preparedStatement.setString(1, DTOLibro.getTituloLibro());
            preparedStatement.setString(2, DTOLibro.getEditorialLibro());
            preparedStatement.setInt(3, DTOLibro.getAutorId());

            int filas = preparedStatement.executeUpdate();

            //Verificamos las filas afectadas
            if (filas == 1){
              System.out.println("Elementos insertados de manera correcta..");
            }
            else {
                throw new RuntimeException("Ha ocurrido un erro lo siento");
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void insercionMultiple(ArrayList<DTOLibro> libros){
       /*
       Llamar al método addBatch() de PreparedStatement.
       Llamar al método executeBatch() para enviar un conjunto de INSERT al servidor de la base de datos de PostgreSQL
       para su ejecución.
        */
        try{
            Connection connection = DbConection.abrirConexion();
            PreparedStatement preparedStatement = connection.prepareStatement(DbQuerys.SQL);
            int contador = 0;
            for (DTOLibro DTOLibro : libros){
                preparedStatement.setString(1, DTOLibro.getTituloLibro());
                preparedStatement.setString(2, DTOLibro.getEditorialLibro());
                preparedStatement.setInt(3, DTOLibro.getAutorId());
                //Agrega un conjunto de parámetros al conjunto de comandos de este objeto PreparedStatement.
                preparedStatement.addBatch();
                //incrementa contador
                contador++;
                if (contador % 6 == 0 || contador == libros.size()){
                    preparedStatement.executeBatch();
                }
                DbConection.cerrarDb(connection);
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    /*Actualizar base de datos mediante los siguientes pasos
        1. Crear o abrir una conexión a la base de datos
        2. Crear un objeto de la Interface PrepareStatement
        3. Ejecutar la declaración UPDATE llamando al metodo excuteUpdate
        4. Cerrar conexión
     */

    public static int actualizarElementos(DTOLibro DTOLibro){
        int fila = 0;
        try{
            Connection connection = DbConection.abrirConexion();
            PreparedStatement preparedStatement = connection.prepareStatement(DbQuerys.QUERYUPDATE);
            preparedStatement.setString(1, DTOLibro.getTituloLibro());
            preparedStatement.setString(2, DTOLibro.getEditorialLibro());
            preparedStatement.setInt(3, DTOLibro.getLibroId());

            fila = preparedStatement.executeUpdate();
            DbConection.cerrarDb(connection);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return fila;
    }

    /*
     * Para operaciones de eliminar necesitamos lo siguiente
     * 1.Establecer conexión
     * 2.Crear un objeto de la Interface PrepareStatement
     * 3. Ejecutar consultar
     * 4. Cerrar conexión
     * */
    public static int eliminarElemento(DTOLibro DTOLibro){
        int fila = 0;
        try{
            Connection connection = DbConection.abrirConexion();
            PreparedStatement preparedStatement = connection.prepareStatement(DbQuerys.QUERYELIMINAR);

            preparedStatement.setInt(1, DTOLibro.getLibroId());

            fila = preparedStatement.executeUpdate();

        }catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return fila;
    }


    public static ArrayList<DTOAutor> getAutor(){
        ArrayList <DTOAutor> autor = new ArrayList<>();
        try{
           Connection connection = dbpgjdbcdos.DbConection.abrirConexion();
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(DbQuerys.OBTENERAUTORES);
           while (resultSet.next()) {
               int idAutor = resultSet.getInt("autor_id");
               String nombre = resultSet.getString("nombre");
               String apellidoM = resultSet.getString("apellido_p");
               String apellidoP = resultSet.getString("apellido_m");
               autor.add(new DTOAutor(idAutor,nombre,apellidoM,apellidoP));
               }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return autor;
    }

    public static ArrayList<DTOActor> getActores(){
        ArrayList<DTOActor> actors = new ArrayList<>();
        try{
            Connection connection = dbpgjdbcdos.DbConection.abrirConexion();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DbQuerys.GETACTORESA);
            while (resultSet.next()){
                int id = resultSet.getInt("actor_id");
                String nombre = resultSet.getString("first_name");
                String apellido = resultSet.getString("last_name");
                String fecha = resultSet.getString("last_update");
                actors.add(new DTOActor(id,nombre,apellido,fecha));
            }

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return actors;
    }

}
