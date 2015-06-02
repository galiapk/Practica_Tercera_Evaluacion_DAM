package galia;

import java.util.*;

/**
 * @author GALIA
 * @version 2.0
 */
public class Menu_Facturas {

	private static Scanner sc;
     static boolean correcto;
static boolean es_numero;
	public static void mostrar() {

		int opcion;
String opcion_como_cadena;
		System.out.println("Actualizando factura...\n");
		do {
			do {
				correcto = true;
				System.out.println("1 Añadir cantidad\n" + "2 Salir\n");
				sc = new Scanner(System.in);
				opcion = sc.nextInt();
				
				correcto = isEntero(opcion);
				opcion_como_cadena = (Integer.toString(opcion));
				
				es_numero = Añadir_Clientes.isNumeric(opcion_como_cadena);
				
				if (correcto == false ||  es_numero == false) {
					System.out.println();
				} 
			} while (false || opcion != 2 );

			
			
			switch (opcion) {
			case 1:
				System.out.println("GO\n");
				Operaciones_Facturas operaciones_Facturas = new Operaciones_Facturas();
				operaciones_Facturas.facturar();
				break;
			case 2:
				System.out.println(" Adios\n");
				break;
			default:
				System.out.println("Datos incorrectos\n");
			}
		/*} while (false || opcion != 2 );*/
		} while (opcion < 1 || opcion != 2);
	}

	public static boolean isEntero(int opcion) {
		try {
			if (opcion % 2 != 0)
				return true;
		} catch (NumberFormatException nfe) {

		}
		return false;
	}
}
