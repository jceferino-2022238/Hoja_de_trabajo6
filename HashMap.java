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
    private int generarHash(Striing clave) {
        
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

}
