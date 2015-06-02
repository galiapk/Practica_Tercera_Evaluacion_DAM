package galia;

import java.util.*;

/**
 * @author GALIA
 * @version 1.0
 */
public class Operaciones_Facturas extends ArrayList<Object> implements Factura {

	private static final long serialVersionUID = 1L;
	private static Scanner sc;

	public Operaciones_Facturas() {
		/*
		 * llama al super automáticamente, en este caso el constructor de
		 * ArrayList
		 */
	}

	@Override
	public void añadir_cantidad() {

	}

	@Override
	public void facturar() {
		float cantidadACobrar = 0;
		float totalFacturado = 0;

		boolean correcto;
		int horas;
		String opcion;
		if (Cliente.tipo == TipoDeCliente.NORMAL && Cliente.tipo != null) {

			do {
				System.out.println(".................\n"
						+ "  1 Trabajo por horas\n" + "  2 Trabajo completo\n"
						+ "  3 Salir\n" + ".................");
				sc = new Scanner(System.in);
				opcion = sc.nextLine();
				correcto = Añadir_Clientes.isNumeric(opcion);
			} while (false);

			if (Integer.parseInt(opcion) == 1) {
				do {
					correcto = true;
					System.out.println("Itroduzca horas:");
					sc = new Scanner(System.in);
					horas = sc.nextInt();
					correcto = Menu_Facturas.isEntero(horas);
				} while (correcto == false);

				totalFacturado = precio_hora * horas;
				cantidadACobrar = totalFacturado;
				System.out.println("Total : " + cantidadACobrar);
			} else {
				cantidadACobrar = trabajo_fijo;
			}

			if (Integer.parseInt(opcion) == 2) {
				do {
					correcto = true;
					System.out.println("Itroduzca horas:");
					sc = new Scanner(System.in);
					horas = sc.nextInt();
					correcto = Menu_Facturas.isEntero(horas);
				} while (correcto == false);

				totalFacturado = precio_hora * horas;
				cantidadACobrar = (totalFacturado - (totalFacturado * descuento / 100));
				System.out.println("Total : " + cantidadACobrar);
			} else {
				cantidadACobrar = trabajo_fijo
						- (trabajo_fijo * descuento / 100);
				System.out.println("Total : " + cantidadACobrar);
			}
		}
	}

}