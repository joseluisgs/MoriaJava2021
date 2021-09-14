package peligros;

/**
 * Clase del tipo de Peligro
 */
public abstract class Peligro {
    private final String tipo;

    /**
     * Constructor
     * @param tipo Tipo de Peligro
     */
    public Peligro(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el tipo de Peligro
     * @return Tipo de Peligro
     */
    public String getTipo() {
        return this.tipo;
    }
}