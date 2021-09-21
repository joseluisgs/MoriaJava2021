package moria.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    /**
     * Escribe informe en el fichero. Como bien dice el enunciado se va añadiendo
     * Usamos la clase Files de la nueva NIO2 de Java
     * https://www.arold.es/java-nio2-ejemplos/
     * https://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html
     *
     * @param nombreFichero
     * @param texto
     */
    public static void escribirFichero(String nombreFichero, String texto) {
        try {
            // Escribimos el informe añadiendo...pero antes lo creamos por si acaso
            Files.write(Paths.get(nombreFichero), texto.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error al escribir fichero: " + e.getMessage());
        }
    }

    public static String getMomentoActual() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(DateTimeFormatter.ofPattern("dd/M/y H:m:ss"));
    }

}
