package dbjdbctres;

public class DTOAutor {
    int idAutor;
    String nombre;
    String apellidoM;
    String apellidoP;
    public DTOAutor(int idAutor, String nombre, String apellidoM, String apellidoP) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.apellidoM = apellidoM;
        this.apellidoP = apellidoP;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getApellidoP() {
        return apellidoP;
    }


    @Override
    public String toString(){
        return idAutor + nombre + apellidoM + apellidoP;
    }
}
