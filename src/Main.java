import dbjdbctres.DataModelLibros;
import dbjdbctres.DbOperaciones;

import java.util.ArrayList;
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

        ArrayList<DataModelLibros> libros = new ArrayList<>();
        libros.add(new DataModelLibros("El retrato de Dorian Gray 2","Desconocido",37));
        libros.add(new DataModelLibros("Ana Karenina 2","Desconocido",38));
        libros.add(new DataModelLibros("El Principito 2","Desconocido",39));
        libros.add(new DataModelLibros("El proceso 2","Desconocido",40));
        libros.add(new DataModelLibros("El ruido y la furia 2","Desconocido",41));
        libros.add(new DataModelLibros("Hamlet 2","Desconocido",42));
       // DbOperaciones.insercionMultiple(libros);
        //System.out.println("Datos insertados correstamente: "+ libros.size());
       // System.out.println("OPeración finalizada...." + DbOperaciones.actualizarElementos(new DataModelLibros(11,"Don quijote de la mancha 3", "Desconocido")));
        System.out.println("OPeración finalizada...." + DbOperaciones.eliminarElemento(new DataModelLibros(11)));


    }
}