package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class O1 {

	/* KARAKTERSKALA
	 * Dette programmet tar n antall poengsummer (mellom 0 og 100) og gir ut tilsvarande 
	 * karakter for poengsummen. 
	 * Karakterane er definert som: A (100-90), B (89-80), C (79-60), D (59-50), E (49-40) og F (39 -0)
	 * Karakteren blir oppgitt både i eit dialogvindu, og nede i konsollen.
	*/
	public static void main(String[] args) {

		String kar;
		int  n = 10; //Antall innskrivinger
		int gyldigopp = 100, gyldigned = 0, poeng; //Definerer øvre og nedre grense for poeng, samt initierer verdien for poeng
		for (int i = 0; i < n; i++) { // Løkke for å kunne skrive inn fleire antall poengsummer og få oppgitt karakter.

			String poengtxt = showInputDialog("Poengsum student: "); //Input av poengsum 
			poeng = Integer.parseInt(poengtxt); //omgjøring av poeng (String til int)
			if (poeng >= gyldigned && poeng <= gyldigopp) { // Sjekker at verdien er gyldig
				int p = poeng / 10; // omgjør poengsum slik at dei fleste verdiane berre vil ha 1 verdi 
				//(omgjør seinare for verdiar som blir unntatt her)
				
				// p verdier skal være 9,8,6,5,4 og mindre enn 4
				
				if (p == 10) { // samler verdiane for A til eit tal
					p = 9;
				}
				if (p == 7) { // samler verdiane for C til eit tal
					p = 6;
				}
				switch (p) { // Setter karakter utifrå innlest verdi
				case 9:
					kar = "A";
					break;
				case 8:
					kar = "B";
					break;
				case 6:
					kar = "C";
					break;
				case 5:
					kar = "D";
					break;
				case 4:
					kar = "E";
					break;
				default: //Sidan resten av verdiane blir tatt hand om i dei andre tilfella og verdiområdet er definert for 0-100 så må resterande poeng utgi karakteren F
					kar = "F";
				}
				showMessageDialog(null, poengtxt + " poeng tilsvarer karakteren:\n" + kar); //Opnar eit dialogvindu med oppgitt poeng og tilsvarande karakter
				System.out.println(poengtxt + " poeng tilsvarer karakteren: " + kar); //Skriv ut oppgitt poeng og tilsvarande karakter i konsollen

			} else { //tilfelle for om oppgitt tal ikkje er innanfor definisjonsområdet (0-100)
				showMessageDialog(null, "Poengsummen "+ poeng+ " er ugyldig. \nPoeng skal vere innanfor mengden {0, 1,..,100} \nPrøv på nytt");
				 i = i - 1; //sørger for at ein ikkje mister ein innlesning av antall gonger n

			}
		}
	}
}
