import java.util.Random;
import java.util.ArrayList;
import java.util.List;

class Griglia {

	private int righe;
	private int colonne;
	private int righeColonne;
	private int spazioTraCaratteri;
	private Casella griglia[][];
	private int sparo[];

	/**
	 * Costruttore del campo di battaglia
	 * 
	 * @param righe   intero indicante il numero delle righe della griglia
	 * @param colonne intero indicante il numero delle colonne della griglia
	 */
	Griglia(int righe, int colonne) {
		setRighe(righe);
		setColonne(colonne);
		griglia = new Casella[getRighe()][getColonne()];
		setSpazio(getRighe());

		// Inizializzazione della griglia di attacco mettendo tutte le caselle
		// sul valore VUOTO
		for (int i = 0; i < getRighe(); i++) {

			for (int j = 0; j < getColonne(); j++) {
				griglia[i][j] = Casella.VUOTO;
			}
		}

		// Inizializzazione della griglia degli spari da effettuare sulla
		// griglia di attacco
		setRigheColonne(righe, colonne);
		sparo = new int[getRigheColonne()];

		for (int i = 0; i < getRigheColonne(); i++) {
			sparo[i] = i;
		}

		mescolatore(sparo);
		getGriglia(griglia);
	}

	/**
	 * Costruttore TEST del campo di battaglia
	 * 
	 * @param righe   intero indicante il numero delle righe della griglia
	 * @param colonne intero indicante il numero delle colonne della griglia
	 */
	Griglia(int righe, int colonne, boolean test) {
		setRighe(righe);
		setColonne(colonne);
		griglia = new Casella[getRighe()][getColonne()];
		setSpazio(getRighe());

		// Inizializzazione della griglia di attacco mettendo tutte le caselle
		// sul valore VUOTO
		for (int i = 0; i < getRighe(); i++) {

			for (int j = 0; j < getColonne(); j++) {
				griglia[i][j] = Casella.VUOTO;
			}
		}

		// Inizializzazione della griglia degli spari da effettuare sulla
		// griglia di attacco
		setRigheColonne(righe, colonne);
		sparo = new int[getRigheColonne()];

		for (int i = 0; i < getRigheColonne(); i++) {
			sparo[i] = i;
		}

//		mescolatore(sparo);
		getGriglia(griglia);
	}

	/**
	 * Mescola i numeri dell'array sparo[] in modo da rendere casuali i colpi
	 * effettuati
	 * 
	 * @param sparo array dei colpi da sparare
	 */
	public void mescolatore(final int sparo[]) {

		Random random = new Random();
		int temp;
		int randomNumber;

		for (int i = 0; i < getRigheColonne(); i++) {
			// Estrazione di un numero casuale intero compreso tra 0 e
			// getRigheColonne()
			randomNumber = random.nextInt(getRigheColonne());

			// Scambio di variabili
			temp = sparo[i];
			sparo[i] = sparo[randomNumber];
			sparo[randomNumber] = temp;
		}
	}

	/**
	 * Visualizzatore della griglia di gioco
	 * 
	 * @param griglia array bidimensionale che visualizza le griglie del gioco
	 */
	public void getGriglia(Casella griglia[][]) {

		for (int i = 0; i < getRighe() + 2; i++) {

			for (int j = 0; j < getColonne() + 2; j++) {

				// Stampa tutti i caratteri della griglia
				if (i > 0 && i < getRighe() + 1) {

					if (j > 0 && j < getColonne() + 1)
						// Stampa lo stato di griglia[i][j]
						// System.out.printf("%" + getSpazio() + 'c', '~'/*griglia[i][j]*/);
						System.out.printf("%" + getSpazio() + "s", getCharCasella(griglia, i - 1, j - 1));

					else

					// Stampa i valori numerici delle etichette della prima
					// e ultima colonna. Lo spazio iniziale dell'etichetta
					// lato sinistro viene calcolata in base al numero di
					// righe da visualizzare
					if (i < 10 || j != getColonne() + 1)
						System.out.printf("%" + getSpazio() + 'd', i);
					else
						System.out.printf("%" + (getSpazio() + (int) Math.log10(i)) + 'd', i);
				} else {

					// Stampa le etichette superiore ed inferiore della tabella
					if (j > 0 && j < getColonne() + 1)
						// Stampa i vaolori letterali delle etichette
						System.out.printf("%" + getSpazio() + 'c', getCharFromInt(j - 1 + getIntFromChar('A')));
					else
						// Stampa il segno '+' agli angoli della griglia
						System.out.printf("%" + getSpazio() + 'c', '+');
				}
			}

			System.out.println();
		}
	}

	/**
	 * Prende un numero in input e ne calcola il quoziente (q) e il resto (r)
	 * rispetto a getColonne(). Successivamente il quoziente viene trasformato nella
	 * coordinata riga e il resto nella coordinata colonna
	 * 
	 * @param i
	 */
	public String getRigaColonna(final int i) {
		final int q = i / getColonne();
		final int r = i % getColonne();

		return(q + 1 + ", " + getCharFromInt(r + getIntFromChar('A')));
	}

