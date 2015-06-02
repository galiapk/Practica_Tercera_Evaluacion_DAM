package galia;

import java.util.*;

/**
 * @author GALIA
 * @version 1.0
 *
 */
public class Operaciones_Clientes extends ArrayList<Object> implements
		Interfaz_Operaciones {

	private static final long serialVersionUID = 1L;

	public Operaciones_Clientes() {
	}

	@Override
	public boolean vacia() {
		return isEmpty();
	}

	@Override
	public Object primerObjeto() {
		return get(0);
	}

	@Override
	public Object extraerObjeto(Object o) {
		return remove(0);
	}

	@Override
	public Object addObjeto(Object o) {
		add(o);
		return true;
	}

	@Override
	public Object borrarObjeto(Object o) {
		remove(o);
		return true;
	}
}
