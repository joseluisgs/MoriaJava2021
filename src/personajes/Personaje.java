package personajes;

import moria.utils.Utils;
import objetos.Objeto;
import peligros.Peligro;

/**
 * Clase de Personaje
 */
public abstract class Personaje {
    private final int probHuir;
    private final String nombre;
    private boolean vivo;
    private Objeto objeto;

    /**
     * Constructor de Personaje
     * @param nombre nombre de persojae
     * @param vivo true/false vivo/muerto
     * @param objeto objeto que porta
     * @param probHuir probabilidad de huir
     */
    public Personaje(String nombre, boolean vivo, Objeto objeto, int probHuir) {
        this.nombre = nombre;
        this.vivo = vivo;
        this.objeto = objeto;
        this.probHuir = probHuir;
    }

    /**
     * Acción a realizar según el tipo de peligro
     * @param peligro peligro al que debemos realizar la acción
     * @return si lo hemos superado o no true/false
     */
    public abstract boolean accion(Peligro peligro);

    /**
     * Acción de Huir. Lo hago Final para que nadie lo pueda sobrescribir
     * @return true/false si conseguimos huir
     */
    public final boolean huir() {
        System.out.println("--> Intentando huir :S");
        boolean sorteo = Utils.probabilidad(this.probHuir, 100);
        if (sorteo) {
            System.out.println("--> Hemos tenido suerte y podemos huir :)");
            return true;
        } else {
            System.out.println("--> No hemos tenido suerte y no podemos huir :_(");
            return false;
        }
    }

    /**
     * Indica que se ha superado el peligro
     * @return true
     */
    public final boolean peligroSuperado() {
        System.out.println("--> " + this.nombre + " ha superado el peligro. ¡Continuamos! :)");
        return true;
    }

    /**
     * Obtiene el nombre
     * @return nombre del Personaje
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene si está vivo
     * @return true/false (vivo/muerto)
     */
    public boolean getVivo() {
        return this.vivo;
    }

    /**
     * Establece si el personaje está vivo o muerto
     * @param vivo true/false (vivo/muerto)
     */
    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    /**
     * Obtiene el objeto a portar
     * @return objeto
     */
    public Objeto getObjeto() {
        return this.objeto;
    }

    /**
     * Establece el objeto a portar
     * @param objeto objeto a portar
     */
    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }
}
