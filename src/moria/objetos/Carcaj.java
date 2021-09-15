package moria.objetos;

/**
 * Clase de Carcaj
 */
public final class Carcaj extends Objeto {
    private int cantidad;

    /**
     * Constructor de carcaj
     *
     * @param cantidad Número de Flechas iniciales
     */
    public Carcaj(int cantidad) {
        super("Carcaj");
        this.cantidad = cantidad;
    }

    /**
     * Devuelve la cantidad de flechas que tiene el carcaj
     *
     * @return cantidad de flechas
     */
    public int getCantidad() {
        return this.cantidad;
    }

    /**
     * Establece la cantidad de flechas del carcaj
     *
     * @param cantidad cantidad de flechas
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Carcaj{" +
                "cantidad=" + cantidad +
                '}';
    }
}