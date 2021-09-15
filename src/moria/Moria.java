package moria;

import moria.personajes.Personaje;
import moria.salas.Sala;
import moria.tdas.Cola;
import moria.tdas.ICola;

/**
 * Moria es nuestra clase principal. Actúa como controlador
 * Se crea como singleton para asegurar que solo hay una instancia (opcional)
 * https://refactoring.guru/es/design-patterns/singleton
 * https://blog.mindorks.com/how-to-create-a-singleton-class-in-kotlin
 * También se puede implementar como patrón builder (parámetros)
 * https://refactoring.guru/es/design-patterns/builder
 * Es la fachada de nuestro problema
 * https://refactoring.guru/es/design-patterns/facade
 */
public final class Moria {

    // implementamos el Singleton
    private static Moria instance = null;
    // Condiciones del run
    private final boolean VIVOS = true;
    private final boolean MUERTOS = false;
    // Lista de salas. Usamos esta clase propia que implementa este comportamiento
    // Además vamos a decir que lo definimos por su comportamiento y no por su clase
    // ES decir usamos la interfaz. Esto lo vas a ver mucho :)
    private final ICola<Sala> salas = new Cola<Sala>();
    private final boolean estado = VIVOS;
    // No es necesario fijar los valores aquí si usamos el Build, porque los tiene él
    // Constantes del sistema para tener parametrizado su ejecución y no mezclada en el código
    private int MAX_ENERGIA;
    private int MAX_FLECHAS;
    private int MAX_SALAS;
    private int MAX_SALA_MALIGNO;
    private int MAX_SALA_FLECHAS;
    private int MAX_SALA_ENEMIGOS;
    // Personajes, son abstract y luego los iniciamos con el tipo concreto (polimorfismo)
    // es una forma simplificada y reducida de apliacar una factoria
    // https://refactoring.guru/es/design-patterns/factory-method
    private Personaje gandalf;
    private Personaje legolas;
    private Personaje frodo;
    // Variables de ejecución
    private Sala salaActual;

    // Hacemos el constructor privado
    private Moria() {
    }

    // Lanzamos la petición de instancia
    public static Moria getInstance() {
        if (instance == null) {
            instance = new Moria();
        }
        return instance;
    }

    // Sets para Builder

    /**
     * Establece el numero de salas
     *
     * @param numSalas
     */
    public void setTotalSalas(int numSalas) {
        this.MAX_SALAS = numSalas;
    }

    /**
     * establece la energía inicial de la vara
     *
     * @param energia
     */
    public void setEnergiaInicialVara(int energia) {
        this.MAX_ENERGIA = energia;
    }

    /**
     * Establece la cantidad de flechas iniciales del carcaj
     *
     * @param flechas
     */
    public void setFlechasInicialCarcaj(int flechas) {
        this.MAX_FLECHAS = flechas;
    }

    /**
     * establece el poder maligno de la sala
     *
     * @param poder
     */
    public void setPoderMaligoSala(int poder) {
        this.MAX_SALA_MALIGNO = poder;
    }

    /**
     * Establece en número de flechas por sala
     *
     * @param flechas
     */
    public void setFlechasSala(int flechas) {
        this.MAX_SALA_FLECHAS = flechas;
    }

    /**
     * Establece el número de enemigos pro sala
     *
     * @param enemigos
     */
    public void setEnemigosSala(int enemigos) {
        this.MAX_SALA_ENEMIGOS = enemigos;
    }

    @Override
    public String toString() {
        return "Moria{" +
                "MAX_ENERGIA=" + MAX_ENERGIA +
                ", MAX_FLECHAS=" + MAX_FLECHAS +
                ", MAX_SALAS=" + MAX_SALAS +
                ", MAX_SALA_MALIGNO=" + MAX_SALA_MALIGNO +
                ", MAX_SALA_FLECHAS=" + MAX_SALA_FLECHAS +
                ", MAX_SALA_ENEMIGOS=" + MAX_SALA_ENEMIGOS +
                '}';
    }
}
