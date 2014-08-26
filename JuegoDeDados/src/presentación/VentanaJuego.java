package presentación;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
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
	private JButton btnJugar;
	private List<JLabel> dados;
	private JuegoDados juego;
	private JPanel panelBotones;
	private JButton btnSalir;
	private JLabel lblDado1;
	private JLabel lblDado2;

	public void mostrar() {
		frame.setVisible(true);
	}

	private class EscuchadorBotónSalir implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	}

	private class EscuchadorBotónJugar implements ActionListener {
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
		return getIcono(nombreArchivo, 80);
	}

	private ImageIcon getIcono(String nombreArchivo, int tamaño) {
		ImageIcon imageIcon = new ImageIcon(VentanaJuego.class.getResource("/presentaci\u00F3n/iconos/" + nombreArchivo));
		Image image = imageIcon.getImage().getScaledInstance(tamaño, tamaño, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		return imageIcon;
	}

	public VentanaJuego(JuegoDados juego) {
		this.juego = juego;
		this.dados = new ArrayList<>();

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
		frame.setBounds(100, 100, 250, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void inicializarBotones() {
		inicializarPanelBotones();
		inicializarBotónJugar();
		inicializarBotónSalir();
	}

	private void inicializarPanelBotones() {
		panelBotones = new JPanel();
		panelBotones.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.LIGHT_GRAY));
		frame.getContentPane().add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

	private void inicializarBotónJugar() {
		btnJugar = new JButton("Jugar");
		btnJugar.setIcon(getIconoBotón("dados.png"));
		btnJugar.addActionListener(new EscuchadorBotónJugar());
		
		panelBotones.add(btnJugar);
	}

	private void inicializarBotónSalir() {
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(getIconoBotón("salir.png"));
		btnSalir.addActionListener(new EscuchadorBotónSalir());
		panelBotones.add(btnSalir);
	}

	private ImageIcon getIconoBotón(String nombreArchivo) {
		return getIcono(nombreArchivo, 40);
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
		lblDado2 = new JLabel("");
		GridBagConstraints gbc_lblDado2 = new GridBagConstraints();
		gbc_lblDado2.insets = new Insets(0, 0, 5, 5);
		gbc_lblDado2.gridx = 3;
		gbc_lblDado2.gridy = 1;
		panel.add(lblDado2, gbc_lblDado2);
		dados.add(lblDado2);
	}

	private void inicializarDado1(JPanel panel) {
		lblDado1 = new JLabel("");
		GridBagConstraints gbc_lblDado1 = new GridBagConstraints();
		gbc_lblDado1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDado1.gridx = 1;
		gbc_lblDado1.gridy = 1;
		panel.add(lblDado1, gbc_lblDado1);
		dados.add(lblDado1);
	}
}