package terceraPráctica;

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

	public void añadir(String unaCadena, int unaCantidad) {
		Nodo añadir = new Nodo(unaCadena, unaCantidad);
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
					añadir.siguiente = primero;
					primero = añadir;
				}
			} else {
				primero = añadir;
			}
		} else {
			if (actual != null) {
				if (actual.cadena.equals(unaCadena)) {
					actual.cantidad += unaCantidad;
				} else {
					añadir.siguiente = actual;
					anterior.siguiente = añadir;
				}
			} else {
				añadir.siguiente = actual;
				anterior.siguiente = añadir;
			}
		}

	}

	public String cadenaConMayorCantidad() {
		Nodo actual = primero;
		int cantidad = -1;
		String cadenaMásVeces = null;

		while (actual != null) {
			if (actual.cantidad > cantidad) {
				cadenaMásVeces = actual.cadena;
				cantidad = actual.cantidad;
			}

			actual = actual.siguiente;
		}

		return cadenaMásVeces;

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
