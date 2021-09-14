package moria;

import moria.personajes.Personaje;
import moria.salas.Sala;
import moria.tdas.Cola;

/**
 * Moria es nuestra clase principal. Actúa como controlador
 * Se crea como singleton para asegurar que solo hay una instancia (opcional)
 * https://refactoring.guru/es/design-patterns/singleton
 * https://blog.mindorks.com/how-to-create-a-singleton-class-in-kotlin
 * Tambien se puede implementar como patrón builder (parámetros)
 * https://refactoring.guru/es/design-patterns/builder
 * Es la fachada de nuestro problema
 * https://refactoring.guru/es/design-patterns/facade
 */
public final class Moria {

    // implementamos el Singleton
    private static Moria instance = null;
    // Hacemos el constructor privado
    private Moria(){}

    // Lanzamos la petición de instancia
    public static Moria getInstance() {
        if (instance==null) {
            instance=new Moria();
        }
        return instance;
    }

    // No es necesario fijar los valores aquí si usamos el Build, porque los tiene él
    // Constantes del sistema para tener parametrizado su ejecución y no mezclada en el código
    private int MAX_ENERGIA = 30;
    private int MAX_FLECHAS = 10;
    private int MAX_SALAS = 36;
    private int MAX_SALA_MALIGNO = 10;
    private int MAX_SALA_FLECHAS = 5;
    private int MAX_SALA_ENEMIGOS = 10;

    // Condiciones del run
    private boolean VIVOS = true;
    private boolean MUERTOS = false;

    // Personajes, son abstract y luego los iniciamos con el tipo concreto (polimorfismo)
    // es una forma simplificada y reducida de apliacar una factoria
    // https://refactoring.guru/es/design-patterns/factory-method
    private Personaje gandalf;
    private Personaje legolas;
    private Personaje frodo;

    // Lista de salas. Usamos esta clase propia que implementa este comportamiento
    private Cola<Sala> salas = new Cola<Sala>();

    // Variables de ejecución
    private Sala salaActual;
    private boolean estado = VIVOS;


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
