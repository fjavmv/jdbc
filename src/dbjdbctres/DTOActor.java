package dbjdbctres;

import org.codehaus.groovy.ast.ImportNode;

public class DTOActor {
  private int id;
  private String nombre;
  private String apellido;

  private String updateAt;

  public DTOActor(){

  }

    public DTOActor(int id, String nombre, String apellido, String updateAt) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    @Override
    public String toString(){
        return id +" "+ nombre+" " + apellido+" "  + updateAt;
    }

}
