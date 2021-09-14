package moria.tdas;

import java.util.ArrayDeque;

/**
 * TDA Cola genérica.
 * Esta clase no es necesaria pues podríamos usar los métodos por defecto de esta clase
 * posiblemente desaparezca en refactorización.
 *
 * @param <E> elemento de cola genérica
 */
public class Cola<E> extends ArrayDeque<E> {

    /**
     * Encola un elemento al final
     *
     * @param item elemento a encolar
     */
    public void encolar(E item) {
        this.add(item);
    }

    /**
     * Elimina el elemento al comienzo
     *
     * @return comienzo
     */
    public E desencolar() {
        return this.removeFirst();
    }
}
