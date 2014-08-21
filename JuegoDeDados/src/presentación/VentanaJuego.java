package presentación;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dominio.JuegoDados;

public class VentanaJuego {

	private JFrame frame;
	private JButton btnJugar;
	private JLabel lblValor1;
	private JLabel lblValor2;
	private JuegoDados juego;

	public VentanaJuego(JuegoDados juego) {
		this.juego = juego;

		inicializar();
	}

	public void mostrar() {
		frame.setVisible(true);
	}

	private final class EscuchadorBotón implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			juego.jugar();

			int[] resultados = juego.getResultados();
			lblValor1.setText(resultados[0] + "");
			lblValor2.setText(resultados[1] + "");
		}
	}


	// -----------------------------------------------------------

	private void inicializar() {
		inicializarVentana();
		inicializarBotón();
		inicializarEtiquetas();
	}

	private void inicializarEtiquetas() {
		JPanel panel = inicializarPanelCentral();
		inicializarLabelValor1(panel);
		inicializarValor1(panel);
		
		inicializarLabelValor2(panel);
		inicializarValor2(panel);
	}

	private void inicializarValor2(JPanel panel) {
		lblValor2 = new JLabel("-");
		GridBagConstraints gbc_lblValor2 = new GridBagConstraints();
		gbc_lblValor2.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor2.gridx = 2;
		gbc_lblValor2.gridy = 2;
		panel.add(lblValor2, gbc_lblValor2);
	}

	private void inicializarValor1(JPanel panel) {
		lblValor1 = new JLabel("-");
		GridBagConstraints gbc_lblValor1 = new GridBagConstraints();
		gbc_lblValor1.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor1.gridx = 2;
		gbc_lblValor1.gridy = 1;
		panel.add(lblValor1, gbc_lblValor1);
	}

	private void inicializarLabelValor2(JPanel panel) {
		JLabel lblValorDado_1 = new JLabel("Valor Dado 2:");
		GridBagConstraints gbc_lblValorDado_1 = new GridBagConstraints();
		gbc_lblValorDado_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorDado_1.gridx = 1;
		gbc_lblValorDado_1.gridy = 2;
		panel.add(lblValorDado_1, gbc_lblValorDado_1);
	}

	private void inicializarLabelValor1(JPanel panel) {
		JLabel lblValorDado = new JLabel("Valor Dado 1:");
		GridBagConstraints gbc_lblValorDado = new GridBagConstraints();
		gbc_lblValorDado.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorDado.gridx = 1;
		gbc_lblValorDado.gridy = 1;
		panel.add(lblValorDado, gbc_lblValorDado);
	}

	private JPanel inicializarPanelCentral() {
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		return panel;
	}

	private void inicializarVentana() {
		frame = new JFrame();
		frame.setBounds(100, 100, 225, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
	}

	private void inicializarBotón() {
		btnJugar = new JButton("Jugar");
		frame.getContentPane().add(btnJugar, BorderLayout.SOUTH);
		btnJugar.addActionListener(new EscuchadorBotón());
	}
}