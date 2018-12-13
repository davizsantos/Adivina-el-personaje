import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Tiempo implements Runnable {

	Integer minutos = 0;
	Integer segundos = 0;
	Integer milisegundos = 0;

	String min = "";
	String seg = "";
	String mil = "";
	
	static boolean pararCronometro = false;

	@Override
	public void run() {
		new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comenzarConometro(pararCronometro);
			}
		}).start();
	}

	protected void comenzarConometro(boolean pararCronometro) {
		while (!pararCronometro) {
			if (Ventana.lblTiempo.getText().equalsIgnoreCase("00:05:002")) {
				System.out.println("PARAMOS y el lblTiempo es: " + Ventana.lblTiempo.getText());
				Ventana.lblTiempo.setText("HOLA");
				System.out.println("lblTiempo deberia ser HOLA y es: " + Ventana.lblTiempo.getText());
				System.out.println("***");
				System.out.println("pararCronometro (parametro): " + pararCronometro);
				System.out.println("pararCronometro (variable ): " + Tiempo.pararCronometro);
				pararCronometro = true;
				System.out.println("pararCronometro tras modificarlo a false: " + pararCronometro);
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			// Incrementamos 1 milesimas de segundo
			milisegundos += 1;

			// Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
			// y las milesimas de segundo de nuevo a 0
			if (milisegundos == 1000) {
				milisegundos = 0;
				segundos += 1;
				// Si los segundos llegan a 60 entonces aumenta 1 los minutos
				// y los segundos vuelven a 0
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
			// Colocamos en la etiqueta la informacion
			// tiempo.setText( min + ":" + seg + ":" + mil );
			Ventana.lblTiempo.setText(min + ":" + seg + ":" + mil);
			Jugador.tiempoConsumido = Ventana.lblTiempo.getText();
			System.out.println("tiempo   : " + min + ":" + seg + ":" + mil);
			System.out.println("lblTiempo: " + min + ":" + seg + ":" + mil);
		}

		// tiempo.setText( "00:00:000" );
		System.out.println();

	}

}