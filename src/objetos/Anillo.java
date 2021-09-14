package objetos;

/**
 * Clase de Anillo
 */
public final class Anillo extends Objeto {
    private boolean puesto;

    /**
     * Constructor de anillo. Por defector puesto es False
     */
    public Anillo() {
        super("Anillo");
        this.puesto = false;
    }

    /**
     * Devuelve Si está puesto
     * @return true/false
     */
    public final boolean getPuesto() {
        return this.puesto;
    }

    /**
     * Indica si esta puesto
     * @param puesto true/false
     */
    public final void setPuesto(boolean puesto) {
        this.puesto = puesto;
    }
}