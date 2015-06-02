package galia;
/*
import java.util.*;*/
public class Pedir_Datos_Clientes {

/*	private static Scanner sc;
*/
	public static void operar() {
	/*	
		Operaciones_Clientes operaciones = new Operaciones_Clientes();
		Implementar_Operaciones.rellenar(operaciones);*/
		
		/*System.out.println("1. Añadir Cliente\n");
		int opcion = 0;
		boolean resultado = true;
		System.out.println("Introduzca CIF (Ejemplo A58818501):");
		sc = new Scanner(System.in);
		String cif = sc.nextLine();
		new Comprobar_Si_Entero();

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		do {
			System.out.println(".................\n" + "  1 Añadir cliente\n"
					+ "  2 Salir\n" + ".................");
			sc = new Scanner(System.in);
			opcion = sc.nextInt();
		} while ( opcion < 1 || opcion > 2);
		do {
			System.out.println("Introduzca el CIF: 	");
			sc = new Scanner(System.in);
			String cadena = sc.nextLine();
			CIF cif1 = new CIF(cadena);
			resultado = cif1.validar();
		} while (resultado != true );

		System.out.println("Introduzca Nombre de la Empresa: ");
		sc = new Scanner(System.in);
		String nombre_empresa = sc.nextLine();

		System.out.println("Introduzca Responsable de la Empresa: ");
		sc = new Scanner(System.in);
		String responsable = sc.nextLine();

		System.out.println("Introduzca número COITT de la Empresa: ");
		sc = new Scanner(System.in);
		int numero_COITT = sc.nextInt();
		 numero_COITT = Comprobar_Si_Entero.pedir_entero("Elija opcion"); 

		System.out.println("Introduzca Dirección de la Empresa: ");
		sc = new Scanner(System.in);
		String direccion = sc.nextLine();

		System.out.println("Introduzca Cuenta Corriente de la Empresa: ");
		sc = new Scanner(System.in);
		String cuenta_corriente = sc.nextLine();

		System.out.println("Introduzca Tipo de la Empresa: P/N");
		sc = new Scanner(System.in);
		String tipo = sc.nextLine();

		if (tipo.equalsIgnoreCase("P")) {
			Cliente.setTipo(TipoDeCliente.PREFERENTE);
			Cliente.tipo = TipoDeCliente.PREFERENTE;
		} else {
			Cliente.setTipo(TipoDeCliente.NORMAL);
			Cliente.tipo = TipoDeCliente.NORMAL;
		}

		Cliente cliente = new Cliente(cif, nombre_empresa, responsable,
				numero_COITT, direccion, cuenta_corriente, Cliente.tipo);
		System.out.println(cliente.toString());
		System.out.println(clientes.toString());*/
	}
}