	/**
	 * Metodo setter della variabile righe
	 * 
	 * @param righe intero indicante il numero delle righe della griglia
	 */
	public void setRighe(int righe) {
		this.righe = righe;
	}

	/**
	 * Metodo setter della variabile colonne
	 * 
	 * @param colonne intero indicante il numero delle colonne della griglia
	 */
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	/**
	 * Metodo setter della variabile righeColonne ottenuta dal prodotto righe per
	 * colonne
	 * 
	 * @param righe   intero indicante il numero di riche della griglia
	 * @param colonne intero indicante il numero di colonne della griglia
	 */
	public void setRigheColonne(int righe, int colonne) {
		this.righeColonne = righe * colonne;
	}

	/**
	 * Metodo getter della variabile righe
	 * 
	 * @return restituisce il numero delle righe della griglia
	 */
	public int getRighe() {
		return this.righe;
	}

	/**
	 * Metodo getter della variabile colonne
	 * 
	 * @return restituisce il numero delle colonne della griglia
	 */
	public int getColonne() {
		return this.colonne;
	}

	/**
	 * Metodo getter della variabile righeColonne
	 * 
	 * @return restituisce il numero della variabile righeColonne
	 */
	public int getRigheColonne() {
		return this.righeColonne;
	}

	// Restituisce lo sparo della casella i
	public int getSparo(int i) {
		return sparo[i];
	}

	/**
	 * Trasforma un carattere dato in input in un intero
	 * 
	 * @param c char passato in input
	 * @return restituisce l'intero di un deterimnato carattere
	 */
	private int getIntFromChar(char c) {
		return (int) c;
	}

	// Trasforma un intero dato in input in un carattere
	private char getCharFromInt(int i) {
		return (char) i;
	}

	/**
	 * Calcola lo spazio che deve essere presente tra i caratteri della tabella il
	 * quale è ottenuto dal logaritmo in base 10 di i a cui è aggiunto 1
	 * 
	 * @param i
	 */
	private void setSpazio(int i) {
		this.spazioTraCaratteri = (int) Math.log10(i) + 1;
	}

	/**
	 *  Restituisce lo spazio che deve esserci tra i caratteri della griglia
	 * 
	 * @return
	 */
	private int getSpazio() {
		return this.spazioTraCaratteri;
	}

	/**
	 * Imposta l'opportuno valore nella casella griglia[][] a seconda degli input
	 * dati
	 * 
	 * @param s Stringa che indica l'input dell'utente
	 * @param i intero complessivo che indica le coordinate riga e colonna della
	 *          matrice di gioco
	 */
	public void setGriglia(final String s, final int i) {

		final int riga = i / getColonne();
		final int colonna = i % getColonne();

		// Il colpo è assegnato come ACQUA
		if (s.matches("[A]")) {
			griglia[riga][colonna] = Casella.ACQUA;
		}
		// se il colpo è assegnato come COLPITO [C] o AFFONDATO [F]
		else {
			griglia[riga][colonna] = Casella.COLPITO;

			// Possibile eccezione! Se lo stato di una casella è segnato come
			// COLPITO, deve avere almeno una casella assegnata VUOTO attorno
			// checkFreeNearPosition(riga, colonna);

			if (s.matches("[F]")) {

			}
		}

		// getGriglia(griglia);
	}

	/**
	 * Setta sulla griglia il valore di cella diagonale dell'array list
	 * 
	 * @param nodoList Array list delle celle e delle sue celle diagonali
	 */
	public void setDiagonals(ArrayList<Nodo> nodoList) {

		for (int i = 0; i < nodoList.size(); i++) {

			for (int j = 0; j < nodoList.get(i).getDiagonals().size(); j++) {
				int r = nodoList.get(i).getDiagonals().get(j).getRiga();
				int c = nodoList.get(i).getDiagonals().get(j).getColonna();
				griglia[r][c] = nodoList.get(i).getDiagonals().get(j).getValue();
			}
		}

	}

	/**
	 * Assegna il valore ASSEGNATO ad una determinata cella di coordinate (r, c) se
	 * la cella è libera
	 * 
	 * @param r Intero indicante la coordinata riga della cella attuale
	 * @param c Intero indicante la coordianta colonna della cella attuale
	 */
	public void setAssigned(int r, int c) {

		if (checkEmptyCell(r, c))
			griglia[r][c] = Casella.ASSEGNATO;
	}

	/**
	 * Restituisce un carattere indicante lo stato di una cella della griglia di
	 * coordinate (r, c)
	 * 
	 * @param g Array di caselle
	 * @param r Intero indicante il valore riga di una cella
	 * @param c Intero indicante il valore colonna di una cella
	 * @return ritorna un char che sintetizza lo stato di una casella
	 */
	/*private char getCharCasella(Casella g[][], int r, int c) {
		char ris = ' ';

		switch (g[r][c]) {
		
		case ACQUA:
			ris = '~';
			break;

		case COLPITO:
			ris = 'X';
			break;

		case ASSEGNATO:
			ris = 'A';
			break;
		}

		return ris;
	}*/
	
