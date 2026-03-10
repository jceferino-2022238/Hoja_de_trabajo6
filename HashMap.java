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
}
