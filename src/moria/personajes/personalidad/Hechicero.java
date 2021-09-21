package moria.personajes.personalidad;

/**
 * Interfaz de Personalidad de Mago
 */
public interface Hechicero {
    /**
     * Acción de recargar la vara con energía
     *
     * @param energia energía de la vara
     */
    void recargarVara(int energia);

    /**
     * obtiene el poder de la vara
     *
     * @return devuleve el poder de la vara
     */
    int poderVara();
}
