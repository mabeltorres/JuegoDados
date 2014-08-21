package dominio;

public class JuegoDados {
	
	private Dado dado1;
	private Dado dado2;
	private int vc1;
	private int vc2;
	
	public JuegoDados(Dado d1, Dado d2) {
		dado1 = d1;
		dado2 = d2;
	}

	public void jugar() {
		dado1.lanzar();
		vc1 = dado1.obtenerValorCara();

		dado2.lanzar();
		vc2 = dado2.obtenerValorCara();
	}
	
	public int[] getResultados() {
		return new int[] {vc1, vc2};
	}
}