	private String getCharCasella(Casella g[][], int r, int c) {
		String reset = "\u001b[0m"; //Resetta il colore
        String grassettoRosso = "\u001b[1;31m"; //Imposta il grassetto rosso
        String grassettoBlu = "\u001b[1;34m"; //Imposta il grasestto blu
		String ris = " ";

		switch (g[r][c]) {
		

		case ACQUA:
			ris = grassettoBlu + " ~" + reset;
			break;

		case COLPITO:
			ris = grassettoRosso + " X" + reset;
			break;

		case ASSEGNATO:
			ris = "A";
			break;
		}

		return ris;
	}

	/**
	 * Restituisce lo stato di una casella di coordinate (r, c)
	 * 
	 * @param r Intero indicante il valore riga di una cella
	 * @param c Intero indicante il valore colonna di una cella
	 * @return Stato della casella di coordinate (r, c)
	 */
	public Casella getCasella(int r, int c) {
		return griglia[r][c];
	}

	/**
	 * Controlla se una cella è vuota a condizione che l'intero identificativo i sia
	 * nei range
	 * 
	 * @param i Intero complessivo indicante la riga e la colonna di una cella che
	 *          si vuole ispezionare
	 * @return Restituisce VERO se la cella(r,c) esiste ed è vuota; FALSO altrimenti
	 */
	public boolean checkEmptyCell(final int i) {
		final int r = i / getColonne();
		final int c = i % getColonne();
		boolean risultato;

		if (r >= 0 && r <= getRighe() && c >= 0 && c <= getColonne())
			risultato = griglia[r][c] == Casella.VUOTO;
		else
			risultato = false;

		return risultato;
	}

	/**
	 * Controlla se una cella è vuota a condizione che gli interi identificativi r e
	 * c siano negli opportuni range
	 * 
	 * @param r Intero indicante il valore colonna di una cella che si vuole
	 *          ispezionare
	 * @param c Intero indicante il valore riga di una cella che si vuole
	 *          ispezionare
	 * @return Restituisce VERO se la cella(r,c) esiste è vuota; FALSO altrimenti
	 */
	public boolean checkEmptyCell(int r, int c) {
		boolean risultato;

		if (r >= 0 && r < getRighe() && c >= 0 && c < getColonne())
			risultato = griglia[r][c] == Casella.VUOTO;
		else
			risultato = false;

		return risultato;
	}

