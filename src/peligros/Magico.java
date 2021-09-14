package peligros;

/**
 * Clase del Peligro Mágico
 */
public final class Magico extends Peligro {
    private int poder;

    /**
     * Constructor del peligro Mágico
     * @param poder poder a consumir
     */
    public Magico(int poder) {
        super("Mágico");
        this.poder = poder;
    }

    /**
     * Obtiene el poder
     * @return poder
     */
    public int getPoder() {
        return this.poder;
    }

    /**
     * Establece el poder
     * @param poder cantidad de poder
     */
    public void setPoder(int poder) {
        this.poder = poder;
    }
}