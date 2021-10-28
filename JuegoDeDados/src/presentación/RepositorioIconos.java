package presentación;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class RepositorioIconos {
	
	private Map<String, ImageIcon> cachéIconos = new HashMap<String, ImageIcon>();
	
	public ImageIcon getIcono(String nombreArchivo, int tamaño) {
		ImageIcon icono = cachéIconos.get(nombreArchivo);
		
		return (icono != null) ? icono : generarIcono(nombreArchivo, tamaño);
	}

	private ImageIcon generarIcono(String nombreArchivo, int tamaño) {
		ImageIcon icono = obtenerIcono(nombreArchivo, tamaño);
		cachéIconos.put(nombreArchivo, icono);
		return icono;
	}

	private ImageIcon obtenerIcono(String nombreArchivo, int tamaño) {
		ImageIcon icono = new ImageIcon(presentacion.VentanaJuego.class
				.getResource("/presentaci\u00F3n/iconos/" + nombreArchivo));
		Image image = icono.getImage().getScaledInstance(tamaño, tamaño, Image.SCALE_SMOOTH);
		return new ImageIcon(image);
	}
}
