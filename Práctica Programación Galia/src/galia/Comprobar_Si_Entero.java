package galia;

import java.io.*;

/**
 * @author GALIA
 * @version 2.0
 */
public class Comprobar_Si_Entero {

	private int numero_a_comprobar;

	public Comprobar_Si_Entero(int numero) {
		setNumero_a_comprobar(0);
	}

	public static int pedir_entero(String mensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(
				System.in));
		int entero = 0;
		boolean correcto = true;
		do {
			System.out.println("Elija opcion");
			try {
				/*
				 * Se lee del teclado una cadena y se intenta convertirla en
				 * entero
				 */
				entero = Integer.parseInt(teclado.readLine());
				correcto = true;
			} catch (IOException ioE) {
				System.out.println("Error E/S");
				System.out.println("Error " + ioE.toString());
				correcto = false;
				/*
				 * Si se genera una excepción con el numero, se vuelve a
				 * solicitar
				 */
			} catch (NumberFormatException nfE) {
				System.out.println("Introduzca un número entero");
				System.out.println("Error " + nfE.toString());
				correcto = false;
			}
		} while (!correcto);
		return entero;
	}

	public int getNumero_a_comprobar() {
		return numero_a_comprobar;
	}

	public void setNumero_a_comprobar(int numero_a_comprobar) {
		this.numero_a_comprobar = numero_a_comprobar;
	}
}