	/**
	 * La funzione riceve i parametri della cella di partenza, della riga e della
	 * colonna della cella attuale (dove si intende ispezionare?), dell'avvenuta
	 * ispezione della direzione opposta e del numero delle caselle colpite. Chiede
	 * all'utente l'impostazione di un valore per la cella che si sta ispezionando.
	 * Se questo valore corrisponde agli stati di COLPITO o ASSEGANTO aumenta il
	 * numero delle celle colpite, imposta opportunamente le diagonali e, in caso di
	 * dichiarazione di affondamento, imposta i limiti della nave
	 * 
	 * inizia ad ispezionare il lato destro o sinistro di una cella
	 * 
	 * @param i                 Intero complessivo indicante sia la riga che la
	 *                          colonna della prima cella colpita di una nave
	 * @param riga              Intero indicante la riga della cella che si sta
	 *                          ispezionando
	 * @param colonna           Intero indicante la colonna della cella che si sta
	 *                          ispezionando
	 * @param oppositeDirection Boolean che segnala se la direzione opposta a quella
	 *                          che si sta ispezionando è già stata ispezionata
	 * @param nodoList          Struttura contenente le informazioni sui nodi e
	 *                          sulle caselle adiacenti
	 * @param naviNemicheList   Lista delle navi nemiche e delle loro informaizoni
	 */
	public void searchAndDestroy(final int i, final int riga, final int colonna, boolean oppositeDirection,
			ArrayList<Nodo> nodoList, List<Nave> naviNemicheList) {

		Input input = new Input();
		boolean checkColpito = false, checkAffondato = false;
		final int r = i / getColonne();
		final int c = i % getColonne();
		boolean quit = false; //
		Nodo nodo;
		boolean afs = true;
		boolean ripeti = true; // Fa ripetere il ciclo do-while se un colpo non
								// è ritenuto valido

		// Chiede all'utente conferma del colpo
		do {
			input.setInputTastiera(getRigaColonna(riga * getColonne() + colonna));
			checkColpito = input.checkColpito(input.getInputTastiera());
			checkAffondato = input.checkAffondato(input.getInputTastiera());

			// Controlla se la nava è stata colpita o affondata
			if (checkColpito || checkAffondato) {

				// Crea un nuovo nodo, ne
				// setta i vicini e lo aggiunge alla lista dei nodi
				nodo = new Nodo(new Cella(riga, colonna));
				nodo.setNeighboursNodoes(riga * getColonne() + colonna, this);
				nodoList.get(nodoList.size() - 1).removeHorizontalVertical(riga, colonna);
				nodoList.add(nodo);
				ripeti = false;

				// Se la nave è dichiarata affondata, vengono imposati i limiti
				// della nave
				if (checkAffondato) {

					if (afs = avoidFalseSinking(nodoList, naviNemicheList)) {
						setShipLimits(nodoList);
						setDiagonals(nodoList);
						removeNave(naviNemicheList, nodoList.size());
					} else {
						nodoList.remove(nodoList.size() - 1);
						ripeti = true;
					}
				} else {

					// Se la casella è dichiarata COLPITA, viene controllata la
					// casella successiva che si vuole ispezionare per verificare
					// che ci sia ancora una casella libera da colpire
					boolean nextCellFree = checkNextCell(nodoList.get(0).getCella(), riga, colonna);

//					if (nextCellFree && (oppositeDirection = checkOppositeCell(nodoList.get(0).getCella(), riga, colonna))) {
					if (oppositeDirection) {

//						int nls = nodoList.size();
//
//						if (isOppositeDirectionPossible(nodoList.get(nodoList.size() - 2/* 0 */).getCella(), riga,
//								colonna)) {
//							System.out.println("Sei arrivato al limite della griglia. "
//									+ "O la nave va a(F)fondata o la casella deve " + "essere dichiarata come (A)cqua");

						// Se non c'è una cella libera successiva alla direzione
						// che si sta ispezionando, il nodo aggiunto viene cancellato
						// e si impone che il processo sia ripetuto
						if (!nextCellFree) {

							System.out.println("Non ci sono altre caselle libere "
									+ "da colpire dopo di questa. La nave va affondata "
									+ "o comunque va cambiata la scelta per la casella");
							nodoList.remove(nodoList.size() - 1);
							ripeti = true;
						}
//						} else {
//							ripeti = true;
//
//						}
					} else {
						if (!nextCellFree) {
							oppositeDirection = !checkOppositeCell(nodoList.get(0).getCella(), riga, colonna);
//							System.out.println("Non ci sono altre caselle libere "
//									+ "da colpire dopo di questa. La nave va affondata "
//									+ "o comunque va cambiata la scelta per la casella");
//							nodoList.remove(nodoList.size() - 1);
//							ripeti = true;
						}
					}

					if (nodoList.size() == naviNemicheList.get(0).getDimensione()) {
						System.out.println("La nave ha una dimensione uguale a "
								+ "quella della nave più grande ancora in gioco ma "
								+ "non è stata dichiarata affondata. Cambiare la scelta");
						nodoList.remove(nodoList.size() - 1);
						ripeti = true;
					}

				}

				if (afs && !ripeti)
					setGriglia(input.getInputTastiera(), riga * getColonne() + colonna);

			} else { // La casella attuale è stata contrassegnata come ACQUA

				// La direzione opposta è stata già ispezionata e, intorno alla
				// cella iniziale, (nodoList.get(0)), non ci sono elementi liberi
				// orizzontalia o verticali
				// essere contrassegnata come ACQUA
				if (oppositeDirection /* = !checkOppositeCell(nodoList.get(0).getCella(), riga, colonna) */
						&& nodoList.get(0).getHorizontalVertical().size() <= 1) {

					ripeti = true;
					System.out.println("Reimmettere la scelta. La casella attuale non può essere "
							+ "contrassegnata come (A)CQUA");
				} else {

					if (oppositeDirection) {
						int hvSize = 0;
						// Quando un nodo viene contrassegnato come ACQUA. questo va
						// rimosso dalla lista dei nodi horizontalVertical del nodo
						// precedente in quanto non è più un nodo disponibile
						if (nodoList.get(0).getHorizontalVertical().size() > 1) {
							nodoList.get(0).removeHorizontalVertical(riga, colonna);
							setGriglia(input.getInputTastiera(), riga * getColonne() + colonna);
							ripeti = false;
							hvSize = nodoList.get(0).getHorizontalVertical().size();
						} else
							nodoList.get(nodoList.size() - 1).removeHorizontalVertical(riga, colonna);

						if (hvSize <= 1) {
							System.out.println("Reimmettere la scelta. La casella attuale non può essere "
									+ "contrassegnata come (A)CQUA");
							ripeti = true;
						}

					} else {

						nodoList.get(nodoList.size() - 1).removeHorizontalVertical(riga, colonna);
						setGriglia(input.getInputTastiera(), riga * getColonne() + colonna);
						getGriglia();
						ripeti = false;
					}
				}

				if (oppositeDirection && checkAffondato) {

					quit = true;

					// Dialogo con l'utente o cambio della scelta
					if (nodoList.size() == 1) {
						setAssigned(r, i % getColonne());
					} else {

					}

				}
			}

		} while (ripeti);

		getGriglia(griglia);

		if (!quit)

			choiceDirection(i, riga, colonna, r, c, checkColpito, checkAffondato, oppositeDirection, nodoList,
					naviNemicheList);

		if (griglia[riga][colonna] != Casella.COLPITO && (oppositeDirection || nodoList.size() == 1)) {
			// Dialogo con l'utente o cambio della scelta
			setAssigned(r, c);
			getGriglia();
		}
	}

