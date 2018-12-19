import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Personajes.Personaje;
import Personajes.Personajes;

/**
 * Clase que genera la Ventana principal del juego.
 * 
 * @author david santos palmero
 * @version v1.0
 *
 */
public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JTextField personajeFinal;

	String rutaRelativaImagenes;
	ImageIcon iconoOKImageIcon;

	JPanel cabecera;
	JButton personajeJ1;
	JButton personajePC;
	Preguntas preguntas;
	JPanel panelProbarPersonaje;
	JButton botonConfirmar;
	JPanel parrilla;

	JButton[] botonesPersonajesArray;

	// static para poder acceder desde otra clase (Tiempo)
	static JLabel lblTiempo = new JLabel("00:00:000");

	/**
	 * Constructor por defecto que genera la Ventana.
	 */
	public Ventana() {
		rutaRelativaImagenes = "imagenes/";
		iconoOKImageIcon = new ImageIcon(getClass().getResource(rutaRelativaImagenes + "iconoOK.png"));

		asignarCaracteristicasDeLaVentana();
		asignarIconoVentana();
		crearPanelCabecera();
		crearBotonPersonajeJ1();
		crearBotonPersonajePC();
		insertarPreguntasEnCabecera();
		crearPanelProbarPersonaje();
		crearBotonLoSe();
		crearPanelParrilla();
		generarBotonesConImagenesPersonajes();

		// Hacemos la ventana visible en este punto para que se vea debajo del PopUp de confirmacion y quede mas estético
		setVisible(true);
		// Generamos el PopUp para comenzar el juego
		int respuesta = JOptionPane.showConfirmDialog(null, "Comenzar a jugar", "Confirmar inicio", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		System.out.println("Respuesta: " + respuesta);
		if (respuesta == JOptionPane.YES_OPTION) {
			System.out.println("Se ha seleccionado SI");
			iniciarCronometro();
		} else if (respuesta == JOptionPane.NO_OPTION) {
			System.out.println("Se ha seleccionado NO");
			System.out.println("Cerrando aplicación...");
			System.exit(0);
		} else {
			// Cerramos por si acaso se ha devuelto algo inesperado
			System.exit(0);
			System.out.println("Cerrando aplicación...");
		}

	}

	/**
	 * Metodo que crea las caracteristicas de la Ventana.
	 * 
	 * @param ventanaParam
	 */
	private void asignarCaracteristicasDeLaVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 630);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	/**
	 * Metodo para asignarle un icono a la Ventana de la aplicacion.
	 * 
	 * @param ventana
	 */
	private void asignarIconoVentana() {
		Image icono = new ImageIcon(getClass().getResource(rutaRelativaImagenes + "icono.png")).getImage();
		setIconImage(icono);
	}

	/**
	 * Metodo que crea el JPanel "cabecera".
	 */
	private void crearPanelCabecera() {
		cabecera = new JPanel();
		contentPane.add(cabecera, BorderLayout.NORTH);
		cabecera.setLayout(new BorderLayout(0, 0));
	}

	/**
	 * Metodo que crea el JButton con el personaje del J1.
	 */
	private void crearBotonPersonajeJ1() {
		personajeJ1 = new JButton();
		personajeJ1.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "personajeOculto.png")));
		hacerBotonTransparente(personajeJ1);
		cabecera.add(personajeJ1, BorderLayout.WEST);
	}

	/**
	 * Metodo que crea el JButton con el personaje del PC.
	 */
	private void crearBotonPersonajePC() {
		personajePC = new JButton("");
		personajePC.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "personajeOculto.png")));
		hacerBotonTransparente(personajePC);
		cabecera.add(personajePC, BorderLayout.EAST);
	}

	/**
	 * Metodo que inserta la JList de preguntas en el JPanel "cabecera".
	 */
	private void insertarPreguntasEnCabecera() {
		preguntas = new Preguntas();
		cabecera.add(preguntas, BorderLayout.CENTER);
	}

	/**
	 * Metodo que crea el JPanel "panelProbarPersonaje".
	 */
	private void crearPanelProbarPersonaje() {
		panelProbarPersonaje = new JPanel();
		cabecera.add(panelProbarPersonaje, BorderLayout.SOUTH);
		panelProbarPersonaje.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelProbarPersonaje.add(lblTiempo);
		personajeFinal = new JTextField();
		panelProbarPersonaje.add(personajeFinal);
		personajeFinal.setColumns(10);
	}

	/**
	 * Metodo que crea el JButton que comprueba si el presonaje escondido es el correcto.
	 */
	private void crearBotonLoSe() {
		botonConfirmar = new JButton("LO SÉ!");
		panelProbarPersonaje.add(botonConfirmar);
		ImageIcon iconoOKImageIcon = new ImageIcon(getClass().getResource(rutaRelativaImagenes + "iconoOK.png"));
		botonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 11));
				pararCronometro();
				System.out.println("Paramos el cronometro en: " + lblTiempo.getText());
				int intentos = Juego.J1.cantidadDePreguntasRealizadas;
				String nombrePersonaje = Juego.PC.personajeAdjudicado.getNombre();
				mostrarPersonajeDelPC(personajePC, nombrePersonaje);
				if (Jugador.personajeAcerdado(personajeFinal.getText(), Juego.PC) == true) {
					JOptionPane.showMessageDialog(getComponent(0), "Exacto, has adivinado el personaje en " + intentos + " intentos y con el siguiente tiempo: " + lblTiempo.getText(), "CORRECTO",
							getDefaultCloseOperation(), (Icon) iconoOKImageIcon);
				} else {
					JOptionPane.showMessageDialog(getComponent(0),
							"Has fallado tras " + intentos + " intentos y con el siguiente tiempo: " + lblTiempo.getText() + "\nEl personaje era " + nombrePersonaje, "INCORRECTO",
							JOptionPane.ERROR_MESSAGE);
				}
				// Le preguntamos al usuario si quiere jugar otra partida o salir del juego
				int seleccion = JOptionPane.showOptionDialog(getComponent(0), "¿Que desea hacer ahora?", "FIN DE LA PARTIDA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new Object[] { "Jugar otra vez", "Salir del juego" }, "Jugar otra vez");
				if (seleccion == JOptionPane.YES_NO_OPTION) {
					System.out.println("Se ha seleccionado \"Jugar otra vez\"");
					// TODO Aun no está bien conseguido el reiniciar la partida
					// reiniciarPartida();
					JOptionPane.showMessageDialog(getComponent(0), "Lo sentimos, está opción aún no está implementada.\nProcederemos a salir del juego", "OPCION NO DISPONIBLE",
							JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				} else {
					System.out.println("Se ha seleccionado \"Salir del juego\"");
					System.exit(0);
				}
			}
		});
	}

	/**
	 * Metodo que crea el JPanel "parrilla".
	 */
	private void crearPanelParrilla() {
		parrilla = new JPanel();
		contentPane.add(parrilla, BorderLayout.CENTER);
		parrilla.setLayout(new GridLayout(3, 8, 0, 0));
	}

	/**
	 * Metodo que genera los JButton de los personajes que se alojan en el JPanel "parrilla".
	 */
	private void generarBotonesConImagenesPersonajes() {
		// Creamos un array de JButton con tantos botones como personajes haya en el array de personajes
		botonesPersonajesArray = new JButton[Personajes.personajes.length];

		for (Personaje itemPersonaje : Personajes.personajes) {
			String nombreImagen;
			JButton boton = new JButton("");
			nombreImagen = itemPersonaje.getNombre().toLowerCase();

			boton.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + nombreImagen + ".jpg")));
			hacerBotonTransparente(boton);
			boton.addMouseListener(new MouseAdapter() {
				private boolean botonEnBN = false;

				@Override
				public void mouseClicked(MouseEvent e) {
					if (botonEnBN) {
						boton.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + nombreImagen + ".jpg")));
						botonEnBN = false;
					} else {
						boton.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + nombreImagen + "bn.jpg")));
						botonEnBN = true;
					}
				}
			});
			parrilla.add(boton);
		}
	}

	// TODO Funcionalidad aún no implementada
	/**
	 * Metodo que reinicia la partida
	 */
	private void reiniciarPartida() {
		this.removeAll();
		lblTiempo.setText("00:00:000");
		new Juego().jugar();
	}

	/**
	 * Metodo que hace visible el personaje escondido.
	 * 
	 * @param personajePC     Jbutton del Jugador PC
	 * @param nombrePersonaje String nombre del personaje escondido
	 */
	private void mostrarPersonajeDelPC(JButton personajePC, String nombrePersonaje) {
		personajePC.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + nombrePersonaje + ".jpg")));
	}

	/**
	 * Metodo que inicia el tiempo.
	 */
	private void iniciarCronometro() {
		Tiempo tiempo = new Tiempo();
		Thread hilo = new Thread(tiempo);
		hilo.start();
	}

	/**
	 * Metodo que para el tiempo.
	 */
	private void pararCronometro() {
		Tiempo.pararCronometro = true;
	}

	/**
	 * Metodo que hace transparente el boton se pase por parametro.
	 * 
	 * @param boton JButton que queremos hacer transparente
	 */
	private void hacerBotonTransparente(JButton boton) {
		boton.setOpaque(false);
		boton.setContentAreaFilled(false);
		boton.setBorderPainted(false);
	}

}