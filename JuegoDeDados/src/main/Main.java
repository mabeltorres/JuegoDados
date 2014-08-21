package main;
import dominio.Dado;
import dominio.JuegoDados;
import presentación.VentanaJuego;

public class Main {

	public static void main(String[] args) {
		Dado d1 = new Dado();
		Dado d2 = new Dado();
		
		JuegoDados juego = new JuegoDados(d1, d2);
		
		VentanaJuego ventanaJuego = new VentanaJuego(juego);
		ventanaJuego.mostrar();
	}
}