package galia;

import java.io.*;
import java.util.*;

/**
 * @author GALIA
 * @version 7.0
 */
public class Añadir_Clientes extends ArrayList<Object> {

	public Añadir_Clientes() {
		super();
	}

	private static final long serialVersionUID = 1L;
	private static Scanner sc;
	static Cliente cliente;
	static ArrayList<Cliente> lista_Clientes;

	/**
	 * Void. Tiene dos switch-case. El externo muestra el menu principal y el
	 * interno controla si se desea introducir otro cliente y después regresar
	 * al menu principal. O al menos es lo que estoy intentando hacer.
	 * 
	 * @throws IOException
	 */
	public static void mostrar_opciones() throws IOException {

		int opcion_switch_externo = switch_externo();

		switch_externo(opcion_switch_externo);
		while (opcion_switch_externo < 1 || opcion_switch_externo > 2)
			;
	}

	/**
	 * @param opcion_switch_externo
	 */
	private static void switch_externo(int opcion_switch_externo) {
		int opcion_switch_interno = 0;
		switch (opcion_switch_externo) {// switch externo
		case 1:
			System.out.println("Clientes de [ GKSoftDesign ]\n");
			do {
				System.out.println("1 Nuevo\n" + "2 Salir\n");
				sc = new Scanner(System.in);
				opcion_switch_interno = sc.nextInt();
				switch (opcion_switch_interno) {// switch interno
				case 1:
					System.out.println("GO\n");
					introducir_datos_clientes();
					System.out.println("\nEl cliente ha sido creado");
					break;
				case 2:
					System.out.println("Adios\n");
					break;
				default:
					System.out.println("Datos incorrectos\n");
				}// switch interno
			} while (opcion_switch_interno < 1 || opcion_switch_interno != 2);
		default:
			System.out.println("Seguimos\n");
		}
	}

	private static int switch_externo() {
		sc = new Scanner(System.in);
		int opcion_switch_externo = 0;

		do {
			System.out.println(".................\n" + "  1 Añadir cliente\n"
					+ "  2 Añadir cantidad\n" + "  3 Generar informe \n"
					+ "  4 Grabar fichero\n" + "  5 Recuperar fichero\n"
					+ "  6 Salir\n" + ".................");
			/* llamo al método de la clase indicada */
			opcion_switch_externo = Comprobar_Si_Entero
					.pedir_entero("Elija una opción: ");
			/* para salir, solo con 6 */
		} while (opcion_switch_externo < 1 || opcion_switch_externo > 6);
		return opcion_switch_externo;
	}

	/**
	 * Void.El usuario inserta datos del cliente por teclado
	 */
	public static String introducir_datos_clientes() {

		Operaciones_Clientes operaciones_clientes = new Operaciones_Clientes();
		Cliente cliente = new Cliente();
		lista_Clientes = new ArrayList<Cliente>();


		/* almacenará el valor de CIF para validarlo */
		String cadena;
		cadena = comprobar_CIF();
		/* si resultado true, le asignamos el CIF al cliente */
		cliente.setCIF(cadena);

		/* Lo mismo, pero sin validaciones */
		System.out.println("Nombre de la empresa ");
		sc = new Scanner(System.in);
		String nombre_empresa = sc.nextLine();
		cliente.setNombre_empresa(nombre_empresa);

		System.out.println("Responsable de la empresa ");
		sc = new Scanner(System.in);
		String responsable = sc.nextLine();
		cliente.setResponsable(responsable);

		String numero_COITT = comprobar_COITT();

		/* si resultado true, le asignamos el numero_COITT al cliente */
		cliente.setNumero_COITT(numero_COITT);

		/* Lo mismo, pero sin validaciones */
		System.out.println("Direccion de la empresa ");
		sc = new Scanner(System.in);
		String direccion = sc.nextLine();
		cliente.setDireccion(direccion);

		System.out.println("Introduzca Cuenta Corriente de la Empresa: ");
		sc = new Scanner(System.in);
		String cuenta_corriente = sc.nextLine();
		cliente.setCuenta_corriente(cuenta_corriente);

		comprobar_tipo_cliente();
		/*
		 * Instanciamos la clase Operaciones_Clientes que implementa la interfaz
		 * Interfaz_Operaciones
		 */

		for (Cliente c : lista_Clientes) {
			operaciones_clientes.addObjeto(c);
		}
		System.out.println(operaciones_clientes.toString());
		operaciones_clientes.addObjeto(cliente);
		lista_Clientes.add(cliente);

		System.out.println(operaciones_clientes.toString());
		return operaciones_clientes.toString();
	}

	private static void comprobar_tipo_cliente() {
		System.out.println("Introduzca Tipo de la Empresa: P/N");
		sc = new Scanner(System.in);
		String tipo = sc.nextLine();

		/*
		 * Se pide una letra, en caso de P al cliente se le asigna tipo
		 * PREFERENTE, en caso de N - NORMAL
		 */
		/* Minúsculas o mayusculas */
		if (tipo.equalsIgnoreCase("P")) {
			Cliente.setTipo(TipoDeCliente.PREFERENTE);
			Cliente.tipo = TipoDeCliente.PREFERENTE;
		} else {
			Cliente.setTipo(TipoDeCliente.NORMAL);
			Cliente.tipo = TipoDeCliente.NORMAL;
		}
	}

	private static String comprobar_COITT() {
		/* comprobaremos si numero_COITT es entero */
		String numero_COITT;

		/* el resultado de la comprobación */
		boolean correcto;
		do {
			System.out.println("Número COITT de la empresa ");
			sc = new Scanner(System.in);
			numero_COITT = sc.nextLine();

			/* llamamos al void para obtener true o false */
			correcto = isNumeric(numero_COITT);

			/* no sales del do si el resultado es false */
		} while (correcto == false);
		return numero_COITT;
	}

	private static String comprobar_CIF() {
		String cadena;
		/* el resultado de la comprobación */
		boolean resultado = true;

		/* no sales si no introduces un CIF válido */
		do {
			System.out
					.println("Introduzca el CIF :[ ejemplo A28599033, que es el de Indra ]");
			sc = new Scanner(System.in);
			cadena = sc.nextLine();
			CIF cif = new CIF(cadena);
			resultado = cif.validar();

		} while (resultado != true);
		return cadena;
	}

	/**
	 * Boolean.
	 * 
	 * @param numero_COITT
	 * @return el resultado de la comprobación.
	 */
	public static boolean isNumeric(String numero_COITT) {
		try {
			Integer.parseInt(numero_COITT);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Datos_Clientes [toArray()=");
		builder.append(Arrays.toString(toArray()));
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]\n");
		return builder.toString();
	}

}