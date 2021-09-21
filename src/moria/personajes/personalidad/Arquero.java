package moria.personajes.personalidad;

/**
 * Interfaz de Personalidad de Arquero
 */
public interface Arquero {
    /**
     * Lanza una flecha
     */
    void lanzarFlecha();

    /**
     * Recarga el Carcaj con un valor
     *
     * @param flechas número de flechas con la que recargo el carcaj
     */
    void recargarCarcaj(int flechas);
}
