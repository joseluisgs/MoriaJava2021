package moria.objetos;

/**
 * Clase del objeto Vara
 */
public final class Vara extends Objeto {
    private int energia;

    /**
     * Constructor de Vara
     *
     * @param energia Energía de la vara
     */
    public Vara(int energia) {
        super("Vara");
        this.energia = energia;
    }

    /**
     * Obtiene la energía de la vara
     *
     * @return energía
     */
    public int getEnergia() {
        return this.energia;
    }

    /**
     * Establece el valor de la energía de l avara
     *
     * @param energia valor de energía
     */
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    @Override
    public String toString() {
        return "Vara{" +
                "energia=" + energia +
                '}';
    }
}