package dbjdbcuno;

import java.sql.*;

public class DbConection {
    /*
    Para establcer la conexión al PostgreSQL database server es necesario llamar al método getConnection de la clase DriverManager
    el cual retorna un objeto de tipo Connection.
     */
    public static Connection conectarDb() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASSWORD);
            System.out.println("La conexión se ha realizado de manera exitosa...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }

    public static Connection conectarDbR() throws SQLException {
        return DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASSWORD);
    }

    //initCap(), Esta función pone en mayúscula la primera letra de cada palabra en una cadena de texto
    //El método llamadaAFuncion() acepta una cadena y devuelve su formato de mayúsculas y minúsculas adecuado.
    //Una sentencia SQL determinada contiene caracteres "?" (marcadores de parámetro) para representar los valores que se suministrarán en el momento de la ejecución.
    public static String llamadaAFuncion(String data) {
        String resultado = data;
        try (Connection connection = conectarDb();
             CallableStatement callableStatement = connection.prepareCall("{ ? = CALL initcap( ? ) }")) {
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.setString(2, data);
            callableStatement.execute();
            resultado = callableStatement.getString(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    public static void obtener(String patron, int year) {
        try (Connection connection = conectarDb();
             PreparedStatement prepareStatement = connection.prepareStatement(DbConfig.QUERY))
        {
            prepareStatement.setString(1, patron);
            prepareStatement.setInt(2, year);

            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next())
            {
                System.out.println(String.format("%s %d",
                        resultSet.getString("film_title"),
                        resultSet.getInt("film_release_year")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
