package dbjdbctres;
public class DTOLibro {
    private int libroId;
    private String tituloLibro;
    private String editorialLibro;
    private int autorId;

    public DTOLibro(){

    }
    public DTOLibro(int libroId) {
        this.libroId = libroId;
    }
    public DTOLibro(String tituloLibro, String editorialLibro, int autorId) {
        this.tituloLibro = tituloLibro;
        this.editorialLibro = editorialLibro;
        this.autorId = autorId;
    }
    public DTOLibro(int libroId, String tituloLibro, String editorialLibro, int autorId) {
        this.libroId = libroId;
        this.tituloLibro = tituloLibro;
        this.editorialLibro = editorialLibro;
        this.autorId = autorId;
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

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public void setEditorialLibro(String editorialLibro) {
        this.editorialLibro = editorialLibro;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    @Override
    public String toString(){
        return libroId + tituloLibro + editorialLibro + autorId;
    }
}
