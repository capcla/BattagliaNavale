import java.util.Random;
import java.util.ArrayList;

class Griglia {

	private int righe;
	private int colonne;
	private int righeColonne;
	private int spazioTraCaratteri;
	private Casella griglia[][];
	private int sparo[];
	private int minRiga = 0;
	private int minColonna = 0;

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
						System.out.printf("%" + getSpazio() + 'c', +getCharCasella(griglia, i - 1, j - 1));

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
	public void getRigaColonna(final int i) {
		final int q = i / getColonne();
		final int r = i % getColonne();

		System.out.println(
				"(" + i + "), " + (q + 1) + "(" + q + "), " + getCharFromInt(r + getIntFromChar('A')) + "(" + r + ")");
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

	// Restituisce lo spazio che deve esserci tra i caratteri della griglia
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
	 * 
	 * 
	 * @param nodoList
	 */
	public void setGriglia(ArrayList<Nodo> nodoList) {
			
		for (int i = 0; i < nodoList.size(); i++) {
			
			for (int j = 0; j < nodoList.size(); j++) {
				int r = nodoList.get(i).getDiagonals().get(j).getRiga();
				int c = nodoList.get(i).getDiagonals().get(j).getColonna();
				griglia[r][c] = nodoList.get(i).getDiagonals().get(j).getValue();
			}
		}
		
	}

	/**
	 * Dato il valore dello sparo vengono calcolate le coordinate della cella di
	 * riferimento, viene creato un oggetto freePosition per memorizzare la
	 * posizione delle celle adiacenti orizzontali e verticali libere rispetto a
	 * quella colpita e viene impostato lo stato ASSEGNATO alle caselle libere
	 * adiacenti diagonali
	 * 
	 * @param i intero complessivo che indica i valori riga e colonna di una
	 *          determinata cella
	 * @return restituisce un oggetto FreePosition contenente le informazioni
	 *         relative alle celle libere adiacenti di una cella colpita
	 */
	/*
	 * public ArrayList<FreePosition> getFreeNearPosition(final int i) {
	 * 
	 * final int r = i / getColonne(); final int c = i % getColonne();
	 * 
	 * ArrayList<FreePosition> freePosition = new ArrayList<FreePosition>(); //
	 * Random random = new Random();
	 * 
	 * for (int riga = r - 1; riga <= r + 1; riga++) {
	 * 
	 * // Controlla se gli iteratori sono compresi nei valori validi delle // righe
	 * if ((riga >= 0) && (riga <= getRighe() - 1)) {
	 * 
	 * for (int colonna = c - 1; colonna <= c + 1; colonna++) {
	 * 
	 * // Controlla se gli iteratori sono compresi nei valori // validi delle
	 * colonne e se la cella indicata dagli // iteratori è vuota if ((colonna >= 0)
	 * && (colonna <= getColonne() - 1) && (checkEmptyCell(riga, colonna))) {
	 * 
	 * // Le due condizione devono verificarsi in maniera // esclusiva per
	 * aggiungere, alle caselle libere, solo // le celle orizzontali e verticali
	 * adiacenti alla cella // (r,c) if ((riga == r) ^ (colonna == c))
	 * freePosition.add(new FreePosition(riga, colonna));
	 * 
	 * // Imposta lo stato in ASSEGANTO alle celle diagonali // adiacenti rispetto
	 * alla cella se questa è vuota(r,c) else setAssigned(riga, colonna); } } } }
	 * 
	 * // DEBUG // getGriglia(griglia);
	 * 
	 * return freePosition; /* if(freePosition.size() > 0){ //Scelta casuale della
	 * direzione da andare a colpire tra le celle //libere int randomNumber =
	 * random.nextInt(freePosition.size());
	 * 
	 * int riga = freePosition.get(randomNumber).getRiga(); int colonna =
	 * freePosition.get(randomNumber).getColonna(); searchAndDestroy(r, c, riga,
	 * colonna, false); }
	 *
	 * }
	 */

	/**
	 * Assegna il vaolore ASSEGNATO ad una determinata cella di coordinate (r, c)
	 * 
	 * @param r Intero indicante la coordinata riga della cella attuale
	 * @param c Intero indicante la coordianta colonna della cella attuale
	 */
	public void setAssigned(int r, int c) {

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
	private char getCharCasella(Casella g[][], int r, int c) {
		char ris = ' ';

		switch (g[r][c]) {
		/*
		 * case VUOTO: ris = ' '; break;
		 */

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
	}

	/**
	 * Restituisce lo stato di una casella di coordinare (r, c)
	 * 
	 * @param r Intero indicante il valore riga di una cella
	 * @param c Intero indicante il valore colonna di una cella
	 * @return Stato della casella di coordinate (r, c)
	 */
	public Casella getCasella(int r, int c) {
		return griglia[r][c];
	}

	/**
	 * Controlla se una cella è vuota
	 * 
	 * @param i Intero complessivo indicante la riga e la colonna di una cella
	 * @return Restituisce VERO se la cella(r,c) è vuota; FALSO altrimenti
	 */
	public boolean checkEmptyCell(final int i) {
		final int r = i / getColonne();
		final int c = i % getColonne();

		return griglia[r][c] == Casella.VUOTO;
	}

	/**
	 * Controlla se una cella è vuota
	 * 
	 * @param r Intero indicante il valore colonna di una cella
	 * @param c Intero indicante il valore riga di una cella
	 * @return Restituisce VERO se la cella(r,c) è vuota; FALSO altrimenti
	 */
	public boolean checkEmptyCell(int r, int c) {

		return griglia[r][c] == Casella.VUOTO;
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
	 * @param caselleColpite
	 * @param caselleColpite    Intero che indica quante sono le caselle colpite di
	 *                          una nave
	 * @param nodoList
	 */
	public void searchAndDestroyOnRow(final int i, final int riga, final int colonna, boolean oppositeDirection,
			int caselleColpite, ArrayList<Nodo> nodoList) {

		Input input = new Input();
		String inputKeyboard;
		boolean validInputKeyboard, checkColpito = false, checkAffondato = false;
		// final int r = i / getColonne();
		final int c = i % getColonne();
		boolean quit = false;
		Nodo nodo;

		// Chiede all'utente conferma del colpo
		do {
			getRigaColonna(riga * getColonne() + colonna);
			System.out.print("Inserisci il report dello sparo\n(A)cqua, " + "(C)olpito, a(F)fondato: ");
			input.setInputTastiera();
			inputKeyboard = input.getInputTastiera();
			validInputKeyboard = input.checkStringFormat(inputKeyboard);

			if (validInputKeyboard == false)
				System.out.println("Valore inserito errato");
			else {
				setGriglia(inputKeyboard, riga * getColonne() + colonna);
				checkColpito = input.checkColpito(inputKeyboard);
				checkAffondato = input.checkAffondato(inputKeyboard);

				// Controlla se la nava è stata colpita o affondata
				if (checkColpito || checkAffondato) {

					// Crea un nuovo nodo, ne setta i vicini e lo aggiunge alla
					// lista dei nodi
					nodo = new Nodo(new Cella(riga, colonna));
					nodo.setNodosNeighbours(riga * getColonne() + colonna, this);
					nodoList.add(nodo);

					// Se la nave è dichiarata affondata, vengono imposati i limiti
					// della nave
					if (checkAffondato) {
						//checkAndSetRowLimits(riga, colonna, c, nodoList.size());
						setShipLimits(nodoList);
						setGriglia(nodoList);
					}
				} else if (oppositeDirection) {

					quit = true;

					// Dialogo con l'utente o cambio della scelta
					if (nodoList.size() == 1) {
						setAssigned(i / getColonne(), c);
					} else {

					}

				}
			}

		} while (!validInputKeyboard);

		getGriglia(griglia);

		if (!quit) {

			// Verifica se si deve ispezionare il lato destro (colonna > c) o il sinistro
			// (colonna < c) della nave. Il valore colonna indica il valore colonna
			// della cella attuale mentre c indica il valore della colonna della
			// prima cella colpita
			if (colonna > c)
				goRightDirection(i, riga, colonna, c, nodoList.size(), checkColpito, checkAffondato, oppositeDirection,
						nodoList);
			else
				goLeftDirection(i, riga, colonna, c, nodoList.size(), checkColpito, checkAffondato, oppositeDirection,
						nodoList);
		}

		if (griglia[riga][colonna] != Casella.COLPITO && (oppositeDirection || nodoList.size() == 1)) {
			// Dialogo con l'utente o cambio della scelta
			setAssigned(i / getColonne(), c);
			getGriglia();
		}

	}

	/**
	 * Prende in input l'array list nodoList e setta tutte le celle adiacenti alla
	 * nave con il valore ASSEGNATO se queste sono vuote
	 * 
	 * @param nodoList Struttura contenente le informazioni sui nodi e sulle caselle adiacenti
	 */

	private void setShipLimits(ArrayList<Nodo> nodoList) {
		int minRiga = getRighe();
		int minColonna = getColonne();
		int maxRiga = 0;
		int maxColonna = 0;
		
		// Controlla tutti i nodi di nodoList
		for (int i = 0; i < nodoList.size(); i++) {
			
			// Ricerca del valore minimo delle coordinate riga e colonna e ne calcola 
			// il massimo
			if (nodoList.get(i).getCella().getRiga() < minRiga || nodoList.get(i).getCella().getColonna() < minColonna) {
				minRiga = nodoList.get(i).getCella().getRiga();
				minColonna = nodoList.get(i).getCella().getColonna();
				maxRiga = minRiga + nodoList.size();
				maxColonna = minColonna + nodoList.size();
			}
			
			//setAssigned(nodoList.get(i).getCella().getRiga(), nodoList.get(i).getCella().getColonna());
				
			// Controlla tutti i diagonali di un nodo
			for (int j = 0; j < nodoList.get(i).getDiagonals().size(); j++)

				// Controlla che il valore di un nodo diagonale sia vuoto
				if (nodoList.get(i).getDiagonals().get(j).getValue() == Casella.VUOTO) {
					nodoList.get(i).getDiagonals().get(j).setValue(Casella.ASSEGNATO);
				}	
		}
		
		// Controllo che minRiga e minColonna siano nei margini della griglia e che 
		// la casella da loro indicata sia vuota
		if (minRiga-1  >= 0 && minColonna-1 >= 0 && checkEmptyCell(minRiga, minColonna)) {
			setAssigned(minRiga-1, minColonna-1);
		}
				
		// Controllo che maxRiga e maxColonna siano nei margini della griglia e che 
		// la casella da loro indicata sia vuota
		if (maxRiga < getRighe() && maxColonna < getColonne() && checkEmptyCell(maxRiga, maxColonna)) {
			setAssigned(minRiga, minColonna);
		}
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
	 * @param i                 intero complessivo indicante sia la riga che la
	 *                          colonna della prima cella colpita di una nave
	 * @param riga              intero indicante la riga della cella che si sta
	 *                          ispezionando
	 * @param colonna           intero indicante la colonna della cella che si sta
	 *                          ispezionando
	 * @param oppositeDirection boolean che segnala se la direzione opposta a quella
	 *                          che si sta ispezionando è già stata ispezionata
	 * @param caselleColpite    intero che indica quante sono le caselle colpite di
	 *                          una nave
	 */
	public void searchAndDestroyOnColumn(final int i, final int riga, final int colonna, boolean oppositeDirection,
			int caselleColpite) {

		Input input = new Input();
		String inputKeyboard;
		boolean validInputKeyboard, checkColpito = false, checkAffondato = false;
		final int r = i / getColonne();
		boolean quit = false;

		// Chiede all'utente conferma del colpo
		do {
			getRigaColonna(riga * getColonne() + colonna);
			System.out.print("Inserisci il report dello sparo\n(A)cqua, " + "(C)olpito, a(F)fondato: ");
			input.setInputTastiera();
			inputKeyboard = input.getInputTastiera();
			validInputKeyboard = input.checkStringFormat(inputKeyboard);

			if (validInputKeyboard == false)
				System.out.println("Valore inserito errato");
			else {
				setGriglia(inputKeyboard, riga * getColonne() + colonna);
				checkColpito = input.checkColpito(inputKeyboard);
				checkAffondato = input.checkAffondato(inputKeyboard);

				if (checkColpito || checkAffondato) {
					// imposta le caselle diagonali di una cella(riga, colonna)
					// su ASSEGNATO
					caselleColpite++;
					searchAndSetDiagonals(riga, colonna);

					if (checkAffondato) {
						checkAndSetRowLimits(riga, colonna, r, caselleColpite);
					}
				}
			}

		} while (!validInputKeyboard);

//		if (!quit) {

		// Verifica se si deve ispezionare il lato superiore (riga > r) o inferiore
		// (riga < r) della nave. Il valore riga indica il valore della riga della
		// cella attuale mentre r indica il valore della riga della prima cella
		// colpita
		if (riga > r)
			goUpDirection(i, riga, colonna, r, caselleColpite, checkColpito, checkAffondato, oppositeDirection);
		else
			goDownDirection(i, riga, colonna, r, caselleColpite, checkColpito, checkAffondato, oppositeDirection);
//		}

	}

	/**
	 * Quando una nave è dichiarata affondata, richiama una funzione che imposti le
	 * celle adiacenti orizzontali confinanti ad una nave
	 * 
	 * @param riga           intero indicante la coordinata riga di una cella
	 * @param colonna        intero indicante la coordinata della colonna attuale di
	 *                       una cella
	 * @param c              intero posizione della colonna della prima cella in cui
	 *                       si è scoperta la nave
	 * @param caselleColpite intero indica quante caselle di una nave sono state
	 *                       colpite
	 */
	private void checkAndSetRowLimits(final int riga, final int colonna, final int c, final int caselleColpite) {

		if (colonna > c) {
			setAdjacentCells(riga, colonna + 1);
			setAdjacentCells(riga, colonna - caselleColpite);
		} else {
			setAdjacentCells(riga, colonna - 1);
			setAdjacentCells(riga, colonna + caselleColpite);
		}

		getGriglia();
	}

	/**
	 * Quando una nave è dichiarata affondata, richiama una funzione che imposti le
	 * celle adiacenti verticali confinanti ad una nave
	 * 
	 * @param riga           intero indicante la coordinata riga di una cella
	 * @param colonna        intero indicante la coordinata della colonna attuale di
	 *                       una cella
	 * @param r              intero posizione della riga della prima cella in cui si
	 *                       è scoperta la nave
	 * @param caselleColpite intero indica quante caselle di una nave sono state
	 *                       colpite
	 */
	private void checkAndSetColumnLimits(final int riga, final int colonna, final int r, final int caselleColpite) {

		if (riga > r) {
			setAdjacentCells(riga + 1, colonna);
			setAdjacentCells(riga - caselleColpite, colonna);
		} else {
			setAdjacentCells(riga - 1, colonna);
			setAdjacentCells(riga + caselleColpite, colonna);
		}

		getGriglia();
	}

	/**
	 * Controlla che la coordinata colonna sia nei limiti della griglia e che la
	 * cella(riga, colonna) sia vuota per richiamare la funzione che imposterà la
	 * cella su ASSEGNATO
	 * 
	 * @param riga    intero parametro riga della cella
	 * @param colonna intero parametro colonna della riga
	 */
	private void setAdjacentCells(final int riga, final int colonna) {
		if (colonna >= 0 && colonna < getColonne() && checkEmptyCell(riga, colonna)) {
			setAssigned(riga, colonna);
		}
	}

	/**
	 * Ricerca le diagonali di una determinata cella (r, c) e, nel caso sono libere,
	 * imposta il loro valore su ASSEGNATO
	 * 
	 * @param r intero indicante la riga della cella
	 * @param c intero indicante la colonna della cella
	 */
	private void searchAndSetDiagonals(final int r, final int c) {

		for (int riga = r - 1; riga <= r + 1; riga++) {

			// Controlla se gli iteratori sono compresi nei valori validi delle
			// righe
			if (riga >= 0 && riga < getRighe()) {

				for (int colonna = c - 1; colonna <= c + 1; colonna++) {

					// Controlla se gli iteratori sono compresi nei valori
					// validi delle colonne e se la cella indicata dagli
					// iteratori è vuota
					if (colonna >= 0 && colonna < getColonne() && (checkEmptyCell(riga, colonna))) {

						// Controlla se gli iteratori sono in diagonale rispetto
						// agli indici della cella
						if ((riga != r) && (colonna != c))
							setAssigned(riga, colonna);
					}
				}
			}
		}
	}

	/**
	 * Richiama ricorsivamente la funzione searchAndDestroyOnRow dalla quale questa
	 * funzione è lanciata sull'opportune cella e con gli opportuni parametri. Se
	 * l'ispezione del lato destro termina per qualche motivo, la funzione richiama
	 * searchAndDestroyOnRow segnalando il cambio di direzione tramite l'opportuno
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
	 * @param nodoList
	 */
	private void goRightDirection(final int i, final int riga, final int colonna, final int c, final int caselleColpite,
			final boolean checkColpito, final boolean checkAffondato, boolean oppositeDirection,
			ArrayList<Nodo> nodoList) {

		// Controlla se colonna+1 è nei limiti dell'array, se la cella
		// (riga, colonna+1) è libera e se la cella è stata valutata come colpita o
		// affondata
		if (colonna + 1 < getColonne() && checkEmptyCell(riga, colonna + 1) && (checkColpito || checkAffondato)) {

			searchAndDestroyOnRow(i, riga, colonna + 1, oppositeDirection, caselleColpite, nodoList);
		}
		// (riga, colonna+1) risulta non libera o colonna+1 esce dai limiti
		// dell'array

		// Controlla se c-1 è nei limiti dell'array, se cella(riga, c-1) è
		// libera e se la direzione opposta non è stata già ispezionata
		else {
//			oppositeDirection = true;

			if (c - 1 >= 0 && checkEmptyCell(riga, c - 1) && !oppositeDirection) {
				searchAndDestroyOnRow(i, riga, c - 1, true, caselleColpite, nodoList);
			}
		}
	}

	/**
	 * Richiama ricorsivamente la funzione searchAndDestroyOnRow dalla quale questa
	 * funzione è lanciata sull'opportune cella e con gli opportuni parametri. Se
	 * l'ispezione del lato sinistro termina per qualche motivo, la funzione
	 * richiama searchAndDestroyOnRow segnalando il cambio di direzione tramite
	 * l'opportuno parametro
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
	 * @param nodoList
	 */
	private void goLeftDirection(final int i, final int riga, final int colonna, final int c, final int caselleColpite,
			final boolean checkColpito, final boolean checkAffondato, boolean oppositeDirection,
			ArrayList<Nodo> nodoList) {

		// Controlla se colonna-1 è nei limiti della griglia, se la cella(riga,
		// colonna-1) è libera e se la cella è stata valutata come colpita
		// o affondata
		if (colonna - 1 >= 0 && checkEmptyCell(riga, colonna - 1) && (checkColpito || checkAffondato))
			searchAndDestroyOnRow(i, riga, colonna - 1, oppositeDirection, caselleColpite, nodoList);

		// (riga, colonna-1) risulta non libera o colonna-1 esce dai limiti
		// dell'array o il valore immesso non indica COLPITO

		// Controlla se c+1 è nei limiti della griglia, se (riga, c+1) è libera
		// e se la direzione opposta è stata ispezionata
		else {
//			oppositeDirection = true;

			if (c + 1 < getColonne() && checkEmptyCell(riga, c + 1) && !oppositeDirection)
				searchAndDestroyOnRow(i, riga, c + 1, true, caselleColpite, nodoList);
		}
	}

	private void goUpDirection(final int i, final int riga, final int colonna, final int r, final int caselleColpite,
			final boolean checkColpito, final boolean checkAffondato, final boolean oppositeDirection) {

	}

	private void goDownDirection(final int i, final int riga, final int colonna, final int r, final int caselleColpite,
			final boolean checkColpito, final boolean checkAffondato, final boolean oppositeDirection) {

	}

	/**
	 * Visualizza la griglia per la quale viene chiamata
	 */
	void getGriglia() {
		getGriglia(griglia);
	}
}