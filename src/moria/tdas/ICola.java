package moria.tdas;

/**
 * Contrato que toda Cola debe cumplir
 */
public interface ICola<E> {
    /**
     * Encola un item
     * @param item item a encolar
     */
    public void encolar(E item);

    /**
     * Desencola un Item
     * @return item
     */
    public E desencolar();
}
