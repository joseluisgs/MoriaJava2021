package moria.tdas;

import java.util.Collection;

/**
 * Contrato que toda Cola debe cumplir
 */
public interface ICola<E> extends Collection<E> {
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
