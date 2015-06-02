package galia;

import java.io.*;
import java.util.*;

/**
 * @author GALIA
 * @version 7.0
 */
public class Menu {

	static Mapa_Valores_Hash menu = new Mapa_Valores_Hash();
	static Scanner sc;

	/**
	 * Sobrescribe ejecutar() de la interfaz Opción
	 * 
	 * @throws IOException
	 */
	public static void go() throws IOException {
		menu.addCaseOpcion(1, new Opcion() {
			@Override
			public void ejecutar() throws IOException {
				Añadir_Clientes.mostrar_opciones();
				new Clientes();
			}
		});
		menu.addCaseOpcion(2, new Opcion() {
			@Override
			public void ejecutar() {
				System.out.println("2. Añadir Cantidad Facturada\n");
				Menu_Facturas.mostrar();
			}
		});
		menu.addCaseOpcion(3, new Opcion() {
			@Override
			public void ejecutar() throws IOException {
				System.out.println("3. Generar informe: ");
			}
		});
		menu.addCaseOpcion(4, new Opcion() {
			@Override
			public void ejecutar() throws IOException {
				System.out.println("4. Grabar fichero: ");
				Operaciones_Con_Archivos.crear_archivo();
			}
		});
		menu.addCaseOpcion(5, new Opcion() {
			@Override
			public void ejecutar() {
				System.out.println("5");
			}
		});
		menu.setOpcionDefecto(new Opcion() {
			@Override
			public void ejecutar() {
				System.out.println("6");
			}
		});

		for (int i = 1; i <= 6; i++) {
			menu.go(i);
		}
	}
}
