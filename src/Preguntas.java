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

public class Preguntas extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static String preguntasArrayStr[]=new String[20]; //Para acceder desde "Ventana"
	
	JList listaPreguntas;
	DefaultListModel modelo = new DefaultListModel();
	
	String ruta_imagenes = System.getProperty("user.dir") + "\\imagenes\\";
	String a = System.getProperty("user.dir");
	
	ImageIcon iconoOK=new ImageIcon(ruta_imagenes + "iconoOK.jpg");
	
	Preguntas(){
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	void rellenarPreguntas(){
		System.out.println("Rellenando el array de preguntas...");
		int cont=0;
		preguntasArrayStr[cont]="¿Es hombre?";cont++;
		preguntasArrayStr[cont]="¿Tiene el pelo oscuro?";cont++;
		preguntasArrayStr[cont]="¿Tiene el pelo rubio?";cont++;
		preguntasArrayStr[cont]="¿Tiene el pelo blanco?";cont++;
		preguntasArrayStr[cont]="¿Tiene el pelo pelirrojo?";cont++;
		preguntasArrayStr[cont]="¿Tiene la nariz grande?";cont++;
		preguntasArrayStr[cont]="¿Tiene coloretes?";cont++;
		preguntasArrayStr[cont]="¿Tiene bigote?";cont++;
		preguntasArrayStr[cont]="¿Tiene sombrero?";cont++;
		preguntasArrayStr[cont]="¿Tiene barba?";cont++;
		preguntasArrayStr[cont]="¿Tiene gafas?";cont++;
		preguntasArrayStr[cont]="¿Tiene pendientes?";cont++;
		preguntasArrayStr[cont]="¿Tiene el pelo largo?";cont++;
		preguntasArrayStr[cont]="¿Tiene el pelo corto?";cont++;
		preguntasArrayStr[cont]="¿Es calvo/semi-calvo?";cont++;
		preguntasArrayStr[cont]="¿Las gafas son de color negro?";cont++;
		preguntasArrayStr[cont]="¿Las gafas son de color azul?";cont++;
		preguntasArrayStr[cont]="¿Las gafas son de color rojo?";cont++;
		preguntasArrayStr[cont]="¿Tiene los ojos castaños?";cont++;
		System.out.println("Array rellenado");
		
		System.out.println("Creando Jlist");
		listaPreguntas= new JList(preguntasArrayStr);
		System.out.println("Solo vamos a permitir una seleccion de la lista");
		listaPreguntas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelo = new DefaultListModel();
		System.out.println("Rellenamos la Jlist con las preguntas del array...");
		for (String string : preguntasArrayStr) {
			modelo.addElement(string);
		}
		System.out.println("Jlist rellenado...");

		listaPreguntas.setModel(modelo);
		System.out.println("Añadimos escuchador al panel de las preguntas");
		listaPreguntas.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { // Se mira si es doble click
					System.out.println("Añadiendo evento DOBLE CLICK...");
					int posicion = listaPreguntas.locationToIndex(e.getPoint());
					System.out.println("Se ha hecho doble click en la posicion " + posicion + " de la lista (" + listaPreguntas.getSelectedValuesList() + ")");
					comprobarPregunta(listaPreguntas.getSelectedValuesList(), Juego.PC.personajeAdjudicado);
					System.out.println("Evento DOBLE CLICK añadido");
				}
			}
		});

		System.out.println("Creando Scroll...");
		ScrollPane zonaConScroll= new ScrollPane ();
		zonaConScroll.setSize(400, 100);
		zonaConScroll.add(listaPreguntas);
		add(zonaConScroll);
		System.out.println("Scroll creado");		
		
	}
	
	protected void comprobarPregunta(List<Preguntas> listaPreguntas, Personaje personajeAdjudicado) {
		System.out.println("Comprobando la pregunta...");
		String preguntaSeleccionadaStr = listaPreguntas.toString();
		
		// Filtramos por pregunta
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Es hombre?]")) {
				if(personajeAdjudicado.isEsHombre()) {
					System.out.println("Si, el personaje es hombre");
					//PopUp
					JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje es hombre", "CORRECTO", getDefaultCloseOperation(), iconoOK);
				} else {
					System.out.println("No, el personaje no es hombre");
					JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no es hombre", "INCORRECTO", getDefaultCloseOperation());
				}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene el pelo oscuro?]")) {
				if(personajeAdjudicado.getColorPelo().equalsIgnoreCase("oscuro")) {
					System.out.println("Si, el personaje tiene el pelo ");
					//PopUp
					JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene el pelo oscuro", "CORRECTO", getDefaultCloseOperation(), iconoOK);
				} else {
					System.out.println("No, el personaje no tiene el pelo ");
					JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene el pelo oscuro", "INCORRECTO", getDefaultCloseOperation());
				}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene el pelo rubio?]")) {
			if(personajeAdjudicado.getColorPelo().equalsIgnoreCase("rubio")) {
				System.out.println("Si, el personaje tiene el pelo rubio");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene el pelo rubio", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no tiene el pelo rubio");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene el pelo rubio", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene el pelo blanco?]")) {
			if(personajeAdjudicado.getColorPelo().equalsIgnoreCase("blanco")) {
				System.out.println("Si, el personaje tiene el pelo blanco");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene el pelo blanco", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no tiene el pelo blanco");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene el pelo blanco", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene el pelo pelirrojo?]")) {
			if(personajeAdjudicado.getColorPelo().equalsIgnoreCase("pelirrojo")) {
				System.out.println("Si, el personaje tiene el pelo pelirrojo");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene el pelo pelirrojo", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no tiene el pelo pelirrojo");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene el pelo pelirrojo", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene la nariz grande?]")) {
			if(personajeAdjudicado.isNarizGrande()) {
				System.out.println("Si, el personaje tiene la nariz grande");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene la nariz grande", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no tiene la nariz grande");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene la nariz grande", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene coloretes?]")) {
			if(personajeAdjudicado.isTieneColorete()) {
				System.out.println("Si, el personaje tiene coloretes");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene coloretes", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no tiene coloretes");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene coloretes", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene bigote?]")) {
			if(personajeAdjudicado.isTieneBigote()) {
				System.out.println("Si, el personaje tiene bigote");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene bigote", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no tiene bigote");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene bigote", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene sombrero?]")) {
			if(personajeAdjudicado.isTieneSombrero()) {
				System.out.println("Si, el personaje tiene sombrero");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene sombrero", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no tiene sombrero");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene sombrero", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene barba?]")) {
			if(personajeAdjudicado.isTieneBarba()) {
				System.out.println("Si, el personaje tiene barba");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene barba", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no tiene barba");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene barba", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene gafas?]")) {
			if(personajeAdjudicado.isTieneGafas()) {
				System.out.println("Si, el personaje tiene gafas");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene gafas", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no tiene gafas");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene gafas", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene pendientes?]")) {
			if(personajeAdjudicado.isTienePendientes()) {
				System.out.println("Si, el personaje tiene pendientes");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene pendientes", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no tiene pendientes");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene pendientes", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene el pelo largo?]")) {
			if(personajeAdjudicado.getTipoPelo().equalsIgnoreCase("largo")) {
				System.out.println("Si, el personaje tiene el pelo largo");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene el pelo largo", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no tiene el pelo largo");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene el pelo largo", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene el pelo corto?]")) {
			if(personajeAdjudicado.getTipoPelo().equalsIgnoreCase("corto")) {
				System.out.println("Si, el personaje tiene el pelo corto");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje tiene el pelo corto", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no tiene el pelo corto");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no tiene el pelo corto", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Es calvo/semi-calvo?]")) {
			if(personajeAdjudicado.getTipoPelo().equalsIgnoreCase("calvo")) {
				System.out.println("Si, el personaje es calvo/semi-calvo");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, el personaje es calvo/semi-calvo", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, el personaje no es calvo/semi-calvo");
				JOptionPane.showMessageDialog(getComponent(0), "No, el personaje no es calvo/semi-calvo", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Las gafas son de color negro?]")) {
			if(personajeAdjudicado.getColorGafas().equalsIgnoreCase("negro")) {
				System.out.println("Si, las gafas del personaje son de color negro");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, las gafas del personaje son de color negro", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, las gafas del personaje no son de color negro");
				JOptionPane.showMessageDialog(getComponent(0), "No, las gafas del personaje no son de color negro", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Las gafas son de color azul?]")) {
			if(personajeAdjudicado.getColorGafas().equalsIgnoreCase("azul")) {
				System.out.println("Si, las gafas del personaje son de color azul");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, las gafas del personaje son de color azul", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, las gafas del personaje no son de color azul");
				JOptionPane.showMessageDialog(getComponent(0), "No, las gafas del personaje no son de color azul", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Las gafas son de color rojo?]")) {
			if(personajeAdjudicado.getColorGafas().equalsIgnoreCase("rojo")) {
				System.out.println("Si, las gafas del personaje son de color rojo");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, las gafas del personaje son de color rojo", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, las gafas del personaje no son de color rojo");
				JOptionPane.showMessageDialog(getComponent(0), "No, las gafas del personaje no son de color rojo", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		if(preguntaSeleccionadaStr.equalsIgnoreCase("[¿Tiene los ojos castaños?]")) {
			if(personajeAdjudicado.getColorOjos().equalsIgnoreCase("castaños")) {
				System.out.println("Si, las los ojos del personaje son castaños");
				//PopUp
				JOptionPane.showMessageDialog(getComponent(0), "Si, las los ojos del personaje son castaños", "CORRECTO", getDefaultCloseOperation(), iconoOK);
			} else {
				System.out.println("No, las los ojos del personaje no son castaños");
				JOptionPane.showMessageDialog(getComponent(0), "No, las los ojos del personaje no son castaños", "INCORRECTO", getDefaultCloseOperation());
			}
		}
		System.out.println("Pregunta comprobada");
		Juego.J1.cantidadDePruguntasRealizadas++;
	}

	private int getDefaultCloseOperation() {
		// TODO Auto-generated method stub
		return 0;
	}

}