	/**
	 * Il metodo riceve una serie di parametri in input in modo da poter scegliere
	 * il metodo opportuno da lanciare per continuare l'ispezione del lato
	 * 
	 * @param i                 Intero complessivo indicante sia la riga che la
	 *                          colonna della prima cella colpita di una nave
	 * @param riga              Intero indicante la riga della cella che si sta
	 *                          ispezionando
	 * @param colonna           Intero indicante la colonna della cella che si sta
	 *                          ispezionando
	 * @param r                 Intero indicante la posizione della riga attualmente
	 *                          ispezionata
	 * @param c                 Intero indicante la posizione della colonna
	 *                          attualmente ispezionata
	 * @param checkColpito      boolean che segnala se una cella è stata dichiarata
	 *                          colpita
	 * @param checkAffondato    boolean che segnala se la nave è stata dichiarata
	 *                          affondata
	 * @param oppositeDirection Boolean che segnala se la direzione opposta a quella
	 *                          che si sta ispezionando è già stata ispezionata
	 * @param nodoList          Struttura contenente le informazioni sui nodi e
	 *                          sulle caselle adiacenti
	 * @param naviNemicheList   Lista delle navi nemiche e delle loro informaizoni
	 */
	private void choiceDirection(int i, int riga, int colonna, int r, int c, boolean checkColpito,
			boolean checkAffondato, boolean oppositeDirection, ArrayList<Nodo> nodoList, List<Nave> naviNemicheList) {

		if (riga != r) {
			// Verifica se si deve ispezionare il lato superiore (riga > r) o inferiore
			// (riga < r) della nave. Il valore riga indica il valore della riga della
			// cella attuale mentre r indica il valore della riga della prima cella
			// colpita
			if (riga > r)
				goDownDirection(i, riga, colonna, r, checkColpito, checkAffondato, oppositeDirection, nodoList,
						naviNemicheList);
			else
				goUpDirection(i, riga, colonna, r, checkColpito, checkAffondato, oppositeDirection, nodoList,
						naviNemicheList);
		} else {
			// Verifica se si deve ispezionare il lato destro (colonna > c) o il sinistro
			// (colonna < c) della nave. Il valore colonna indica il valore colonna
			// della cella attuale mentre c indica il valore della colonna della
			// prima cella colpita

			if (colonna > c)
				goRightDirection(i, riga, colonna, c, checkColpito, checkAffondato, oppositeDirection, nodoList,
						naviNemicheList);
			else
				goLeftDirection(i, riga, colonna, c, checkColpito, checkAffondato, oppositeDirection, nodoList,
						naviNemicheList);
		}

	}

	/**
	 * Cerca e rimuove una nave dalla lista delle navi quando la sua dimensione è
	 * pari al parametro passato
	 * 
	 * @param naviNemicheList Lista delle navi
	 * @param lunghezzaNave   Intero che indica la lunghezza della nave da cercare
	 */
	private void removeNave(List<Nave> navi, int lunghezzaNave) {

		boolean trovato = false;

		for (int i = 0; i < navi.size() && !trovato; i++)

			if (navi.get(i).getDimensione() == lunghezzaNave) {
				navi.remove(i);
				trovato = true;
			}

		if (trovato == false) {
			System.out.println("Non esiste più una nave di dimensione " + lunghezzaNave);
		}
	}

	/**
	 * Prende in input l'array list nodoList e setta le caselle diagonali ad una
	 * cella dell'array list con il valore ASSEGNATO se il corrispettivo valore
	 * sulla griglia risulta essere VUOTO
	 * 
	 * @param nodoList Struttura contenente le informazioni sui nodi e sulle caselle
	 *                 adiacenti
	 */
	private void setShipLimits(ArrayList<Nodo> nodoList) {
		int minRiga = getRighe();
		int minColonna = getColonne();

		// Controlla tutti i nodi di nodoList
		for (int i = 0; i < nodoList.size(); i++) {

			// Impostazione della coordinata riga più piccola
			if (nodoList.get(i).getCella().getRiga() < minRiga)
				minRiga = nodoList.get(i).getCella().getRiga();

			// Impostazione della coordinata colonna più piccola
			if (nodoList.get(i).getCella().getColonna() < minColonna)
				minColonna = nodoList.get(i).getCella().getColonna();

			// Controlla tutti i diagonali di un nodo
			for (int j = 0; j < nodoList.get(i).getDiagonals().size(); j++)

				// Controlla che il valore di un nodo diagonale sia vuoto
				if (nodoList.get(i).getDiagonals().get(j).getValue() == Casella.VUOTO) {
					nodoList.get(i).getDiagonals().get(j).setValue(Casella.ASSEGNATO);
				}
		}

		// Se c'è differenza tra le righe di due celle, ci si sta muovendo in verticale
		// e quindi si devono settare i limiti superiore e inferiore della nave
		// sulle righe altrimenti si devono settare i limiti destro e sinistro
		// sulle colonne
		if (nodoList.get(0).getCella().getRiga() - nodoList.get(1).getCella().getRiga() != 0) {

			if (minRiga - 1 >= 0)
				setAssigned(minRiga - 1, minColonna);

			if (minRiga + nodoList.size() < getRighe())
				setAssigned(minRiga + nodoList.size(), minColonna);
		} else {

			if (minColonna - 1 >= 0)
				setAssigned(minRiga, minColonna - 1);

			if (minColonna + nodoList.size() < getColonne())
				setAssigned(minRiga, minColonna + nodoList.size());
		}
	}

