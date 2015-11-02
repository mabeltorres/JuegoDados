package presentaci�n;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import dominio.JuegoDados;

public class VentanaJuego {

	private JFrame frame;
	private List<JLabel> dados;
	private JuegoDados juego;
	private JPanel panelBotones;
	private JButton btnSalir;
	private RepositorioIconos iconos;

	public void mostrar() {
		frame.setVisible(true);
	}

	private class EscuchadorBot�nSalir implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	}

	private class EscuchadorBot�nJugar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			juego.jugar();

			mostrarResultados();
		}
	}
	
	private void mostrarResultados() {
		int[] resultados = juego.getResultados();
		for (int i = 0; i < 2; i++) {
			setValorDado(i, resultados[i]);
		}
	}
	
	private void setValorDado(int dado, int valor) {
		JLabel labelDado = dados.get(dado);
		labelDado.setIcon(getIconoDado(valor + ".png"));
	}

	private ImageIcon getIconoDado(String nombreArchivo) {
		return iconos.getIcono(nombreArchivo, 80);
	}


	public VentanaJuego(JuegoDados juego) {
		this.juego = juego;
		this.dados = new ArrayList<>();
		this.iconos = new RepositorioIconos();

		inicializar();
	}

	// -----------------------------------------------------------

	private void inicializar() {
		inicializarVentana();
		inicializarBotones();
		inicializarDados();
	}

	private void inicializarVentana() {
		frame = new JFrame();
		frame.setTitle("Juego de Dados");
		frame.setBounds(100, 100, 250, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void inicializarBotones() {
		inicializarPanelBotones();
		inicializarBot�nJugar();
		inicializarBot�nSalir();
	}

	private void inicializarPanelBotones() {
		panelBotones = new JPanel();
		panelBotones.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.LIGHT_GRAY));
		frame.getContentPane().add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

	private void inicializarBot�nJugar() {
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setIcon(getIconoBot�n("dados.png"));
		btnJugar.addActionListener(new EscuchadorBot�nJugar());
		
		panelBotones.add(btnJugar);
	}

	private void inicializarBot�nSalir() {
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(getIconoBot�n("salir.png"));
		btnSalir.addActionListener(new EscuchadorBot�nSalir());
		panelBotones.add(btnSalir);
	}

	private ImageIcon getIconoBot�n(String nombreArchivo) {
		return iconos.getIcono(nombreArchivo, 40);
	}

	private void inicializarDados() {
		JPanel panelDados = inicializarPanelDados();

		inicializarDado1(panelDados);
		inicializarDado2(panelDados);
	}

	private JPanel inicializarPanelDados() {
		JPanel panelDados = new JPanel();
		frame.getContentPane().add(panelDados, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelDados.setLayout(gbl_panel);
		return panelDados;
	}

	private void inicializarDado2(JPanel panel) {
		JLabel lblDado2 = new JLabel("");
		GridBagConstraints gbc_lblDado2 = new GridBagConstraints();
		gbc_lblDado2.insets = new Insets(0, 0, 5, 5);
		gbc_lblDado2.gridx = 3;
		gbc_lblDado2.gridy = 1;
		panel.add(lblDado2, gbc_lblDado2);
		dados.add(lblDado2);
	}

	private void inicializarDado1(JPanel panel) {
		JLabel lblDado1 = new JLabel("");
		GridBagConstraints gbc_lblDado1 = new GridBagConstraints();
		gbc_lblDado1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDado1.gridx = 1;
		gbc_lblDado1.gridy = 1;
		panel.add(lblDado1, gbc_lblDado1);
		dados.add(lblDado1);
	}
}