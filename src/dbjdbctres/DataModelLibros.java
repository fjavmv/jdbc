package dbjdbctres;
public class DataModelLibros {
    private int libroId;
    private String tituloLibro;
    private String editorialLibro;
    private int autorId;

    public DataModelLibros(int libroId) {
        this.libroId = libroId;
    }
    public DataModelLibros(String tituloLibro, String editorialLibro, int autorId) {
        this.tituloLibro = tituloLibro;
        this.editorialLibro = editorialLibro;
        this.autorId = autorId;
    }
    public DataModelLibros(int libroId, String tituloLibro, String editorialLibro) {
        this.libroId = libroId;
        this.tituloLibro = tituloLibro;
        this.editorialLibro = editorialLibro;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }
    public String getEditorialLibro() {
        return editorialLibro;
    }
    public int getAutorId() {
        return autorId;
    }
    public int getLibroId() {
        return libroId;
    }

    @Override
    public String toString(){
        return  tituloLibro + editorialLibro + autorId;
    }
}
