package dominio;
import java.util.Random;

public class Dado {
	
	private int valorCara;
	
	public int obtenerValorCara() {
		return valorCara;
	}
	
	public void lanzar() {
		valorCara = generarEnteroAlAzar();
	}
	
	private int generarEnteroAlAzar() {
		Random rnd = new Random();
		return rnd.nextInt(6) + 1;
	}
}