import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import Personajes.Personaje;

/**
 * Clase que contiene las preguntas que el jugador puede realizar para intentar adivinar el personaje escondido.
 * 
 * @author david santos palmero
 * @version v1.0
 *
 */
public class Preguntas extends JPanel {

	private static final long serialVersionUID = 1L;

	int numeroDePreguntas = 20;
	String[] preguntasArrayStr;

	DefaultListModel<String> modelo = new DefaultListModel<>();
	JList<String> listaPreguntas;

	String nombreCarpetaImagenes = "imagenes";
	String ruta_imagenes = System.getProperty("user.dir") + "\\" + nombreCarpetaImagenes + "\\";
	String SUFIJO_JPG = ".jpg";
	ImageIcon iconoOK = new ImageIcon(ruta_imagenes + "iconoOK" + SUFIJO_JPG);

	/**
	 * Constructor por defecto.
	 */
	Preguntas() {
		rellenarPreguntas();
		insertarPreguntasEnVentana();
	}

	/**
	 * Metodo rellena el array de Strings con las preguntas.
	 */
	void rellenarPreguntas() {
		preguntasArrayStr = new String[numeroDePreguntas];
		preguntasArrayStr[0] = "¿Es hombre?";
		preguntasArrayStr[1] = "¿Tiene el pelo oscuro?";
		preguntasArrayStr[2] = "¿Tiene el pelo rubio?";
		preguntasArrayStr[3] = "¿Tiene el pelo blanco?";
		preguntasArrayStr[4] = "¿Tiene el pelo pelirrojo?";
		preguntasArrayStr[5] = "¿Tiene la nariz grande?";
		preguntasArrayStr[6] = "¿Tiene coloretes?";
		preguntasArrayStr[7] = "¿Tiene bigote?";
		preguntasArrayStr[8] = "¿Tiene sombrero?";
		preguntasArrayStr[9] = "¿Tiene barba?";
		preguntasArrayStr[10] = "¿Tiene gafas?";
		preguntasArrayStr[11] = "¿Tiene pendientes?";
		preguntasArrayStr[12] = "¿Tiene el pelo largo?";
		preguntasArrayStr[13] = "¿Tiene el pelo corto?";
		preguntasArrayStr[14] = "¿Es calvo/semi-calvo?";
		preguntasArrayStr[15] = "¿Las gafas son de color negro?";
		preguntasArrayStr[16] = "¿Las gafas son de color azul?";
		preguntasArrayStr[17] = "¿Las gafas son de color rojo?";
		preguntasArrayStr[18] = "¿Tiene los ojos castaños?";
	}

