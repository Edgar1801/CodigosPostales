package mx.unison;

/* Contar cuantos códigos postales corresponden a asentamientos rurales
y cantos a asentamientos rurales
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String archivoCSV = "codigos_postales.csv";
        String linea;
        String separador = ",";

        int urbanos = 0;
        int rurales = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            // Leer la primera línea (cabecera)

            // Leer las siguientes líneas
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);

                // La columna del tipo de asentamiento está en la tercera posición (índice 2)
                String tipoAsentamiento = datos[2];

                if (tipoAsentamiento.equalsIgnoreCase("Urbano")) {
                    urbanos++;
                } else if (tipoAsentamiento.equalsIgnoreCase("Rural")) {
                    rurales++;
                }
            }

            System.out.println("Asentamientos urbanos: " + urbanos);
            System.out.println("Asentamientos rurales: " + rurales);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
