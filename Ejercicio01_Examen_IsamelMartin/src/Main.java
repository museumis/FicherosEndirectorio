import java.io.File;
import java.util.Scanner;

/**
 * @author Ismael Martin. Ejercicio 01 Examen del Tema01. Programa que lee los ficheros
 *         de un directorio de forma recursiva -Fichero con extension
 *         especificada -Ficheros mayores de 200KB
 *
 */
public class Main {
	//Variable statica de la clase
	public static int TAMANIO_MAXIMO_FICHERO = 204800;
	/**
	 * Método que devuelve una cadena de texto	 * 
	 * @param pregunta
	 * @return respuesta
	 */
	public static String pedirTexto(String pregunta) {
		String respuesta = "";
		Scanner entrada = new Scanner(System.in);
		System.out.print(pregunta);
		try {
			respuesta = entrada.nextLine();
		} catch (Exception e) {
			System.out.println("Error.");
			pedirTexto(pregunta);
		}
		return respuesta;
	}//Fin de pedirTexto

	/**
	 * Metodo que muestra los ficheros de un directorio
	 * @param url
	 * @param extension
	 */
	public static void leerDirectorio(String url, String extension) {

		File directorio = new File(url);

		// Si el directorio existe
		if (directorio.exists()) {
			// Creamos un array con los ficheros que contiene
			File ficheros[] = directorio.listFiles();

			for (int i = 0; i < ficheros.length; i++) {
				// Si la posicion del array es un directorio
				if (ficheros[i].isDirectory()) {
					// Es enviado al mismo metodo para ser leido
					leerDirectorio(ficheros[i].getAbsolutePath(), extension);
				} else {
					// Si la posicion del array es un fichero
					// Si pesa mas de 200KB
					// Si tiene la extension especificada
					// Se muetra.
					if ((ficheros[i].length() > TAMANIO_MAXIMO_FICHERO)&&(ficheros[i].getName().endsWith(extension))) {
						System.out.println(ficheros[i]);
					}
				}
			}
		} else {
			System.out.println("El directorio no existe.");
		}
	}//Fin de leerDirectorio

	/**
	 * que inicia el programa
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("- Lectura de Directorios -");
		leerDirectorio(pedirTexto("Ruta del directorio: "), pedirTexto("Extensión que desea ver: "));
	}//Fin del main

}//Fin de la clase