	/**
	 * Richiama ricorsivamente la funzione searchAndDestroy dalla quale questa
	 * funzione è lanciata sull'opportuna cella e con gli opportuni parametri. Se
	 * l'ispezione del lato destro termina per qualche motivo, la funzione richiama
	 * searchAndDestroy segnalando il cambio di direzione tramite l'opportuno
	 * parametro
	 * 
	 * @param i                 intero complessivo indicante sia la riga che la riga
	 *                          che la colonna della prima cella colpita di una nave
	 * @param riga              intero indicante la riga della cella attuale
	 * @param colonna           intero indicante la colonna della cella attuale
	 * @param c                 intero indicante la posizione della prima colonna
	 *                          colpita di una nave
	 * @param caselleColpite    intero delle caselle colpite di una nave
	 * @param checkColpito      boolean che segnala se una cella è stata dichiarata
	 *                          colpita
	 * @param checkAffondato    boolean che segnala se la nave è stata dichiarata
	 *                          affondata
	 * @param oppositeDirection boolean che segnala se la direzione opposta a quella
	 *                          che si sta ispezionando è già stata ispezionata
	 * @param nodoList          Struttura contenente le informazioni sui nodi e
	 *                          sulle caselle adiacenti
	 */
	private void goRightDirection(final int i, final int riga, final int colonna, final int c,
			final boolean checkColpito, final boolean checkAffondato, boolean oppositeDirection,
			ArrayList<Nodo> nodoList, List<Nave> naviNemicheList) {

		// Controlla se colonna+1 è nei limiti dell'array, se la cella
		// (riga, colonna+1) è libera e se la cella è stata valutata come colpita o
		// affondata
		if (colonna + 1 < getColonne() && checkEmptyCell(riga, colonna + 1) && (checkColpito || checkAffondato)) {

			searchAndDestroy(i, riga, colonna + 1, oppositeDirection, nodoList, naviNemicheList);
		}
		// (riga, colonna+1) risulta non libera o colonna+1 esce dai limiti
		// dell'array

		// Controlla se c-1 è nei limiti dell'array, se cella(riga, c-1) è
		// libera e se la direzione opposta non è stata già ispezionata
		else {
			// oppositeDirection = true;

			if (c - 1 >= 0 && checkEmptyCell(riga, c - 1) && !oppositeDirection) {
				searchAndDestroy(i, riga, c - 1, true, nodoList, naviNemicheList);
			}
		}
	}

	/**
	 * Richiama ricorsivamente la funzione searchAndDestroy dalla quale questa
	 * funzione è lanciata sull'opportuna cella e con gli opportuni parametri. Se
	 * l'ispezione del lato sinistro termina per qualche motivo, la funzione
	 * richiama searchAndDestroy segnalando il cambio di direzione tramite
	 * l'opportuno parametro
	 * 
	 * @param i                 Intero complessivo indicante sia la riga che la riga
	 *                          che la colonna della prima cella colpita di una nave
	 * @param riga              Intero indicante la riga della cella attuale
	 * @param colonna           Intero indicante la colonna della cella attuale
	 * @param c                 Intero indicante la posizione della prima colonna
	 *                          colpita di una nave
	 * @param caselleColpite    Intero delle caselle colpite di una nave
	 * @param checkColpito      Boolean che segnala se una cella è stata dichiarata
	 *                          colpita
	 * @param checkAffondato    Boolean che segnala se la nave è stata dichiarata
	 *                          affondata
	 * @param oppositeDirection Boolean che segnala se la direzione opposta a quella
	 *                          che si sta ispezionando è già stata ispezionata
	 * @param nodoList          Struttura contenente le informazioni sui nodi e
	 *                          sulle caselle adiacenti
	 */
	private void goLeftDirection(final int i, final int riga, final int colonna, final int c,
			final boolean checkColpito, final boolean checkAffondato, boolean oppositeDirection,
			ArrayList<Nodo> nodoList, List<Nave> naviNemicheList) {

		// Controlla se colonna-1 è nei limiti della griglia, se la cella(riga,
		// colonna-1) è libera e se la cella è stata valutata come colpita
		// o affondata
		if (colonna - 1 >= 0 && checkEmptyCell(riga, colonna - 1) && (checkColpito || checkAffondato))
			searchAndDestroy(i, riga, colonna - 1, oppositeDirection, nodoList, naviNemicheList);

		// (riga, colonna-1) risulta non libera o colonna-1 esce dai limiti
		// dell'array o il valore immesso non indica COLPITO

		// Controlla se c+1 è nei limiti della griglia, se (riga, c+1) è libera
		// e se la direzione opposta è stata ispezionata
		else {
			// oppositeDirection = true;

			if (c + 1 < getColonne() && checkEmptyCell(riga, c + 1) && !oppositeDirection)
				searchAndDestroy(i, riga, c + 1, true, nodoList, naviNemicheList);
		}
	}

