import moria.Moria;

/**
 * Clase Principal
 */
public class MoriaJava {
    public static void main(String[] args) {
        System.out.println("ENVENIDOS A MORIA! ***");
        System.out.println();
        // Declaramos la clase principal, usando singleton (opcional) Builder y además es nuestro patron fachada
        // https://refactoring.guru/es/design-patterns/builder
        // https://refactoring.guru/es/design-patterns/singleton
        // https://refactoring.guru/es/design-patterns/facade

        Moria moria = Moria.getInstance();
        System.out.println(moria.toString());
        System.out.println(" ***");
    }
}
