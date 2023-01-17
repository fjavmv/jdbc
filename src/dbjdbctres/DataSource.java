package dbjdbctres;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import java.util.ArrayList;

public class DataSource implements JRDataSource {
    private final DTOActor [][] actors;
    private int indice;
    public DataSource (){
        indice = -1;
        actors = getActors(DAOOperaciones.getActores());
        recorreMatriz(actors);
    }

    private DTOActor[][] getActors(ArrayList<DTOActor> actors){
        DTOActor [][] actor = new DTOActor[actors.size()][1];
        for (int i = 0; i < actors.size(); i++) {
            for (int j = 0; j < 1 ; j++) {
                actor[i][j] = actors.get(i);
            }
        }
        return actor;
    }

    public void recorreMatriz(DTOActor [][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 1 ; j++) {
                System.out.println(a[i][j]);
            }
        }
    }

    @Override
    public boolean next() throws JRException {
        indice = indice + 1;
        return indice < actors.length;
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object valor = null;
        String campoNombre = jrField.getName();
        switch (campoNombre)
        {
            case "id"  ->    valor = actors[indice][0].getId();
            case "nombre" -> valor = actors[indice][0].getNombre();
            case "apellido" -> valor = actors[indice][0].getApellido();
            case "fecha" -> valor = actors[indice][0].getUpdateAt();
        }
        return valor;
    }

    public static JRDataSource getDataSource(){
        return new DataSource();
    }
}
