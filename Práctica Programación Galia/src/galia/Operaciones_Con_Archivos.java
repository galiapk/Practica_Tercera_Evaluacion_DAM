package galia;

import java.io.*;
import java.util.*;

/**
 * @author GALIA
 * @version 2.7
 */
public class Operaciones_Con_Archivos {

	private static Scanner sc;

	public static String crear_archivo() throws IOException {

		System.out.println("Nombre del cliente (el archivo se llama igual) : ");
		setSc(new Scanner(System.in));
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		String fichero_a_crear;

		fichero_a_crear = buffer.readLine();
		File fichero = new File(fichero_a_crear);

		if (fichero.exists()) {
			System.out.println("El fichero " + fichero + " existe");
			System.out.println("La ruta del fichero es: "
					+ fichero.getAbsolutePath());
		} else {
			File fichero_nuevo = new File(fichero_a_crear);
			if (fichero_nuevo.getAbsolutePath().endsWith(".dat")) {
				fichero_nuevo = new File(fichero_a_crear);
			} else {
				fichero_nuevo = new File(fichero + ".txt");
			}
			if (fichero_nuevo.createNewFile()) {
				System.out.println("El fichero se ha creado correctamente");
				System.out.println("La ruta del fichero es: "
						+ fichero_nuevo.getAbsolutePath());

			} else
				System.out.println("No ha podido ser creado el fichero");

		}
		buffer.close();
		return fichero_a_crear;

	}

	/*
	 * public void writeToFile() throws IOException { String file =
	 * crear_archivo(); FileWriter writer = new FileWriter(file, true);
	 * writer.close(); }
	 */
	public static Scanner getSc() {
		return sc;
	}

	public static void setSc(Scanner sc) {
		Operaciones_Con_Archivos.sc = sc;
	}
}
