package galia;

public abstract class Identificador implements Cloneable,
		Comparable<Identificador>, java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/*Identificador general */
	private static String id;
	private Identificador identificador_comparando;

	public Identificador(String id) {
		Identificador.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		Identificador.id = id;
	}

	/* Obliga a implementar un método de validación */
	public boolean validar() {
		
		return false;
	}

	public String toString() {
		return id;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Identificador))
			return false;
		setIdentificador_comparando((Identificador) obj);
		if (id == null) {
			if (Identificador.id != null)
				return false;
		} else if (!id.equals(Identificador.id))
			return false;
		return true;
	}

	public int compareTo(Identificador obj) throws ClassCastException {
		return this.getId().compareTo(obj.getId());
	}

	public Identificador getIdentificador_comparando() {
		return identificador_comparando;
	}

	public void setIdentificador_comparando(Identificador identificador_comparando) {
		this.identificador_comparando = identificador_comparando;
	}
}
