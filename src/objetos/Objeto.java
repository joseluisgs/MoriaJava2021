package objetos;

/**
 * Clase abstracta para los tipos de objetos
 */
public abstract class Objeto {
    private final String tipo;

    /**
     * Constructor de Objeto
     * @param tipo Tipo de Objeto
     */
    public Objeto(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuleve el tipo del objeto
     * @return tipo
     */
    public final String getTipo() {
        return this.tipo;
    }
}
