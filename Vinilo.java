public class Vinilo {
    private String nombreAlbum;
    private String artista;

    public Vinilo(String nombreAlbum, String artista) {
        this.nombreAlbum = nombreAlbum;
        this.artista = artista;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public String getArtista() {
        return artista;
    }

    @Override
    public String toString(){
        return nombreAlbum + " - " + artista;
    }
}