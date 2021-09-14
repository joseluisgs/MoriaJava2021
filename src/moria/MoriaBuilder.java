package moria;

public class MoriaBuilder implements IBuilder {
    // Parámetros por defecto para el Builder si queremos
    private int energiaVara = 30;
    private int flechasCarcaj = 10;
    private int numSalas = 36;
    private int maxMaligno = 10;
    private int maxFlechas = 5;
    private int maxEnemigos = 10;

    // El constructor es el por defecto

    // Setter del Builder, devolvemos this para crear una interfaz fluida

    /**
     * Establece el poder inicial de la Vara
     *
     * @param energiaVara
     * @return
     */
    public MoriaBuilder conEnergiaVara(int energiaVara) {
        this.energiaVara = energiaVara;
        return this;
    }

    /**
     * Establece el valor inicial de las flechas
     *
     * @param flechasCarcaj
     * @return
     */
    public MoriaBuilder conFlechasCarcaj(int flechasCarcaj) {
        this.flechasCarcaj = flechasCarcaj;
        return this;
    }

    /**
     * Establece el total de salas
     *
     * @param numSalas
     * @return
     */
    public MoriaBuilder conTotalSalas(int numSalas) {
        this.numSalas = numSalas;
        return this;
    }

    /**
     * Establece el poder maximo maligno por sala
     *
     * @param maxMaligno
     * @return
     */
    public MoriaBuilder conMaxPoderMaligoEnSala(int maxMaligno) {
        this.maxMaligno = maxMaligno;
        return this;
    }

    /**
     * Establece la cantidad maxima de flechas po sala
     *
     * @param maxFlechas
     * @return
     */
    public MoriaBuilder conMaxFlechasEnSala(int maxFlechas) {
        this.maxFlechas = maxFlechas;
        return this;
    }

    /**
     * Establece el número máximo de enemigos por sala
     *
     * @param maxEnemigos
     * @return
     */
    public MoriaBuilder conMaxEnemigosEnSala(int maxEnemigos) {
        this.maxEnemigos = maxEnemigos;
        return this;
    }

    /**
     * Método Build
     *
     * @return Instancia de Moria Parametrizada
     */
    @Override
    public Moria build() {
        // Seguimos manteniendo nuestro singleton aquí, encapsulado por este Builder
        // esto lo hago porque simplemente lo veáis, y aprendáis los dos patrones y como se pueden combinar
        Moria moria = Moria.getInstance();
        moria.setTotalSalas(this.numSalas);
        moria.setEnergiaInicialVara(this.energiaVara);
        moria.setFlechasInicialCarcaj(this.flechasCarcaj);
        moria.setPoderMaligoSala(this.maxMaligno);
        moria.setFlechasSala(this.maxFlechas);
        moria.setEnemigosSala(this.maxEnemigos);
        return moria;
    }
}
