package peligros;

/**
 * Clase del Peligro Accion
 */
public final class Accion extends Peligro {
    private int flechas;
    private int enemigos;

    /**
     * Construcctor del Peligro Acción
     * @param flechas Flechas necesarias
     * @param enemigos Enemigos existentes
     */
    public Accion(int flechas, int enemigos) {
        super("Acción");
        this.flechas = flechas;
        this.enemigos = enemigos;
    }

    /**
     * Obtiene las flechas
     * @return numero de flechas
     */
    public int getFlechas() {
        return this.flechas;
    }

    /**
     * Establece el número de flechas
     * @param flechas número de flechas
     */
    public void setFlechas(int flechas) {
        this.flechas = flechas;
    }

    /**
     * Obtiene los enemigos
     * @return número de enemigos
     */
    public int getEnemigos() {
        return this.enemigos;
    }

    /**
     * Establece el número de enemigos
     * @param enemigos número de enemigos
     */
    public void setEnemigos(int enemigos) {
        this.enemigos = enemigos;
    }
}
