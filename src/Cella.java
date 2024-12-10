/**
 * 
 */

/**
 * 
 */
public class Cella {

	private int riga;
	private int colonna;
	private Casella value = null;

	/**
	 * Costruttore della classe Cella
	 * 
	 * @param riga    Intero indicante la coordinata riga
	 * @param colonna Intero indicante la coordinata colonna
	 */
	Cella(int riga, int colonna) {
		this.riga = riga;
		this.colonna = colonna;
	}

	/**
	 * Costruttore della classe Cella
	 * 
	 * @param riga    Intero indicante la coordinata riga
	 * @param colonna Intero indicante la coordinata colonna
	 * @param value   Casella indicante il valore assegnato alla cella di coordinare
	 *                (r, c)
	 */
	Cella(int riga, int colonna, Casella value) {
		this.riga = riga;
		this.colonna = colonna;
		this.value = value;
	}

	/**
	 * Restituisce il valore riga
	 * 
	 * @return riga
	 */
	public int getRiga() {
		return riga;
	}

	/**
	 * Assegnazione del valore riga
	 * 
	 * @param riga Intero che indica la coordinata riga
	 */
	public void setRiga(int riga) {
		this.riga = riga;
	}

	/**
	 * Restituisce il valore colonna
	 * 
	 * @return colonna Intero che indica il valore colonna
	 */
	public int getColonna() {
		return colonna;
	}

	/**
	 * Assegnazione del valore colonna
	 * 
	 * @param colonna Intero che indica la coordinata colonna
	 */
	public void setColonna(int colonna) {
		this.colonna = colonna;
	}

	/**
	 * Restituisce il valore value
	 * 
	 * @return value Casella che indica il valore value
	 */
	public Casella getValue() {
		return value;
	}

	/**
	 * Assegnazione del valore
	 * 
	 * @param value Casella che indica il valore value
	 */
	public void setValue(Casella value) {
		this.value = value;

	}

}