	/**
	 * Metodo que inserta incorpora el JList a la Ventana.
	 */
	private void insertarPreguntasEnVentana() {
		listaPreguntas = new JList<>(modelo);
		// Solo permitimos una seleccion de la lista
		listaPreguntas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Rellenamos la Jlist con las preguntas del array
		for (String string : preguntasArrayStr) {
			modelo.addElement(string);
		}
		listaPreguntas.setModel(modelo);
		// Añadiendo escuchador al panel de las preguntas
		listaPreguntas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Se comprueba si se ha hecho doble click
				if (e.getClickCount() == 2) {
					comprobarPregunta((List<String>) listaPreguntas.getSelectedValuesList(), Juego.PC.personajeAdjudicado);
				}
			}
		});
		// Se crea el scrol del Jlist
		ScrollPane zonaConScroll = new ScrollPane();
		zonaConScroll.setSize(400, 100);
		zonaConScroll.add(listaPreguntas);
		add(zonaConScroll);
	}

	/**
	 * Metodo que comprueba la pregunta y responde con un mensaje emergente SI o NO.
	 * 
	 * @param listaPreguntas      JList
	 * @param personajeAdjudicado Personaje
	 */
	protected void comprobarPregunta(List<String> listaPreguntas, Personaje personajeAdjudicado) {
		String preguntaSeleccionadaStr = listaPreguntas.toString();
		// Comprobamos el personaje y mostramos una ventana emergente indicando si se ha acertado o no
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Es hombre?]")) {
			if (personajeAdjudicado.isEsHombre()) {
				System.out.println("Si, el personaje es hombre");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje es hombre", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no es hombre");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no es hombre", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene el pelo oscuro?]")) {
			if (personajeAdjudicado.getColorPelo().equalsIgnoreCase("oscuro")) {
				System.out.println("Si, el personaje tiene el pelo ");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene el pelo oscuro", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene el pelo ");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene el pelo oscuro", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene el pelo rubio?]")) {
			if (personajeAdjudicado.getColorPelo().equalsIgnoreCase("rubio")) {
				System.out.println("Si, el personaje tiene el pelo rubio");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene el pelo rubio", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene el pelo rubio");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene el pelo rubio", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene el pelo blanco?]")) {
			if (personajeAdjudicado.getColorPelo().equalsIgnoreCase("blanco")) {
				System.out.println("Si, el personaje tiene el pelo blanco");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene el pelo blanco", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene el pelo blanco");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene el pelo blanco", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene el pelo pelirrojo?]")) {
			if (personajeAdjudicado.getColorPelo().equalsIgnoreCase("pelirrojo")) {
				System.out.println("Si, el personaje tiene el pelo pelirrojo");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene el pelo pelirrojo", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene el pelo pelirrojo");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene el pelo pelirrojo", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene la nariz grande?]")) {
			if (personajeAdjudicado.isNarizGrande()) {
				System.out.println("Si, el personaje tiene la nariz grande");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene la nariz grande", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene la nariz grande");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene la nariz grande", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene coloretes?]")) {
			if (personajeAdjudicado.isTieneColorete()) {
				System.out.println("Si, el personaje tiene coloretes");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene coloretes", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene coloretes");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene coloretes", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene bigote?]")) {
			if (personajeAdjudicado.isTieneBigote()) {
				System.out.println("Si, el personaje tiene bigote");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene bigote", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene bigote");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene bigote", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene sombrero?]")) {
			if (personajeAdjudicado.isTieneSombrero()) {
				System.out.println("Si, el personaje tiene sombrero");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene sombrero", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene sombrero");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene sombrero", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene barba?]")) {
			if (personajeAdjudicado.isTieneBarba()) {
				System.out.println("Si, el personaje tiene barba");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene barba", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene barba");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene barba", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene gafas?]")) {
			if (personajeAdjudicado.isTieneGafas()) {
				System.out.println("Si, el personaje tiene gafas");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene gafas", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene gafas");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene gafas", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene pendientes?]")) {
			if (personajeAdjudicado.isTienePendientes()) {
				System.out.println("Si, el personaje tiene pendientes");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene pendientes", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene pendientes");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene pendientes", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene el pelo largo?]")) {
			if (personajeAdjudicado.getTipoPelo().equalsIgnoreCase("largo")) {
				System.out.println("Si, el personaje tiene el pelo largo");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene el pelo largo", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene el pelo largo");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene el pelo largo", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene el pelo corto?]")) {
			if (personajeAdjudicado.getTipoPelo().equalsIgnoreCase("corto")) {
				System.out.println("Si, el personaje tiene el pelo corto");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene el pelo corto", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no tiene el pelo corto");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene el pelo corto", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Es calvo/semi-calvo?]")) {
			if (personajeAdjudicado.getTipoPelo().equalsIgnoreCase("calvo")) {
				System.out.println("Si, el personaje es calvo/semi-calvo");
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje es calvo/semi-calvo", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, el personaje no es calvo/semi-calvo");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no es calvo/semi-calvo", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Las gafas son de color negro?]")) {
			if (personajeAdjudicado.getColorGafas().equalsIgnoreCase("negro")) {
				System.out.println("Si, las gafas del personaje son de color negro");
				JOptionPane.showMessageDialog(getComponent(0), "Si, las gafas del personaje son de color negro", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, las gafas del personaje no son de color negro");
				JOptionPane.showMessageDialog(getComponent(0), "No, las gafas del personaje no son de color negro", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Las gafas son de color azul?]")) {
			if (personajeAdjudicado.getColorGafas().equalsIgnoreCase("azul")) {
				System.out.println("Si, las gafas del personaje son de color azul");
				JOptionPane.showMessageDialog(getComponent(0), "Si, las gafas del personaje son de color azul", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, las gafas del personaje no son de color azul");
				JOptionPane.showMessageDialog(getComponent(0), "No, las gafas del personaje no son de color azul", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Las gafas son de color rojo?]")) {
			if (personajeAdjudicado.getColorGafas().equalsIgnoreCase("rojo")) {
				System.out.println("Si, las gafas del personaje son de color rojo");
				JOptionPane.showMessageDialog(getComponent(0), "Si, las gafas del personaje son de color rojo", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, las gafas del personaje no son de color rojo");
				JOptionPane.showMessageDialog(getComponent(0), "No, las gafas del personaje no son de color rojo", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene los ojos castaños?]")) {
			if (personajeAdjudicado.getColorOjos().equalsIgnoreCase("castaños")) {
				System.out.println("Si, las los ojos del personaje son castaños");
				JOptionPane.showMessageDialog(getComponent(0), "Si, las los ojos del personaje son castaños", "CORRECTO", JOptionPane.INFORMATION_MESSAGE, iconoOK);
			} else {
				System.out.println("No, las los ojos del personaje no son castaños");
				JOptionPane.showMessageDialog(getComponent(0), "No, las los ojos del personaje no son castaños", "INCORRECTO", JOptionPane.ERROR_MESSAGE);
			}
		}
		// Aumentamos en 1 las preguntas realizadas
		Juego.J1.cantidadDePreguntasRealizadas++;
	}

}