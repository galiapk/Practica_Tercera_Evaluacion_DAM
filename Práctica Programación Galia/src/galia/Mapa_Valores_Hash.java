package galia;

import java.io.IOException;
import java.util.*;

/**
 * @author GALIA
 * @version 2.0
 */
public class Mapa_Valores_Hash {

	/*
	 * Esto lo vi en Internet, te pongo el enlace.La Interface Map (java.io.Map)
	 * en Java, nos permite representar una estructura de datos para almacenar
	 * pares "clave/valor" de tal manera que para una clave solamente tenemos un
	 * valor. El tema del hashing no lo sé explicar muy bien , pero que saca un
	 * valor a través de un algoritmo de hash que bien puede ser multiplicar por
	 * un número primo, etc http://jarroba.com/map-en-java-con-ejemplos/
	 */

	private Map<Integer, Opcion> case_Opciones;
	/* llamamos a la interfaz Opción */
	private Opcion opcion_por_defecto;

	/* Constructor */
	public Mapa_Valores_Hash() {
		/*
		 * Nueva instancia de la interfaz Map. El tipo de clave es Integer y el
		 * valor se obtiene de la interfaz Opción
		 */
		case_Opciones = new HashMap<Integer, Opcion>();
		/*
		 * Salir_Del_Programa implementa la interfaz Opción. Sobrescribe el
		 * Método ejecutar saliendo del sistema
		 */
		setOpcionDefecto(new Salir_Del_Programa());
	}

	/**
	 * @param clave
	 * @param valor
	 *            Es la pareja de claves. Un Map asocia el el valor pasado como
	 *            argumento con la clave que existe(especificada en el Map). Si
	 *            el Map previamente contenía la pareja clave/valor, el valor es
	 *            reemplazado por el especificado.El Map devuelve la pareja de
	 *            claves solo si el resultado del método m.containsKey(clave)
	 *            devuelve true.
	 *            http://docs.oracle.com/javase/7/docs/api/java/util
	 *            /Map.html?is-external=true
	 */
	/* establecemos la pareja clave/valor */
	public void addCaseOpcion(Integer clave, Opcion valor) {
		case_Opciones.put(clave, valor);
	}

	/**
	 * Setter. Método de establecimiento
	 * 
	 * @param opcion_por_defecto
	 */
	public void setOpcionDefecto(Opcion opcion_por_defecto) {
		/* si distinta de null, por defecto salir */
		if (opcion_por_defecto != null) {
			this.opcion_por_defecto = opcion_por_defecto;
		}
	}

	/**
	 * @param clave
	 *            Ejecutaríamos la opción que vamos a obtener del Map
	 *            case_Opciones
	 * @throws IOException
	 */
	public void go(Integer clave) throws IOException {
		Opcion opcion = getCase_OpcionesClave(clave);
		/* Se sobrescribe el método ejecutar */
		opcion.ejecutar();
	}

	/* Eso es lo que te decía arriba, del método containsKey(clave) */
	private Opcion getCase_OpcionesClave(Integer clave) {
		/* si existe, la devuelve */
		if (case_Opciones.containsKey(clave)) {
			return case_Opciones.get(clave);
		} else {
			/* si no, salimos */
			return opcion_por_defecto;
		}
	}
}
