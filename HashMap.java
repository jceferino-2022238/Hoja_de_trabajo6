public class HashMap {
    
    private static class Nodo { //static para que no dependa
        String clave;
        Vinilo valor;
        Nodo siguiente;

        public Nodo(String clave, Vinilo valor){
            this.clave = clave;
            this.valor = valor;
            this.siguiente = null;
        }
    }

    private Nodo[] tabla; //array principal

    public HashMap(int capacidad) {
        if (capacidad <= 0) capacidad = 10;
        tabla = new Nodo[capacidad];
    }

    //generación de hash
    private int generarHash(String clave) {
        
        if (clave == null) return 0;
        clave = clave.toLowerCase().trim(); //para evitar problemas de mayúsculas o espacios

        long suma = 0L; //long para evitar overflow de int

        for (int i = 0; i < clave.length(); i++) { //recorrer cada caracter
            int ascii = (int) clave.charAt(i); //obtener valor ascii
            int peso = i + 1; //peso basado en la posición (1 para el primer caracter, 2 para el segundo...)
            suma += (long) ascii * peso; //multiplicar ascii por peso y acumular
        }
        return (int)((suma % tabla.length + tabla.length) % tabla.length);
    }
    // Método para insertar el Vinilo junto a su clave en el hashmap.
    public void put(String clave, Vinilo valor) {
    int indice = generarHash(clave);
    Nodo actual = tabla[indice];

    while (actual != null) {
        if (actual.clave.equals(clave)) {
            actual.valor = valor; // actualizar la clave si es necesario
            return;
        }
        actual = actual.siguiente;
    }

    // Insertar el nuevo nodo en el head
    Nodo nuevo = new Nodo(clave, valor);
    nuevo.siguiente = tabla[indice];
    tabla[indice] = nuevo;
    }

    // Getter de un Vinilo en específico.
    public Vinilo get(String clave) {
        int indice = generarHash(clave);
        Nodo actual = tabla[indice];

        while (actual != null) {
            if (actual.clave.equals(clave)) return actual.valor;
            actual = actual.siguiente;
        }
        return null;
    }

    // Mostrar toda la tabla de vinilos con sus claves.

    public void mostrarTabla() {
        for (int i = 0; i < tabla.length; i++) {
            System.out.print("Índice [" + i + "]: ");
            Nodo actual = tabla[i];
            if (actual == null) {
                System.out.println("vacío");
            } else {
                while (actual != null) {
                    System.out.print("[" + actual.clave + " → " + actual.valor + "]");
                    if (actual.siguiente != null) System.out.print(" → ");
                    actual = actual.siguiente;
                }
                System.out.println();
            }
        }
    }

}
