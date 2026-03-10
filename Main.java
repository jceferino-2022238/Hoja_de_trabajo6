public class Main {
    public static void main(String[] args) {
        View view = new View();

        int capacidad = view.pedirCapacidad();
        HashMap mapa = new HashMap(capacidad);

        int cantidad = view.pedirCantidadVinilos();

        for (int i = 1; i <= cantidad; i++) {
            Vinilo vinilo = view.pedirVinilo(i);
            // Usar el nombre del álbum como la key
            mapa.put(vinilo.getNombreAlbum(), vinilo);
            view.mostrarMensaje("Vinilo agregado.");
        }

        view.mostrarResultado(mapa);
    }
}