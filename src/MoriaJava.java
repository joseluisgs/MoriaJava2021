import moria.Moria;
import moria.MoriaBuilder;

/**
 * Clase Principal
 */
public class MoriaJava {
    public static void main(String[] args) {
        System.out.println("*** ¡BIENVENIDOS A MORIA! ***");
        System.out.println();
        // Declaramos la clase principal, usando singleton dentro del Builder y además es nuestro patron fachada
        // https://refactoring.guru/es/design-patterns/builder
        // https://refactoring.guru/es/design-patterns/singleton
        // https://refactoring.guru/es/design-patterns/facade

        Moria moria = new MoriaBuilder()
                .conTotalSalas(36)
                .conEnergiaVara(30)
                .conFlechasCarcaj(10)
                .conMaxPoderMaligoEnSala(10)
                .conMaxFlechasEnSala(5)
                .conMaxEnemigosEnSala(10)
                .build();
        System.out.println(moria.toString());
        System.out.println();
        // Inicializamos el sistema (Irá dentro del Builder)
        moria.init();
        //moria.test();
        // Ejecutamos
        moria.run();
        System.out.println("*** FIN ***");
    }
}
