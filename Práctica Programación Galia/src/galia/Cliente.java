package galia;

/**
 * @author GALIA
 * @version 2.0
 */
public class Cliente {

	private String CIF;
	private String nombre_empresa;
	private String responsable;
	private String numero_COITT;
	private String direccion;
	private String cuenta_corriente;
	static TipoDeCliente tipo;

	public Cliente(String CIF, String nombre_empresa, String responsable,
			String numero_COITT, String direccion, String cuenta_corriente,
			TipoDeCliente tipo) {
		super();
		this.CIF = CIF;
		this.nombre_empresa = nombre_empresa;
		this.responsable = responsable;
		this.numero_COITT = numero_COITT;
		this.direccion = direccion;
		this.cuenta_corriente = cuenta_corriente;
		Cliente.tipo = tipo;
	}

	public Cliente() {
		// TODO Apéndice de constructor generado automáticamente
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String CIF) {
		this.CIF = CIF;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getNumero_COITT() {
		return numero_COITT;
	}

	public void setNumero_COITT(String numero_COITT) {
		this.numero_COITT = numero_COITT;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCuenta_corriente() {
		return cuenta_corriente;
	}

	public void setCuenta_corriente(String cuenta_corriente) {
		this.cuenta_corriente = cuenta_corriente;
	}

	public TipoDeCliente getTipo() {
		return tipo;
	}

	public static TipoDeCliente setTipo(TipoDeCliente tipo) {
		return Cliente.tipo = tipo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [CIF=");
		builder.append(CIF);
		builder.append("\n\tnombre_empresa=");
		builder.append(nombre_empresa);
		builder.append("\n\tresponsable=");
		builder.append(responsable);
		builder.append("\n\tnumero_COITT=");
		builder.append(numero_COITT);
		builder.append("\n\tdireccion=");
		builder.append(direccion);
		builder.append("\n\tcuenta_corriente=");
		builder.append(cuenta_corriente);
		builder.append("\n\ttipo=");
		builder.append(tipo);
		builder.append("]\n");
		return builder.toString();
	}
}
