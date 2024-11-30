/**
 * 
 */

/**
 * 
 */
public class Cella {
	
	private int riga;
	private int colonna;
	private Casella previousValue = null;

	Cella(int riga, int colonna) {
		this.riga = riga;
		this.colonna = colonna;
	}
	
	Cella(int riga, int colonna, Casella casella) {
		this.riga = riga;
		this.colonna = colonna;
		this.previousValue = casella;
	}
	
	

	public int getRiga() {
		return riga;
	}

	public void setRiga(int riga) {
		this.riga = riga;
	}

	public int getColonna() {
		return colonna;
	}

	public void setColonna(int colonna) {
		this.colonna = colonna;
	}
	
	public Casella getPreviousValue() {
		return previousValue;
	}
	
}
