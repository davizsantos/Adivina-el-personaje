package Personajes;

/**
 * Clase que contiene las caracteristicas de cada Personaje.
 * 
 * @author david santos palmero
 * @version v1.0
 *
 */
public class Personaje {

	private String nombre;
	String colorPelo;
	String tipoPelo;
	String colorGafas;
	String colorOjos;
	boolean esHombre;
	boolean narizGrande;
	boolean tieneColorete;
	boolean tieneBigote;
	boolean tieneSombrero;
	boolean tieneBarba;
	boolean tieneGafas;
	boolean bocaGrande;
	boolean tienePendientes;

	/**
	 * Metodo que crea el Personaje Alex.
	 */
	void Alex() {
		setNombre("Alex");
		colorPelo = "oscuro";
		tipoPelo = "corto";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = true;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = true;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Alfred.
	 */
	void Alfred() {
		setNombre("Alfred");
		colorPelo = "pelirrojo";
		tipoPelo = "largo";
		colorGafas = null;
		colorOjos = "azules";

		esHombre = true;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = true;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = false;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Anita.
	 */
	void Anita() {
		setNombre("Anita");
		colorPelo = "rubio";
		tipoPelo = "largo";
		colorGafas = null;
		colorOjos = "azules";

		esHombre = false;
		narizGrande = false;
		tieneColorete = true;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = false;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Anne.
	 */
	void Anne() {
		setNombre("Anne");
		colorPelo = "oscuro";
		tipoPelo = "corto";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = false;
		narizGrande = true;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = false;
		tienePendientes = true;
	}

	/**
	 * Metodo que crea el Personaje Bernard.
	 */
	void Bernard() {
		setNombre("Bernard");
		colorPelo = "oscuro";
		tipoPelo = "corto";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = true;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = true;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = false;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Bill.
	 */
	void Bill() {
		setNombre("Bill");
		colorPelo = "pelirrojo";
		tipoPelo = "calvo";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = false;
		tieneColorete = true;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = true;
		tieneGafas = false;
		bocaGrande = false;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Charles.
	 */
	void Charles() {
		setNombre("Charles");
		colorPelo = "rubio";
		tipoPelo = "corto";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = true;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = true;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Claire.
	 */
	void Claire() {
		setNombre("Claire");
		colorPelo = "pelirrojo";
		tipoPelo = "corto";
		colorGafas = "azules";
		colorOjos = "castaños";

		esHombre = false;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = true;
		tieneBarba = false;
		tieneGafas = true;
		bocaGrande = false;
		tienePendientes = true;
	}

	/**
	 * Metodo que crea el Personaje David.
	 */
	void David() {
		setNombre("David");
		colorPelo = "rubio";
		tipoPelo = "corto";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = true;
		tieneGafas = false;
		bocaGrande = true;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Eric.
	 */
	void Eric() {
		setNombre("Eric");
		colorPelo = "rubio";
		tipoPelo = "corto";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = true;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = true;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Frans.
	 */
	void Frans() {
		setNombre("Frans");
		colorPelo = "pelirrojo";
		tipoPelo = "corto";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = false;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje George.
	 */
	void George() {
		setNombre("George");
		colorPelo = "blanco";
		tipoPelo = "corto";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = true;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = true;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Herman.
	 */
	void Herman() {
		setNombre("Herman");
		colorPelo = "pelirrojo";
		tipoPelo = "calvo";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = true;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = false;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Joe.
	 */
	void Joe() {
		setNombre("Joe");
		colorPelo = "rubio";
		tipoPelo = "corto";
		colorGafas = "rojas";
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = true;
		bocaGrande = false;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Maria.
	 */
	void Maria() {
		setNombre("Maria");
		colorPelo = "oscuro";
		tipoPelo = "largo";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = false;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = true;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = false;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Max.
	 */
	void Max() {
		setNombre("Max");
		colorPelo = "oscuro";
		tipoPelo = "corto";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = true;
		tieneColorete = false;
		tieneBigote = true;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = true;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Paul.
	 */
	void Paul() {
		setNombre("Paul");
		colorPelo = "blanco";
		tipoPelo = "corto";
		colorGafas = "negras";
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = true;
		bocaGrande = false;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Peter.
	 */
	void Peter() {
		setNombre("Peter");
		colorPelo = "blanco";
		tipoPelo = "corto";
		colorGafas = null;
		colorOjos = "azules";

		esHombre = true;
		narizGrande = true;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = true;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Philip.
	 */
	void Philip() {
		setNombre("Philip");
		colorPelo = "oscuro";
		tipoPelo = "corto";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = false;
		tieneColorete = true;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = true;
		tieneGafas = false;
		bocaGrande = true;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Richard.
	 */
	void Richard() {
		setNombre("Richard");
		colorPelo = "oscuro";
		tipoPelo = "calvo";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = true;
		tieneSombrero = false;
		tieneBarba = true;
		tieneGafas = false;
		bocaGrande = false;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Robert.
	 */
	void Robert() {
		setNombre("Robert");
		colorPelo = "oscuro";
		tipoPelo = "corto";
		colorGafas = null;
		colorOjos = "azules";

		esHombre = true;
		narizGrande = true;
		tieneColorete = true;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = true;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Sam.
	 */
	void Sam() {
		setNombre("Sam");
		colorPelo = "blanco";
		tipoPelo = "calvo";
		colorGafas = "negras";
		colorOjos = "castaños";

		esHombre = true;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = true;
		bocaGrande = false;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Susan.
	 */
	void Susan() {
		setNombre("Susan");
		colorPelo = "blanco";
		tipoPelo = "largo";
		colorGafas = null;
		colorOjos = "castaños";

		esHombre = false;
		narizGrande = false;
		tieneColorete = true;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = false;
		bocaGrande = true;
		tienePendientes = false;
	}

	/**
	 * Metodo que crea el Personaje Tom.
	 */
	void Tom() {
		setNombre("Tom");
		colorPelo = "oscuro";
		tipoPelo = "calvo";
		colorGafas = "azules";
		colorOjos = "azules";

		esHombre = true;
		narizGrande = false;
		tieneColorete = false;
		tieneBigote = false;
		tieneSombrero = false;
		tieneBarba = false;
		tieneGafas = true;
		bocaGrande = false;
		tienePendientes = false;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + getNombre() + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColorPelo() {
		return colorPelo;
	}

	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}

	public String getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(String tipoPelo) {
		this.tipoPelo = tipoPelo;
	}

	public String getColorGafas() {
		return colorGafas;
	}

	public void setColorGafas(String colorGafas) {
		this.colorGafas = colorGafas;
	}

	public String getColorOjos() {
		return colorOjos;
	}

	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	}

	public boolean isEsHombre() {
		return esHombre;
	}

	public void setEsHombre(boolean esHombre) {
		this.esHombre = esHombre;
	}

	public boolean isNarizGrande() {
		return narizGrande;
	}

	public void setNarizGrande(boolean narizGrande) {
		this.narizGrande = narizGrande;
	}

	public boolean isTieneColorete() {
		return tieneColorete;
	}

	public void setTieneColorete(boolean tieneColorete) {
		this.tieneColorete = tieneColorete;
	}

	public boolean isTieneBigote() {
		return tieneBigote;
	}

	public void setTieneBigote(boolean tieneBigote) {
		this.tieneBigote = tieneBigote;
	}

	public boolean isTieneSombrero() {
		return tieneSombrero;
	}

	public void setTieneSombrero(boolean tieneSombrero) {
		this.tieneSombrero = tieneSombrero;
	}

	public boolean isTieneBarba() {
		return tieneBarba;
	}

	public void setTieneBarba(boolean tieneBarba) {
		this.tieneBarba = tieneBarba;
	}

	public boolean isTieneGafas() {
		return tieneGafas;
	}

	public void setTieneGafas(boolean tieneGafas) {
		this.tieneGafas = tieneGafas;
	}

	public boolean isBocaGrande() {
		return bocaGrande;
	}

	public void setBocaGrande(boolean bocaGrande) {
		this.bocaGrande = bocaGrande;
	}

	public boolean isTienePendientes() {
		return tienePendientes;
	}

	public void setTienePendientes(boolean tienePendientes) {
		this.tienePendientes = tienePendientes;
	}

}
