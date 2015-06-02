package galia;

/**
 * @author GALIA
 * @version 3.0
 */
public class CIF extends Identificador {

	private static final long serialVersionUID = 6372032327748335325L;

	/* identificador del tipo de organismo */
	private static String letras_validas = "ABCDEFGHJPQRSUV";

	/* Caracteres de control */
	private static String caracteres_de_control = "JABCDEFGHI";

	/* tipos donde el car�cter de control tiene que ser una letra */
	private static String tipo_de_letra = "PQS";

	/* tipos donde el car�cter de control tiene que ser un nombre */
	private static String tipo_de_nombre = "ABEH";

	public CIF(String id) {
		super(id);
	}

	/*
	 * (sin Javadoc)
	 * 
	 * @see paquete_inicial.Identificador#validar()
	 */
	@Override
	public boolean validar() {
		return validar(this.getId());
	}

	/**
	 * Si CIF es de tipo "PQS" el car�cter de control ha de ser letra. Si CIF es
	 * de tipo "ABEH" el car�cter de control ha de ser nombre. Para el resto 1 -
	 * Sumar los d�gitos en posiciones paralelas. Esto nos da A 2 - Por cada
	 * una de les posiciones impares, multiplicarlas por 2 y sumar los dígitos
	 * de los resultados. Da B. 3 - Sumar C = A + B 4 - Se toma el �ltimo d�gito
	 * de C y se resta de 10. Esto nos da D. Si D es = a un d�gito de control,
	 * el CIF es correcto.
	 * 
	 * Ejemplo
	 *
	 * CIF A08123456 1) A = 8 + 2 + 4 = 14 2) B = (0*2=0 + 1*2=2 + 3*2=6 +
	 * 5*2=10=1+0=1) = 0+2+6+1 = 8 3) C = 14 + 8 = 22 4) Si C = 22 el �ltimo
	 * d�gito es = 2. D es = restamos: 10 - 2 = 8 no es correcto Equivalencias
	 * entre DC con letra y DC con numero : J=0 - A=1 - B=2 - C=3 - D=4 - E=5 -
	 * F=6 - G=7 - H=8 - I=9
	 */
	public static boolean validar(String id) {
		boolean resultado = false;
		int digito_de_control;

		try {
			/* Un CIF tiene que tener nueve dígitos */
			if (id.length() == 9) {

				/* Toma la primera letra del CIF */
				char letra_CIF = id.charAt(0);

				/* Comprueba si la primera letra del CIF es válida */
				if (letras_validas.indexOf(letra_CIF) >= 0) {

					if (Character.isDigit(id.charAt(8))) {
						digito_de_control = Character.getNumericValue(id
								.charAt(8));
						if (tipo_de_letra.indexOf(letra_CIF) >= 0)
							digito_de_control = 100;
					} else {
						digito_de_control = caracteres_de_control.indexOf(id
								.charAt(8));
						if (tipo_de_nombre.indexOf(letra_CIF) >= 0)
							digito_de_control = 100;
					}

					int a = 0, b = 0, c = 0;
					byte[] impares = { 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 };

					/* Calcula A y B. */
					for (int t = 1; t <= 6; t = t + 2) {

						/* Suma los pares */
						a = a + Character.getNumericValue(id.charAt(t + 1));
						b = b
								+ impares[Character.getNumericValue(id
										.charAt(t))];
					}

					b = b + impares[Character.getNumericValue(id.charAt(7))];
					/* Calcula C */
					c = 10 - ((a + b) % 10);
					/* Compara C con los dígitos de control */
					resultado = (c == digito_de_control);
				}
			}
		} catch (Exception e) {
			resultado = false;
		}
		return resultado;
	}

	/**
	 * Funci�n que devuelve la descripci�n correspondiente al tipo de
	 * organismo del CIF de la instancia actual.Retorna String con la
	 * descripción correspondiente.
	 */
	public String tipo_organismo_CIF() {
		return tipo_organismo_CIF(this.getId());
	}

	/**
	 * Devuelve la descripci�n correspondiente al tipo de organismo de un CIF
	 * dado. A - Sociedad an�nima B - Sociedad de responsabilidad limitada C -
	 * Sociedad colectiva D - Sociedad comunitaria E - Comunidad de bienes F -
	 * Sociedad cooperativa G - Asociaci�n H - Comunidad de propietarios J -
	 * Sociedades civiles, con o sin personalidad jur�dica P - Corporaci�n Q
	 * -Organismo p�blico R - Congregaciones e instituciones religiosas S -
	 * �rgano de la Administraci�n del Estado y de las Comunidades Aut�nomas
	 * U - Uniones temporales de Empresas V - Otros tipos no definidos en el
	 * resto de claves
	 */
	public static String tipo_organismo_CIF(String id) {

		/* El resultado final */
		String resultado_final;

		/* Tipo de organismo */
		String tipo_Organismo[] = { "CIF tipo A", "CIF tipo B", "CIF tipo C",
				"CIF tipo D", "CIF tipo E", "CIF tipo F", "CIF tipo G",
				"CIF tipo H", "CIF_no_ definido", "CIF tipo J",
				"CIF_no_definido", "CIF_no_definido", "CIF_no_definido",
				"CIF_no_definido", "CIF_no_definido", "CIF tipo P",
				"CIF tipo Q", "CIF tipo R", "CIF tipo S", "CIF tipo U",
				"CIF tipo V", "CIF_no_definido", "CIF_no_definido",
				"CIF_no_definido", "CIF_no_definido" };

		if (validar(id) != true) {
			/* CIF no válido */
			resultado_final = "CIF no valido";
		} else {
			/* CIF valido */
			char letraCIF = id.charAt(0);
			/* Prueba la primera letra */
			if (letras_validas.indexOf(letraCIF) < 0) {

				/* La letra no se corresponde con ninguna en la lista */
				resultado_final = "CIF incorrecto";
			} else {
				/* Busca el CIF en el array de organismos públicos */
				resultado_final = tipo_Organismo[(byte) letraCIF - (byte) 'A'];
			}
		}
		return resultado_final;
	}

	/* Cambia el DC del CIF a letra */
	public void setDCLetra() {

		if (this.getId().length() == 9) {

			if (tipo_de_nombre.indexOf(this.getId().charAt(0)) < 0) {

				if (Character.isDigit(this.getId().charAt(8))) {

					int digito_de_control = Character.getNumericValue(this
							.getId().charAt(8));
					this.setId(this.getId().substring(0, 8)
							+ caracteres_de_control.charAt(digito_de_control));
				}
			}
		}
	}

	/* Cambia el DC del CIF a nombre. */

	public void setDCNombre() {
		if (this.getId().length() == 9) {
			if (tipo_de_letra.indexOf(this.getId().charAt(0)) < 0) {
				if (Character.isLetter(this.getId().charAt(8))) {
					int digito_de_control = this.getId().charAt(8);
					this.setId(this.getId().substring(0, 8)
							+ caracteres_de_control.indexOf(digito_de_control));
				}
			}
		}
	}

}