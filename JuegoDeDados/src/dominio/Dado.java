package dominio;
import java.util.Random;

public class Dado {
	
	private int valorCara;
	private Random generadorDeNumerosAleatorios = new Random();

	public int obtenerValorCara() {

		return valorCara;
	}
	
	public void lanzar() {
		valorCara = generarEnteroAlAzar();
	}
	
	private int generarEnteroAlAzar() {
		return generadorDeNumerosAleatorios.nextInt(6) + 1;
	}
}