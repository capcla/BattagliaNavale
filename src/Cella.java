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

	Cella(int riga, int colonna) {
		this.riga = riga;
		this.colonna = colonna;
	}
	
	Cella(int riga, int colonna, Casella casella) {
		this.riga = riga;
		this.colonna = colonna;
		this.value = casella;
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
	
	public Casella getValue() {
		return value;
	}

	public void setValue(Casella casella) {
		this.value = casella;
		
	}
	
	
	
}
