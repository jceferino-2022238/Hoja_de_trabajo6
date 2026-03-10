import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public int pedirCapacidad() {
        System.out.print("¿Cuántos slots tendrá el HashMap? ");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public int pedirCantidadVinilos() {
        System.out.print("¿Cuántos vinilos quieres agregar? ");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public Vinilo pedirVinilo(int numero) {
        System.out.println("\n--- Vinilo #" + numero + " ---");
        System.out.print("Nombre del álbum: ");
        String album = scanner.nextLine().trim();
        System.out.print("Artista: ");
        String artista = scanner.nextLine().trim();
        return new Vinilo(album, artista);
    }

    public void mostrarResultado(HashMap mapa) {
        System.out.println("\n===== RESULTADO DEL HASHMAP =====");
        mapa.mostrarTabla();
        System.out.println("=================================");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}