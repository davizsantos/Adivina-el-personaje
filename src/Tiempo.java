/**
 * Clase que gestiona el tiempo que dura la partida.
 * 
 * @author david santos palmero
 * @version v1.0
 *
 */
public class Tiempo implements Runnable {

	Integer minutos = 0;
	Integer segundos = 0;
	Integer milisegundos = 0;

	String min = "";
	String seg = "";
	String mil = "";

	static boolean pararCronometro = false;

	/**
	 * Metodo sobreescrito de la clase Runnable.
	 */
	@Override
	public void run() {
		comenzarConometro();
	}

	/**
	 * Metodo que pone en marcha el tiempo de la partida.
	 */
	protected void comenzarConometro() {
		while (!pararCronometro) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}

			calcularTiempo();
			formatearTiempo();
			actualizarTiempo();
		}

	}

	/**
	 * Metodo que calcula el tiempo que transcurre.
	 */
	private void calcularTiempo() {
		// Incrementamos 1 milesimas de segundo
		milisegundos += 1;

		// Cuando llega a 1000 osea 1 segundo aumenta 1 segundo y las milesimas de segundo de nuevo a 0
		if (milisegundos == 1000) {
			milisegundos = 0;
			segundos += 1;
			// Si los segundos llegan a 60 entonces aumenta 1 los minutos y los segundos vuelven a 0
			if (segundos == 60) {
				segundos = 0;
				minutos++;
			}
		}
	}

	/**
	 * Metodo que formatea el tiempo a 00:00:000 (minutos : segundos : milisegundos).
	 */
	private void formatearTiempo() {
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

	/**
	 * Metodo que actualiza el label a tiempo real y le asigna ese tiempo consumido al Jugador.
	 */
	private void actualizarTiempo() {
		Ventana.lblTiempo.setText(min + ":" + seg + ":" + mil);
		Jugador.tiempoConsumido = Ventana.lblTiempo.getText();
	}

}