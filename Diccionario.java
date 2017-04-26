package terceraPr�ctica;

public class Diccionario {
	private int talla = 0;
	private Nodo primero;

	public static class Nodo {
		private String cadena;
		private int cantidad;
		private Nodo siguiente;

		public Nodo(String dato, int cantidad, Nodo siguiente) {
			this.cadena = dato;
			this.cantidad = cantidad;
			this.siguiente = siguiente;
		}

		public Nodo(String dato, int cantidad) {
			this.cadena = dato;
			this.cantidad = cantidad;
			this.siguiente = null;
		}

		public Nodo(String dato) {
			this.cadena = dato;
			this.cantidad = 1;
			this.siguiente = null;
		}
	}

	public void a�adir(String unaCadena, int unaCantidad) {
		Nodo a�adir = new Nodo(unaCadena, unaCantidad);
		Nodo anterior = null;
		Nodo actual = primero;

		while (actual != null && actual.cadena.compareTo(unaCadena) < 0) {
			anterior = actual;
			actual = actual.siguiente;
		}

		if (anterior == null) {
			if (actual != null) {
				if (actual.cadena.equals(unaCadena))
					primero.cantidad += unaCantidad;
				else {
					a�adir.siguiente = primero;
					primero = a�adir;
				}
			} else {
				primero = a�adir;
			}
		} else {
			if (actual != null) {
				if (actual.cadena.equals(unaCadena)) {
					actual.cantidad += unaCantidad;
				} else {
					a�adir.siguiente = actual;
					anterior.siguiente = a�adir;
				}
			} else {
				a�adir.siguiente = actual;
				anterior.siguiente = a�adir;
			}
		}

	}

	public String cadenaConMayorCantidad() {
		Nodo actual = primero;
		int cantidad = -1;
		String cadenaM�sVeces = null;

		while (actual != null) {
			if (actual.cantidad > cantidad) {
				cadenaM�sVeces = actual.cadena;
				cantidad = actual.cantidad;
			}

			actual = actual.siguiente;
		}

		return cadenaM�sVeces;

	}

	public int cantidad(String unaCadena) {
		Nodo actual = primero;
		int cantidad = 0;

		while (actual != null) {
			if (actual.cadena.equals(unaCadena))
				cantidad = actual.cantidad;

			actual = actual.siguiente;
		}

		return cantidad;
	}

	public String toString() {
		Nodo actual = primero;
		String cadena = "{";

		while (actual != null) {
			cadena += actual.cadena + "-->" + actual.cantidad;
			if (actual.siguiente != null)
				cadena += ", ";
			actual = actual.siguiente;
		}

		cadena += "}";

		return cadena;

	}

}
