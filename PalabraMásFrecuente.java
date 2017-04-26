package terceraPráctica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static terceraPráctica.Diccionario.*;

public class PalabraMásFrecuente {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner escáner = new Scanner(new File("src//terceraPráctica//DonQuijote.txt"));

		Diccionario TotalPalabras = new Diccionario();
		String Palabra = escáner.next();

		while (escáner.hasNext()) {
			TotalPalabras.añadir(Palabra, 1);

			Palabra = escáner.next();
		}
		String PalabraAparición = TotalPalabras.cadenaConMayorCantidad();
		int Cantidad = TotalPalabras.cantidad(PalabraAparición);
		System.out.println();
		System.out.println("La palabra más frecuente en DonQuijote.txt es <<" + PalabraAparición + ">> con " + Cantidad + " apariciones.");;

	}
}
