package main;
import dominio.JuegoDados;
import presentacion.VentanaJuego;

public class Main {

	public static void main(String[] args) {
		JuegoDados juego = new JuegoDados();
		
		VentanaJuego ventanaJuego = new VentanaJuego(juego);
		ventanaJuego.mostrar();
	}
}