	/**
	 * Richiama ricorsivamente la funzione searchAndDestroy dalla quale questa
	 * funzione è lanciata sull'opportuna cella e con gli opportuni parametri. Se
	 * l'ispezione del lato superiore termina per qualche motivo, la funzione
	 * richiama searchAndDestroy segnalando il cambio di direzione tramite
	 * l'opportuno parametro
	 * 
	 * @param i                 Intero complessivo indicante sia la riga che la riga
	 *                          che la colonna della prima cella colpita di una nave
	 * @param riga              Intero indicante la riga della cella attuale
	 * @param colonna           Intero indicante la colonna della cella attuale
	 * @param c                 Intero indicante la posizione della prima colonna
	 *                          colpita di una nave
	 * @param caselleColpite    Intero delle caselle colpite di una nave
	 * @param checkColpito      Boolean che segnala se una cella è stata dichiarata
	 *                          colpita
	 * @param checkAffondato    Boolean che segnala se la nave è stata dichiarata
	 *                          affondata
	 * @param oppositeDirection Boolean che segnala se la direzione opposta a quella
	 *                          che si sta ispezionando è già stata ispezionata
	 * @param nodoList          Struttura contenente le informazioni sui nodi e
	 *                          sulle caselle adiacenti
	 */
	private void goUpDirection(final int i, final int riga, final int colonna, final int r, final boolean checkColpito,
			final boolean checkAffondato, final boolean oppositeDirection, ArrayList<Nodo> nodoList,
			List<Nave> naviNemicheList) {

		// Controlla se riga-1 è nei limiti della griglia, se la cella(riga-1,
		// colonna) è libera e se la cella è stata valutata come colpita
		// o affondata
		if (riga - 1 >= 0 && checkEmptyCell(riga - 1, colonna) && (checkColpito || checkAffondato))
			searchAndDestroy(i, riga - 1, colonna, oppositeDirection, nodoList, naviNemicheList);

		// (riga-1, colonna) risulta non libera o colonna-1 esce dai limiti
		// dell'array o il valore immesso non indica COLPITO

		// Controlla se c+1 è nei limiti della griglia, se (riga, c+1) è libera
		// e se la direzione opposta è stata ispezionata
		else {
			// oppositeDirection = true;

			if (r + 1 < getRighe() && checkEmptyCell(r + 1, colonna) && !oppositeDirection)
				searchAndDestroy(i, r + 1, colonna, true, nodoList, naviNemicheList);
		}
	}

	/**
	 * Richiama ricorsivamente la funzione searchAndDestroy dalla quale questa
	 * funzione è lanciata sull'opportuna cella e con gli opportuni parametri. Se
	 * l'ispezione del lato inferiore termina per qualche motivo, la funzione
	 * richiama searchAndDestroy segnalando il cambio di direzione tramite
	 * l'opportuno parametro
	 * 
	 * @param i                 Intero complessivo indicante sia la riga che la riga
	 *                          che la colonna della prima cella colpita di una nave
	 * @param riga              Intero indicante la riga della cella attuale
	 * @param colonna           Intero indicante la colonna della cella attuale
	 * @param c                 Intero indicante la posizione della prima colonna
	 *                          colpita di una nave
	 * @param caselleColpite    Intero delle caselle colpite di una nave
	 * @param checkColpito      Boolean che segnala se una cella è stata dichiarata
	 *                          colpita
	 * @param checkAffondato    Boolean che segnala se la nave è stata dichiarata
	 *                          affondata
	 * @param oppositeDirection Boolean che segnala se la direzione opposta a quella
	 *                          che si sta ispezionando è già stata ispezionata
	 * @param nodoList          Struttura contenente le informazioni sui nodi e
	 *                          sulle caselle adiacenti
	 */
	private void goDownDirection(final int i, final int riga, final int colonna, final int r,
			final boolean checkColpito, final boolean checkAffondato, final boolean oppositeDirection,
			ArrayList<Nodo> nodoList, List<Nave> naviNemicheList) {

		// Controlla se colonna+1 è nei limiti dell'array, se la cella (riga+1,
		// colonna) è libera e se la cella è stata valutata come colpita o
		// affondata
		if (riga + 1 < getRighe() && checkEmptyCell(riga + 1, colonna) && (checkColpito || checkAffondato)) {

			searchAndDestroy(i, riga + 1, colonna, oppositeDirection, nodoList, naviNemicheList);
		}
		// (riga+1, colonna) risulta non libera o colonna+1 esce dai limiti
		// dell'array

		// Controlla se c-1 è nei limiti dell'array, se cella(riga, c-1) è
		// libera e se la direzione opposta non è stata già ispezionata
		else {
			// oppositeDirection = true;

			if (r - 1 >= 0 && checkEmptyCell(r - 1, colonna) && !oppositeDirection) {
				searchAndDestroy(i, r - 1, colonna, true, nodoList, naviNemicheList);
			}
		}

	}

