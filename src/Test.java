import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {

		final int righe = 10;
		final int colonne = 10;
		Griglia grigliaAttacco = new Griglia(righe, colonne);
		Input input = new Input();
		boolean validInputKeyboard = true;
		List<Nave> naviNemicheList = new ArrayList<>();

		// Creazione delle navi nemiche e immissione di queste in una lista
		// Le navi sono inserite dalla più grande alla più piccola
		naviNemicheList.add(new Nave(5));
		naviNemicheList.add(new Nave(4));
		naviNemicheList.add(new Nave(3));
		naviNemicheList.add(new Nave(3));
		naviNemicheList.add(new Nave(2));

		// Elenco del normale ordine di tutti gli spari che verranno effettuati
		for (int i = 0; i < grigliaAttacco.getRigheColonne(); i++) {
			grigliaAttacco.getRigaColonna(grigliaAttacco.getSparo(i));
		}
		
		int i = -1;
		
		// TEST
//		grigliaAttacco.setGriglia("A", 5);
//		grigliaAttacco.setGriglia("A", 12);
		i = 58;
		// FINE TEST

		while (validInputKeyboard && ++i < grigliaAttacco.getRigheColonne() && naviNemicheList.size() > 0) {
			// TEST
//			int sparo = grigliaAttacco.getSparo(i);
			int sparo = i;
			// FINE TEST
			
			// Se si sta attaccando in una cella vuota
			if (grigliaAttacco.checkEmptyCell(sparo)) {
				ArrayList<Nodo> nodoList = new ArrayList<Nodo>();
				Nodo nodo = new Nodo(new Cella(sparo / colonne, sparo % colonne));
				nodo.setNeighboursNodoes(sparo, grigliaAttacco);
				nodoList.add(nodo);

				// Controlla se c'è una direzione da esplorare in orizzontale o
				// verticale
				if (nodo.getHorizontalVertical().size() > 0) {
					System.out.println();
					grigliaAttacco.getRigaColonna(sparo);
					System.out.print("(" + (i + 1) + ") ");
					input.setInputTastiera();

					// Inserimento dello sparo nella sulla griglia
					if (input.checkColpito(input.getInputTastiera())) {
						grigliaAttacco.setGriglia(input.getInputTastiera(), sparo);
						grigliaAttacco.getGriglia();

						// Scelta casuale della direzione da andare a colpire tra
						// le celle libere
						Random random = new Random();

						// Ripete l'estrazione di una direzione random fino a
						// quando la dimensione di nodoList == 1, quindi c'è
						// un solo nodo nella lista, e la dimensione di horizontalVertical
						// è > 0 e quindi c'è una direzione orizontale o verticale
						// da esplorare
						while (nodoList.size() == 1 && nodoList.get(0).getHorizontalVertical().size() > 0) {
							int randomNumber = random.nextInt(nodo.getHorizontalVertical().size());
							int riga = nodo.getHorizontalVertical().get(randomNumber).getRiga();
							int colonna = nodo.getHorizontalVertical().get(randomNumber).getColonna();
							grigliaAttacco.searchAndDestroy(sparo, riga, colonna, false, nodoList, naviNemicheList);
						}

						// Se il nodo non ha vicini orizzontali o verticali liberi,
						// va impostato come assegnato
						if (nodoList.get(0).getHorizontalVertical().size() == 0) {
							grigliaAttacco.changeInAssigned(sparo / colonne, sparo % colonne);
						}
					} else {
						// se è AFFONDATO ripetere la casella perché una nave non può essere affondata
						// al primo colpo
						if (input.checkAffondato(input.getInputTastiera())) {
							System.out.println("Una nave non può essere affondata al primo colpo");
							System.out.println("Reinserire la scelta");
							i--;
						} else // Il colpo è stato valutato come ACQUA
							grigliaAttacco.setGriglia(input.getInputTastiera(), sparo);
					}
				}
			}
			// Se la cella non ha vicini liberi, la casella deve essere impostata come
			// ASSEGANTA
			else {
				grigliaAttacco.setAssigned(sparo / colonne, sparo % colonne);
			}

			grigliaAttacco.getGriglia();
		}

	}
}