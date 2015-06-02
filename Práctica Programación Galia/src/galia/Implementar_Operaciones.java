package galia;

import java.util.*;

/**
 * @author GALIA
 * @version 7.0
 */
public class Implementar_Operaciones {

	static ArrayList<Object> Lista_Clientes = new ArrayList<Object>();

	public static void rellenar(Interfaz_Operaciones interfaz) {

		for (Object o : Lista_Clientes) {
			interfaz.addObjeto(o);
			Lista_Clientes.add(o);
		}
	}

	public static boolean vacia(Interfaz_Operaciones interfaz) {
		boolean vacia = false;
		while (interfaz.vacia()) {
			System.out.println(Lista_Clientes.isEmpty());
			vacia = true;
		}
		return vacia;
	}

	public static Object primerObjeto(Interfaz_Operaciones interfaz) {
		return Lista_Clientes.get(0);
	}

	public static Object addObjeto(Interfaz_Operaciones interfaz) {
		Object o = new Object();
		interfaz.addObjeto(o);
		Lista_Clientes.add(10, o);
		return o.toString();
	}

	public static Object borrarObjeto(Interfaz_Operaciones interfaz) {
		int posicion = 0;
		interfaz.borrarObjeto(posicion);
		Lista_Clientes.remove(posicion);
		return Lista_Clientes.toString();
	}

	public static Object extraerObjeto(Interfaz_Operaciones interfaz) {
		int posicion = 0;
		Lista_Clientes.get(posicion);
		return Lista_Clientes.get(posicion).toString();
	}
}
