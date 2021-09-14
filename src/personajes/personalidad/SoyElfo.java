package personajes.personalidad;

/**
 * Interfaz de Personalidad de Elfo
 */
public interface SoyElfo {
    /**
     * Lanza una flecha
     */
    void lanzarFlecha();

    /**
     * Recarga el Carcaj con un valor
     * @param flechas número de flechas con la que recargo el carcaj
     */
    void recargarCarcaj(int flechas);
}
