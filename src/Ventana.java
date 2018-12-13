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
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JTextField personajeFinal;

	String rutaRelativaImagenes = "imagenes/";

	ImageIcon iconoOKImageIcon = new ImageIcon(getClass().getResource(rutaRelativaImagenes + "iconoOK.png"));

	Timer tiempo;

	Integer minutos = 0, segundos = 0, milisegundos = 0;
	String min = "", seg = "", mil = "";

	private ActionListener acciones = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			// Si la ventana principal está "cerrada", acaba con el hilo del tiempo.
			if (isActive()) {
				calcularTiempo();
			} else {
				tiempo.stop();
			}
			actualizarLabel();
		}

		private void calcularTiempo() {
			// Incrementamos 1 milesimas de segundo
			milisegundos += 1;

			// Cuando llega a 1000 milisegundos (1 segundo) aumenta 1 segundo y las
			// milesimas de segundo de nuevo a 0
			if (milisegundos == 1000) {
				milisegundos = 0;
				segundos += 1;
				// Si los segundos llegan a 60 entonces aumenta 1 los minutos y los segundos
				// vuelven a 0
				if (segundos == 60) {
					segundos = 0;
					minutos++;
				}
			}

			// Esto solamente es estetica para que siempre este en formato
			// 00:00:000
			if (minutos < 10) {
				min = "0" + minutos;
			} else {
				min = minutos.toString();
			}
			if (segundos < 10) {
				seg = "0" + segundos;
			} else {
				seg = segundos.toString();
			}
			if (milisegundos < 10) {
				mil = "00" + milisegundos;
			} else if (milisegundos < 100) {
				mil = "0" + milisegundos;
			} else {
				mil = milisegundos.toString();
			}
		}
	};

	// static para poder acceder desde otra clase (Tiempo)
	static JLabel lblTiempo = new JLabel("00:00:000");

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Ventana frame = new Ventana();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 630);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(new BorderLayout(0, 0));

		/* Icono ventana */
		Image icono = new ImageIcon(getClass().getResource(rutaRelativaImagenes + "icono.png")).getImage();
		setIconImage(icono);

		/* CABECERA */
		JPanel cabecera = new JPanel();
		contentPane.add(cabecera, BorderLayout.NORTH);
		cabecera.setLayout(new BorderLayout(0, 0));

		JButton personajeJ1 = new JButton();
		personajeJ1.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "personajeOculto.png")));
		hacerBotonTransparente(personajeJ1);
		cabecera.add(personajeJ1, BorderLayout.WEST);

		JButton personajePC = new JButton("");
		personajePC.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "personajeOculto.png")));
		hacerBotonTransparente(personajePC);
		cabecera.add(personajePC, BorderLayout.EAST);

		/* PREGUNTAS */
		Preguntas preguntas = new Preguntas();
		preguntas.rellenarPreguntas();
		cabecera.add(preguntas, BorderLayout.CENTER);

		/* PANEL CONFIRMAR PERSONAJE */
		JPanel panelProbarPersonaje = new JPanel();
		cabecera.add(panelProbarPersonaje, BorderLayout.SOUTH);
		panelProbarPersonaje.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		tiempo = new Timer(1, acciones);
		panelProbarPersonaje.add(lblTiempo);

		personajeFinal = new JTextField();
		panelProbarPersonaje.add(personajeFinal);
		personajeFinal.setColumns(10);

		/* BOTON LO SÉ! */
		JButton botonConfirmar = new JButton("LO SÉ!");
		panelProbarPersonaje.add(botonConfirmar);
		ImageIcon iconoOKImageIcon = new ImageIcon(getClass().getResource(rutaRelativaImagenes + "iconoOK.png"));
		// accion de este boton
		botonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 11));
				pararCronometro();
				Tiempo.pararCronometro = true;
				System.out.println("Paramos el cronometro en: " + lblTiempo.getText());
				int intentos = Juego.J1.cantidadDePruguntasRealizadas;
				String nombrePersonaje = Juego.PC.personajeAdjudicado.getNombre();
				if (Jugador.personajeAcerdado(personajeFinal.getText(), Juego.PC) == true) {
					JOptionPane.showMessageDialog(getComponent(0),
							"Exacto, has adivinado el personaje en " + intentos
									+ " intentos y con el siguiente tiempo: " + lblTiempo.getText(),
							"CORRECTO", getDefaultCloseOperation(), (Icon) iconoOKImageIcon);
				} else {
					JOptionPane.showMessageDialog(getComponent(0),
							"Has fallado tras " + intentos + " intentos y con el siguiente tiempo: "
									+ lblTiempo.getText() + "\nEl personaje era " + nombrePersonaje,
							"INCORRECTO", JOptionPane.ERROR_MESSAGE);
				}
				// Mostramos el personaje del PC
				personajePC.setIcon(
						new ImageIcon(getClass().getResource(rutaRelativaImagenes + nombrePersonaje + ".jpg")));
			}
		});

		/* PARRILLA */
		JPanel parrilla = new JPanel();
		contentPane.add(parrilla, BorderLayout.CENTER);
		parrilla.setLayout(new GridLayout(3, 8, 0, 0));

		JButton alex = new JButton("");
		alex.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "alex.jpg")));
		hacerBotonTransparente(alex);
		alex.addMouseListener(new MouseAdapter() {
			private boolean alexEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (alexEnBN) {
					alex.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "alex.jpg")));
					alexEnBN = false;
				} else {
					alex.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "alexbn.jpg")));
					alexEnBN = true;
				}
			}
		});
		parrilla.add(alex);

		JButton alfred = new JButton("");
		alfred.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "alfred.jpg")));
		hacerBotonTransparente(alfred);
		alfred.addMouseListener(new MouseAdapter() {
			private boolean alfredEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (alfredEnBN) {
					alfred.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "alfred.jpg")));
					alfredEnBN = false;
				} else {
					alfred.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "alfredbn.jpg")));
					alfredEnBN = true;
				}
			}
		});
		parrilla.add(alfred);

		JButton anita = new JButton("");
		anita.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "anita.jpg")));
		hacerBotonTransparente(anita);
		anita.addMouseListener(new MouseAdapter() {
			private boolean anitaEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (anitaEnBN) {
					anita.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "anita.jpg")));
					anitaEnBN = false;
				} else {
					anita.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "anitabn.jpg")));
					anitaEnBN = true;
				}
			}
		});
		parrilla.add(anita);

		JButton anne = new JButton("");
		anne.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "anne.jpg")));
		hacerBotonTransparente(anne);
		anne.addMouseListener(new MouseAdapter() {
			private boolean anneEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (anneEnBN) {
					anne.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "anne.jpg")));
					anneEnBN = false;
				} else {
					anne.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "annebn.jpg")));
					anneEnBN = true;
				}
			}
		});
		parrilla.add(anne);

		JButton bernard = new JButton("");
		bernard.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "bernard.jpg")));
		hacerBotonTransparente(bernard);
		bernard.addMouseListener(new MouseAdapter() {
			private boolean bernardEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (bernardEnBN) {
					bernard.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "bernard.jpg")));
					bernardEnBN = false;
				} else {
					bernard.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "bernardbn.jpg")));
					bernardEnBN = true;
				}
			}
		});
		parrilla.add(bernard);

		JButton bill = new JButton("");
		bill.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "bill.jpg")));
		hacerBotonTransparente(bill);
		bill.addMouseListener(new MouseAdapter() {
			private boolean billEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (billEnBN) {
					bill.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "bill.jpg")));
					billEnBN = false;
				} else {
					bill.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "billbn.jpg")));
					billEnBN = true;
				}
			}
		});
		parrilla.add(bill);

		JButton charles = new JButton("");
		charles.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "charles.jpg")));
		hacerBotonTransparente(charles);
		charles.addMouseListener(new MouseAdapter() {
			private boolean charlesEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (charlesEnBN) {
					charles.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "charles.jpg")));
					charlesEnBN = false;
				} else {
					charles.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "charlesbn.jpg")));
					charlesEnBN = true;
				}
			}
		});
		parrilla.add(charles);

		JButton claire = new JButton("");
		claire.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "claire.jpg")));
		hacerBotonTransparente(claire);
		claire.addMouseListener(new MouseAdapter() {
			private boolean claireEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (claireEnBN) {
					claire.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "claire.jpg")));
					claireEnBN = false;
				} else {
					claire.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "clairebn.jpg")));
					claireEnBN = true;
				}
			}
		});
		parrilla.add(claire);

		JButton david = new JButton("");
		david.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "david.jpg")));
		hacerBotonTransparente(david);
		david.addMouseListener(new MouseAdapter() {
			private boolean davidEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (davidEnBN) {
					david.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "david.jpg")));
					davidEnBN = false;
				} else {
					david.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "davidbn.jpg")));
					davidEnBN = true;
				}
			}
		});
		parrilla.add(david);

		JButton eric = new JButton("");
		eric.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "eric.jpg")));
		hacerBotonTransparente(eric);
		eric.addMouseListener(new MouseAdapter() {
			private boolean ericEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (ericEnBN) {
					eric.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "eric.jpg")));
					ericEnBN = false;
				} else {
					eric.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "ericbn.jpg")));
					ericEnBN = true;
				}
			}
		});
		parrilla.add(eric);

		JButton frans = new JButton("");
		frans.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "frans.jpg")));
		hacerBotonTransparente(frans);
		frans.addMouseListener(new MouseAdapter() {
			private boolean fransEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (fransEnBN) {
					frans.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "frans.jpg")));
					fransEnBN = false;
				} else {
					frans.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "fransbn.jpg")));
					fransEnBN = true;
				}
			}
		});
		parrilla.add(frans);

		JButton george = new JButton("");
		george.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "george.jpg")));
		hacerBotonTransparente(george);
		george.addMouseListener(new MouseAdapter() {
			private boolean georgeEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (georgeEnBN) {
					george.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "george.jpg")));
					georgeEnBN = false;
				} else {
					george.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "georgebn.jpg")));
					georgeEnBN = true;
				}
			}
		});
		parrilla.add(george);

		JButton herman = new JButton("");
		herman.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "herman.jpg")));
		hacerBotonTransparente(herman);
		herman.addMouseListener(new MouseAdapter() {
			private boolean hermanEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (hermanEnBN) {
					herman.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "herman.jpg")));
					hermanEnBN = false;
				} else {
					herman.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "hermanbn.jpg")));
					hermanEnBN = true;
				}
			}
		});
		parrilla.add(herman);

		JButton joe = new JButton("");
		joe.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "joe.jpg")));
		hacerBotonTransparente(joe);
		joe.addMouseListener(new MouseAdapter() {
			private boolean joeEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (joeEnBN) {
					joe.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "joe.jpg")));
					joeEnBN = false;
				} else {
					joe.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "joebn.jpg")));
					joeEnBN = true;
				}
			}
		});
		parrilla.add(joe);

		JButton maria = new JButton("");
		maria.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "maria.jpg")));
		hacerBotonTransparente(maria);
		maria.addMouseListener(new MouseAdapter() {
			private boolean mariaEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (mariaEnBN) {
					maria.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "maria.jpg")));
					mariaEnBN = false;
				} else {
					maria.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "mariabn.jpg")));
					mariaEnBN = true;
				}
			}
		});
		parrilla.add(maria);

		JButton max = new JButton("");
		max.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "max.jpg")));
		hacerBotonTransparente(max);
		max.addMouseListener(new MouseAdapter() {
			private boolean maxEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (maxEnBN) {
					max.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "max.jpg")));
					maxEnBN = false;
				} else {
					max.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "maxbn.jpg")));
					maxEnBN = true;
				}
			}
		});
		parrilla.add(max);

		JButton paul = new JButton("");
		paul.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "paul.jpg")));
		hacerBotonTransparente(paul);
		paul.addMouseListener(new MouseAdapter() {
			private boolean paulEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (paulEnBN) {
					paul.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "paul.jpg")));
					paulEnBN = false;
				} else {
					paul.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "paulbn.jpg")));
					paulEnBN = true;
				}
			}
		});
		parrilla.add(paul);

		JButton peter = new JButton("");
		peter.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "peter.jpg")));
		hacerBotonTransparente(peter);
		peter.addMouseListener(new MouseAdapter() {
			private boolean peterEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (peterEnBN) {
					peter.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "peter.jpg")));
					peterEnBN = false;
				} else {
					peter.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "peterbn.jpg")));
					peterEnBN = true;
				}
			}
		});
		parrilla.add(peter);

		JButton philip = new JButton("");
		philip.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "philip.jpg")));
		hacerBotonTransparente(philip);
		philip.addMouseListener(new MouseAdapter() {
			private boolean philipEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (philipEnBN) {
					philip.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "philip.jpg")));
					philipEnBN = false;
				} else {
					philip.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "philipbn.jpg")));
					philipEnBN = true;
				}
			}
		});
		parrilla.add(philip);

		JButton richard = new JButton("");
		richard.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "richard.jpg")));
		hacerBotonTransparente(richard);
		richard.addMouseListener(new MouseAdapter() {
			private boolean richardEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (richardEnBN) {
					richard.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "richard.jpg")));
					richardEnBN = false;
				} else {
					richard.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "richardbn.jpg")));
					richardEnBN = true;
				}
			}
		});
		parrilla.add(richard);

		JButton robert = new JButton("");
		robert.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "robert.jpg")));
		hacerBotonTransparente(robert);
		robert.addMouseListener(new MouseAdapter() {
			private boolean robertEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (robertEnBN) {
					robert.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "robert.jpg")));
					robertEnBN = false;
				} else {
					robert.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "robertbn.jpg")));
					robertEnBN = true;
				}
			}
		});
		parrilla.add(robert);

		JButton sam = new JButton("");
		sam.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "sam.jpg")));
		hacerBotonTransparente(sam);
		sam.addMouseListener(new MouseAdapter() {
			private boolean samEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (samEnBN) {
					sam.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "sam.jpg")));
					samEnBN = false;
				} else {
					sam.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "sambn.jpg")));
					samEnBN = true;
				}
			}
		});
		parrilla.add(sam);

		JButton susan = new JButton("");
		susan.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "susan.jpg")));
		hacerBotonTransparente(susan);
		susan.addMouseListener(new MouseAdapter() {
			private boolean susanEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (susanEnBN) {
					susan.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "susan.jpg")));
					susanEnBN = false;
				} else {
					susan.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "susanbn.jpg")));
					susanEnBN = true;
				}
			}
		});
		parrilla.add(susan);

		JButton tom = new JButton("");
		tom.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "tom.jpg")));
		hacerBotonTransparente(tom);
		tom.addMouseListener(new MouseAdapter() {
			private boolean tomEnBN = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (tomEnBN) {
					tom.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "tom.jpg")));
					tomEnBN = false;
				} else {
					tom.setIcon(new ImageIcon(getClass().getResource(rutaRelativaImagenes + "tombn.jpg")));
					tomEnBN = true;
				}
			}
		});
		parrilla.add(tom);
		// Hacemos la ventana visible en este punto para que se vea debajo del PopUp de
		// confirmacion y quede mas estético
		setVisible(true);
		// Generamos el PopUp para monezar el juego
		int respuesta;
		respuesta = JOptionPane.showConfirmDialog(null, "Comenzar a jugar", "Confirmar inicio",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		System.out.println("Respuesta: " + respuesta);
		if (respuesta == 0) {
			System.out.println("Se ha seleccionado SI");
			iniciarCronometro();
		} else {
			System.out.println("Se ha seleccionado NO");
			System.out.println("Cerrando aplicación...");
			System.exit(0);
		}

	}

	private void iniciarCronometro() {
		System.out.println("Se ha llamado al metodo iniciarCronometro()");
		tiempo.start();
	}

	private void pararCronometro() {
		System.out.println("Se ha llamado al metodo pararCronometro()");
		tiempo.stop();
	}

	public void actualizarLabel() {
		lblTiempo.setText(min + ":" + seg + ":" + mil);
	}

	private void hacerBotonTransparente(JButton boton) {
		boton.setOpaque(false);
		boton.setContentAreaFilled(false);
		boton.setBorderPainted(false);
	}

}