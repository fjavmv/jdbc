package dbpgjdbcdos;

public class DataModelActor {
  private String id;
  private String nombre;
  private String apellido;

  private String updateAt;

    public DataModelActor(String id, String nombre, String apellido, String updateAt) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.updateAt = updateAt;
    }

    public String getId() {
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
        return id + " " + nombre + " " + apellido + " " + updateAt;
    }

}
