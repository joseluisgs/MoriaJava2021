package personajes;

import moria.utils.Utils;
import objetos.Anillo;
import objetos.Objeto;
import peligros.Peligro;
import personajes.personalidad.SoyHobbit;

/**
 * Clase de Personaje Hobbit
 */
public final class Hobbit extends Personaje implements SoyHobbit {


    /**
     * Constructor de Hobbit
     *
     * @param nombre   nombre
     * @param vivo     si esta vivo tru/false
     * @param objeto   objeto que porta
     * @param probHuir probabilidad de huida
     */
    public Hobbit(String nombre, boolean vivo, Objeto objeto, int probHuir) {
        super(nombre, vivo, objeto, probHuir);
    }

    /**
     * Acción de Ponerse el Anillo
     */
    public void ponerseAnillo() {
        System.out.println("--> " + this.getNombre() + " Me pongo el anillo");
        ((Anillo)this.objeto).setPuesto(true);
    }

    /**
     * Acción de quitarse el anillo
     */
    public void quitarseAnillo() {
        System.out.println("--> " + this.getNombre() + " Me pongo el anillo");
        ((Anillo)this.objeto).setPuesto(false);
    }

    /**
     * Decidir si se pone o se quita el anillo
     * @return true false es la decisión de ponerse el anillo
     */
    private boolean decidir() {
        System.out.println("--> " + this.getNombre() + " toma una decisión");
        return Utils.probabilidad(50, 100);
    }

    /**
     * Supera el peligro de Habilidad
     * @param limite limite de la probabilidad
     * @return true o false si lo supera
     */
    private boolean superarPeligroHabilidad(int limite) {
        boolean superar = Utils.probabilidad(limite, 100);
        if (superar) {
            this.quitarseAnillo();
            return this.peligroSuperado();
        } else {
            System.out.println("--> " + this.getNombre() + " no ha superado el peligro :(");
            return this.huir();
        }
    }

    /**
     * Método de acción ante el peligro
     * @param peligro peligro sobre el que actuar
     * @return true o false si lo superamos
     */
    public boolean accion(Peligro peligro) {
        System.out.println("--> " + this.getNombre() + " entra en acción");
        // Tomamos una decisión al 50%
        boolean decision = this.decidir();
        if (decision) {
            System.out.println("--> " + this.getNombre() + " decide no ponerse el anillo");
            this.ponerseAnillo();
            // Lo superamos el 90%
           return this.superarPeligroHabilidad(90);
        } else {
            System.out.println("--> " + this.getNombre() + " decide no ponerse el anillo");
            // Solo lo superamos en el 20% de los casos
            return this.superarPeligroHabilidad(20);
        }
    }
}
