import moria.Moria;
import moria.MoriaBuilder;

/**
 * Clase Principal
 */
public class MoriaJava {
    public static void main(String[] args) {
        System.out.println("BIENVENIDOS A MORIA! ***");
        System.out.println();
        // Declaramos la clase principal, usando singleton dentro del Builder y además es nuestro patron fachada
        // https://refactoring.guru/es/design-patterns/builder
        // https://refactoring.guru/es/design-patterns/singleton
        // https://refactoring.guru/es/design-patterns/facade

        MoriaBuilder builder = new MoriaBuilder();
        Moria moria = builder.conTotalSalas(3999999)
                .conMaxPoderMaligoEnSala(10)
                .conEnergiaVara(30)
                .build();
        System.out.println(moria.toString());
        System.out.println("***");
    }
}
