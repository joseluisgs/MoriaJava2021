package moria;

import moria.objetos.Anillo;
import moria.objetos.Carcaj;
import moria.objetos.Vara;
import moria.peligros.Accion;
import moria.peligros.Habilidad;
import moria.peligros.Magico;
import moria.personajes.Elfo;
import moria.personajes.Hobbit;
import moria.personajes.Mago;
import moria.personajes.Personaje;
import moria.salas.Sala;
import moria.tdas.Cola;
import moria.tdas.ICola;
import moria.utils.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


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
    private boolean estado = VIVOS;
    // No es necesario fijar los valores aquí si usamos el Build, porque los tiene él
    // Constantes del sistema para tener parametrizado su ejecución y no mezclada en el código
    private int MAX_ENERGIA;
    private int MAX_FLECHAS;
    private int MAX_SALAS;
    private int MAX_SALA_MALIGNO;
    private int MAX_SALA_FLECHAS;
    private int MAX_SALA_ENEMIGOS;
    // Personajes, son abstract y luego los iniciamos con el tipo concreto (polimorfismo)
    // es una forma simplificada y reducida de aplicar una factoría
    // https://refactoring.guru/es/design-patterns/factory-method
    private Personaje gandalf;
    private Personaje legolas;
    private Personaje frodo;
    // Variables de ejecución
    private Sala salaActual;
    // Fichero y su path
    private final String FILE_REPORT = "moria.txt";

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

    /**
     * Me gusta definir las cosas en el init para evitar ensuciar el código
     * diferencia con constructor es que este está pensado para tareas más "cargadas" y una vez creado el objet
     * Le asigna los valores que queramos
     */
    public void init() {
        initPersonajes();
        initSalas();
    }

    /**
     * Iniciamos los personajes
     */
    private void initPersonajes() {
        // Como vemos estamos realizando una inyección de dependencias usando agregaciones con objetos abstracts para objeto
        // de nuevo aplicamos polimorfismo en nuestro intento de hacer una factoría de manera reducida
        // Además aplicamos inyección de dependencias para no acoplar el tipo de objetos
        // https://www.arquitecturajava.com/el-patron-de-inyeccion-de-dependencia/
        gandalf = new Mago("Gandalf", true, new Vara(MAX_ENERGIA), 80);
        legolas = new Elfo("Legolas", true, new Carcaj(MAX_FLECHAS), 80);
        frodo = new Hobbit("Frodo", true, new Anillo(), 80);
    }

    /**
     * Iniciamos las salas
     */
    private void initSalas() {
        // Como es Fifo añadimos siempre al final. De nuevo inyectamos la dependencia del peligro
        for (int i = 1; i <= MAX_SALAS; i++) {
            switch (new Random().nextInt(3)) {
                case 0:
                    salas.encolar(new Sala(i, new Magico(new Random().nextInt(MAX_SALA_MALIGNO) + 1)));
                    break;
                case 1:
                    salas.encolar(new Sala(i, new Accion(new Random().nextInt(MAX_SALA_FLECHAS) + 1, new Random().nextInt(MAX_SALA_ENEMIGOS) + 1)));
                    break;
                case 2:
                    salas.encolar(new Sala(i, new Habilidad()));
                    break;
            }
        }
    }

    /**
     * Método principal de ejecución
     */
    public void run() {
        // Presentamos
        presentacion();

        // Nos movemos por la sala
        while (this.salas.size() >= 1 && this.estado == this.VIVOS) {
            this.entrarSala();
            this.estado = this.analizarActuar();
        }

        // Imprimimos el informe
        informe();
    }

    /**
     * Mensajes de presentación y entradas en el fichero de historias de ejecución
     */
    private void presentacion() {
        LocalDateTime dateTime = LocalDateTime.now();
        String momento = dateTime.format(DateTimeFormatter.ofPattern("dd/M/y H:m:ss"));
        String mensaje = "*** ABRIENDO LAS PUERTAS DE MORIA ***";
        System.out.println(mensaje);
        System.out.println();
        // Escribimos en el fichero
        añadirInforme(mensaje + " -> " + momento + '\n');
    }

    /**
     * Escribe el informe
     *
     * @param texto texto del informe
     */
    private void añadirInforme(String texto) {
        Utils.escribirFichero(FILE_REPORT, texto);
    }

    /**
     * Desencolamos una sala de la lista
     */
    private void entrarSala() {
        this.salaActual = this.salas.desencolar();
        System.out.println("*** Entrando en la sala nº: " + this.salaActual.getNumero() + ". Es del tipo: " + this.salaActual.getPeligro().getTipo());
    }

    /**
     * Analiza la sala e indica quién debe actuar
     *
     * @return Boolean True si continuar, false si hemos caído en la sala
     */
    private boolean analizarActuar() {
        // Dependiendo del peligro, así se actuará
        if (this.salaActual.getPeligro() instanceof Magico) {
            return gandalf.accion(this.salaActual.getPeligro());
        } else if (this.salaActual.getPeligro() instanceof Accion) {
            return legolas.accion(this.salaActual.getPeligro());
        } else if (this.salaActual.getPeligro() instanceof Habilidad) {
            return frodo.accion(this.salaActual.getPeligro());
        } else {
            return MUERTOS;
        }
    }


    /**
     * Informe final en pantalla y en el fichero de historias de ejecución
     */
    private void informe() {
        LocalDateTime dateTime = LocalDateTime.now();
        String momento = dateTime.format(DateTimeFormatter.ofPattern("dd/M/y H:m:ss"));
        String mensaje = "--------------";
        System.out.println(mensaje);
        if (this.estado == this.VIVOS) {
            mensaje = "--> NUESTROS HEROES HAN SUPERADO LOS PELIGROS DE MORIA :)\n";
            mensaje = mensaje + "--> NUEVOS PELIGROS LES AGUARDAN EN EL FUTURO :)\n";
        } else {
            mensaje = "--> NUESTROS HEROES HAN CAÍDO EN MORIA :__(\n";
            mensaje += "--> NO HAN PODIDO PASAR DE LA SALA: " + this.salaActual.getNumero() + "\n";
        }
        mensaje = mensaje + "*** CERRANDO LAS PUERTAS DE MORIA ***";
        System.out.println(mensaje);
        añadirInforme(mensaje + " -> " + momento + "\n\n");
    }


    /**
     * Función de test
     */
    public void test() {
        // Probamos los personajes
        System.out.println("Personajes");
        System.out.println(gandalf.toString());
        System.out.println(legolas.toString());
        System.out.println(frodo.toString());

        System.out.println("Salas");
        // Forma for each estructurada
//        for(Sala s: salas ) {
//            System.out.println(s.toString());
//        }
        // Forma usando programación funcional
        // https://santanderglobaltech.com/programacion-en-java-stream-para-dummies/
        // https://windoctor7.github.io/API-Stream-Java8.html
        // https://stackify.com/streams-guide-java-8/
        // https://www.adictosaltrabajo.com/2016/06/23/uso-basico-de-java-8-stream-y-lambdas/
        salas.forEach(s -> {
            System.out.println(s.toString());
        });
        // Jugando con la API STREAM y Funcional
        System.out.println("Resumen");
        System.out.println("Numero de salas de peligro mágico: " + salas.stream().filter(s -> s.getPeligro() instanceof Magico).count());
        System.out.println("Numero de salas de peligro acción: " + salas.stream().filter(s -> s.getPeligro() instanceof Accion).count());
        System.out.println("Numero de salas de peligro habilidad: " + salas.stream().filter(s -> s.getPeligro() instanceof Habilidad).count());
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
