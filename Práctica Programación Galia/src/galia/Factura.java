package galia;

/**
 * @author GALIA
 * @version 2.0
 */
public interface Factura {

	int trabajo_fijo = 3000;
	float precio_hora = 27.72f;
	float descuento = 0.2f;

	void añadir_cantidad();

	void facturar();
}