	/**
	 * Visualizza la griglia per la quale viene chiamata
	 */
	void getGriglia() {
		getGriglia(griglia);
	}

	/**
	 * Cambia il valore della cella di coordinate (r, c) in ASSEGANTO tranne se
	 * questa è impostata su COLPITO
	 * 
	 * @param r Intero indicante la riga della cella attuale
	 * @param c Intero indicante la colonna della cella attuale
	 */
	public void changeInAssigned(int r, int c) {
		if (griglia[r][c] != Casella.COLPITO)
			griglia[r][c] = Casella.ASSEGNATO;
	}

	/**
	 * Il metodo restituisce VERO se una nave è presente nella lista delle navi
	 * presenti in gioco; FALSO altrimenti
	 *
	 * @param nodoList Struttura contenente le informazioni sui nodi e sulle caselle
	 *                 adiacenti
	 * @param naviList Struttura contenente le informazioni sulla lista delle navi
	 *                 presenti in gioco
	 */
	public boolean avoidFalseSinking(ArrayList<Nodo> nodoList, List<Nave> naviList) {

		int maxShipDimension = naviList.get(0).getDimensione(); // Dimensione massima della nave
		int minShipDimension = naviList.get(naviList.size() - 1).getDimensione(); // Dimensione minima della nave
		boolean inDimension = (nodoList.size() >= minShipDimension && nodoList.size() <= maxShipDimension); // VERO se
																											// la nave è
																											// nelle
																											// dimensioni
																											// stabilite;
																											// Falso
																											// altrimenti
		boolean trovato = false;

		if (inDimension) {
			for (int i = 0; i < naviList.size() && !trovato; i++) {

				// Confronta la dimensione della nave affondata con la dimensione delle
				// navi presenti nella lista delle navi nemiche
				if (nodoList.size() == naviList.get(i).getDimensione()) {
					trovato = true;
				}
			}

			if (!trovato)
				System.out.println("Non esiste nessuna nave di dimensione!" + nodoList.size());

		} else {

			// Verifica se la nave è troppo grande o troppo piccola
			if (nodoList.size() < minShipDimension)
				System.out.println("Nave di dimensione " + nodoList.size() + " troppo piccola!");
			else
				System.out.println("Nave troppo grande di " + (nodoList.size() - maxShipDimension) + " elementi");
		}

		return (inDimension && trovato);
	}

	/**
	 * Il metodo prende in input una cella di partenza e le coordinate della riga e
	 * della colonna della posizione attuale. Successivamente viene verificato se
	 * una cella adiacente alla cella di partenza è libera a seconda delle
	 * condizioni che si realizzano
	 * 
	 * @param cella   Cella di nodoList da cui far partire il confronto
	 * @param riga    Intero indicante la coordinata riga della cella attuale
	 * @param colonna Intero indicante la coordinata colonna della cella attuale
	 * @return VERO se la cella esiste ed è possibile ispezionarla; FALSO altrimenti
	 */
	private boolean checkOppositeCell(Cella cella, int riga, int colonna) {
		boolean risultato;

		if (riga != cella.getRiga()) {

			if (cella.getRiga() > riga)
				risultato = checkEmptyCell(cella.getRiga() + 1, colonna);
			else
				risultato = checkEmptyCell(cella.getRiga() - 1, colonna);
		} else {

			if (cella.getColonna() > colonna)
				risultato = checkEmptyCell(riga, cella.getColonna() + 1);
			else
				risultato = checkEmptyCell(riga, cella.getColonna() - 1);
		}

		return risultato;
	}

	/**
	 * Il metodo prende in input una cella di partenza e le coordinate della riga e
	 * della colonnadella posizione attuale. Successivamente viene verificato se una
	 * cella adiacente alla posizione attuale è libera
	 * 
	 * @param cella   Cella di nodoList da cui far partire il confronto
	 * @param riga    Intero Indicante la coordinata riga della della cattuale
	 * @param colonna Intero indicante la coordinata colonna della cella attuale
	 * @return VERO se la cella esiste ed è ispezionabile; FALSO altrimenti
	 */
	private boolean checkNextCell(Cella cella, int riga, int colonna) {
		boolean risultato;

		if (riga != cella.getRiga()) {

			if (riga > cella.getRiga())
				risultato = checkEmptyCell(riga + 1, colonna);
			else
				risultato = checkEmptyCell(riga - 1, colonna);
		} else {

			if (colonna > cella.getColonna())
				risultato = checkEmptyCell(riga, colonna + 1);
			else
				risultato = checkEmptyCell(riga, colonna - 1);
		}

		return risultato;
	}

}