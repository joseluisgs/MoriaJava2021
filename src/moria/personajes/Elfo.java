package moria.personajes;

import moria.objetos.Carcaj;
import moria.objetos.Objeto;
import moria.peligros.Accion;
import moria.peligros.Peligro;
import moria.personajes.personalidad.Arquero;

/**
 * Clase de Personaje Elfo
 */
public final class Elfo extends Personaje implements Arquero {

    /**
     * Constructor de Elfo
     *
     * @param nombre   nombre
     * @param vivo     si esta vivo tru/false
     * @param objeto   objeto que porta
     * @param probHuir probabilidad de huida
     */
    public Elfo(String nombre, boolean vivo, Objeto objeto, int probHuir) {
        super(nombre, vivo, objeto, probHuir);
    }

    /**
     * Lanza una fecha
     */
    public void lanzarFlecha() {
        Carcaj carcaj = (Carcaj) this.objeto;
        carcaj.setCantidad(carcaj.getCantidad() - 1);
    }

    /**
     * Recarga el Carcaj con una cantidad de flechas
     *
     * @param flechas número de flechas con la que recargo el carcaj
     */
    public void recargarCarcaj(int flechas) {
        Carcaj carcaj = (Carcaj) this.objeto;
        carcaj.setCantidad(carcaj.getCantidad() + flechas);
    }

    /**
     * Método de acción ante el peligro
     *
     * @param peligro peligro al que debemos realizar la acción
     * @return true o false si lo superamos
     */
    public boolean accion(Peligro peligro) {
        System.out.println("--> " + this.getNombre() + " entra en acción");
        // Tenemos flechas (le restamos a los enemigos
        int estado = ((Carcaj) this.objeto).getCantidad() - ((Accion) peligro).getEnemigos();
        if (estado >= 0) {
            System.out.println("--> Tenemos más flechas que enemigos :)");
            // Matamos
            System.out.println("--> " + this.getNombre() + " dispara a los enemigos");
            this.matarEnemigos(((Accion) peligro).getEnemigos());
            this.recogerFlechas(((Accion) peligro).getFlechas());
            return this.peligroSuperado();
        } else {
            // No tenemos suficientes flechas
            System.out.println("--> No tenemos suficiente flechas. Los enemigos nos superan :(");
            this.matarEnemigos(((Carcaj) this.objeto).getCantidad());
            if (this.huir()) {
                // Recogemos las flechas
                this.recogerFlechas(((Accion) peligro).getFlechas());
                return true;
            } else return false;
        }
    }

    /**
     * Elimina a los enemigos de la sala con disparos
     *
     * @param disparos Número de disparos a realizar
     */
    private void matarEnemigos(int disparos) {
        for (int i = 0; i < disparos; i++) {
            this.lanzarFlecha();
        }
    }

    /**
     * Recoge flechas de la sala y las carga en el Carcaj
     *
     * @param flechas cantidad de flechas recogidas
     */
    private void recogerFlechas(int flechas) {
        System.out.println("--> " + this.getNombre() + " recoge " + flechas + " flechas de la sala");
        this.recargarCarcaj(flechas);
    }


}
