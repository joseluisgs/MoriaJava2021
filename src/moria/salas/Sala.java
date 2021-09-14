package moria.salas;

import moria.peligros.Peligro;

/**
 * Clase sala. La definimos como un POJO para tener sus métodos típicos usando data
 * Las propiedades son finales, porque una vez creada la sala no cambia
 */
public final class Sala {
    private final int numero;
    private final Peligro peligro;

    public Sala(int numero, Peligro peligro) {
        this.numero = numero;
        this.peligro = peligro;
    }

    public int getNumero() {
        return numero;
    }

    public Peligro getPeligro() {
        return peligro;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "numero=" + numero +
                ", peligro=" + peligro +
                '}';
    }
}
