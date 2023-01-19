import dbjdbctres.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
      // System.out.println(dbjdbcuno.DbConection.llamadaAFuncion("mensaje mensaje dos"));
       //DbConection.obtener("%di",2006);
       // System.out.println(DbConsultar.contarActores());
        //DbConsultar.getActores();
        //DbConsultar.consultarActoresDePeliculas();

       /* DataModelLibros dataModelLibros = new DataModelLibros("Don Quijote de la Mancha 2","Desconocido", 36);
        DbInsertar.insertarLibros(dataModelLibros);
        System.out.println("Se ha insertado de manera correcta: " + dataModelLibros.getTituloLibro()+" "+
                dataModelLibros.getEditorialLibro()+" "+ dataModelLibros.getAutorId());*/

        ArrayList<DTOLibro> libros = new ArrayList<>();
        libros.add(new DTOLibro("El retrato de Dorian Gray 2","Desconocido",37));
        libros.add(new DTOLibro("Ana Karenina 2","Desconocido",38));
        libros.add(new DTOLibro("El Principito 2","Desconocido",39));
        libros.add(new DTOLibro("El proceso 2","Desconocido",40));
        libros.add(new DTOLibro("El ruido y la furia 2","Desconocido",41));
        libros.add(new DTOLibro("Hamlet 2","Desconocido",42));
       // DbOperaciones.insercionMultiple(libros);
        //System.out.println("Datos insertados correstamente: "+ libros.size());
      // System.out.println("OPeración finalizada...." + DbOperaciones.actualizarElementos(new DataModelLibros(12,"Don quijote de la mancha 3", "Desconocido")));
       // System.out.println("OPeración finalizada...." + DAOOperaciones.eliminarElemento(new DTOLibros(12)));

        String data = "'dato':1 'dato':2 'data':6";

        Map<String, Integer> map = new HashMap<>();
        map.put("val1", 2);
        map.put("val2", 3);
        map.put("val3", 4);
        map.put("val4", 5);

        Vector<String> data2 = new Vector<>();
        data2.addElement("'val 1': 2");
        data2.addElement("'val 2': 4");
        data2.addElement("'val 3': 5");
        data2.addElement("'val 4': 6");

        DTOPelicula dtoPelicula = new DTOPelicula(
                "Ejemplo 100", "Ejemplo",2009,
                1, 5, 2,
                6, "2023-01-19",data2);
        DAOOperaciones.insertarPelicula(dtoPelicula);


         //new Report();

    }
}