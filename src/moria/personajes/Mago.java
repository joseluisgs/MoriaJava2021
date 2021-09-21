package moria.personajes;

import moria.objetos.Objeto;
import moria.objetos.Vara;
import moria.peligros.Magico;
import moria.peligros.Peligro;
import moria.personajes.personalidad.Hechicero;
import moria.utils.Utils;

import java.util.Random;

public final class Mago extends Personaje implements Hechicero {

    /**
     * Constructor de Mago
     *
     * @param nombre   nombre
     * @param vivo     si esta vivo tru/false
     * @param objeto   objeto que porta
     * @param probHuir probabilidad de huida
     */
    public Mago(String nombre, boolean vivo, Objeto objeto, int probHuir) {
        super(nombre, vivo, objeto, probHuir);
    }

    /**
     * Recarga la vara con energía
     *
     * @param energia energía de la vara
     */
    public void recargarVara(int energia) {
        Vara vara = (Vara) this.objeto;
        vara.setEnergia(vara.getEnergia() - energia);
    }

    /**
     * Nos indica el poder de la vara
     *
     * @return poder de la vara
     */
    public int poderVara() {
        return ((Vara) this.objeto).getEnergia();
    }

    /**
     * Si ha ganado o superado su reto
     *
     * @param limite limite de probabilidad
     * @return true o false
     */
    private boolean ganar(int limite) {
        System.out.println("--> " + this.getNombre() + " intenta ganar al peligro :(");
        boolean ganar = Utils.probabilidad(limite, 100);
        if (ganar) {
            return this.peligroSuperado();
        } else {
            System.out.println("--> " + this.getNombre() + " no ha superado el peligro :(");
            return this.huir();
        }
    }

    /**
     * Método de acción ante el peligro
     *
     * @param peligro peligro sobre el que actuar
     * @return true o false si lo superamos
     */
    public boolean accion(Peligro peligro) {
        System.out.println("--> " + this.getNombre() + " entra en acción");
        // Recargamos la vara entre 1 y 10
        System.out.println("--> " + this.getNombre() + " recarga la vara");
        this.recargarVara(new Random().nextInt(10));
        // Si el poder es mayor
        if (this.poderVara() > ((Magico) peligro).getPoder()) {
            System.out.println("--> la vara es más poderosa que el peligro :)");
            return this.peligroSuperado();
        } else if (this.poderVara() == ((Magico) peligro).getPoder()) {
            // Si es igual ganamos en el 60%
            System.out.println("--> la vara es tan poderosa como el peligro :|");
            return this.ganar(60);
        } else {
            // Si es menor solo en el 30%
            System.out.println("--> la vara es menos poderosa que el peligro :(");
            return this.ganar(30);
        }
    }
}
