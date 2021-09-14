package moria.utils;

import java.util.Random;

/**
 * Funciones de utilidad. Son métodos de clase (estáticos) por eso se usa companion para definirlos dentro.
 * Otra cosa es usar object y que sea un singleton
 */
public class Utils {
    /**
     * Obtiene verdadero o falso si el valor si se cumple la probabilidad
     *
     * @param limite limite de la probabilidad
     * @param max    máximo permitido
     * @return true/false si se cumple que el valor está dentro del límite
     */
    public static boolean probabilidad(int limite, int max) {
        int sorteo = new Random().nextInt(max);
        return sorteo <= limite;
    }
}
