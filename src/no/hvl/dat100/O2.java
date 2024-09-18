package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Math.*;

public class O2 {

	/*TRINNSKATT
	 * Dette programmet tar inn bruttoinntekt, og skriv ut kva ein skal betale i skatt i henhold til kva 
	 * skattesats bruttoinntekt bruker skriver inn tilhører.
	 * Trinnene er definert for:
	 * Ingen (0 - 208 050), trinn 1 (208 051 - 292 850)(1,7 % skatt), trinn 2 (292 851 - 670 000)(4,0 % skatt), 
	 * trinn 3 (670 001 – 937 900)(13,6 % skatt), trinn 4 (937 901 – 1 350 000)(16,6 % skatt) 
	 * og trinn 5 (frå og med 1 350 001)(17,6 % skatt). 
	 * Skattebeløpet samt trinn blir oppgitt i konsollen, saman med innverdien.
	 */
	public static void main(String[] args) {
		int inntekt, skatt = 0; // initierer verdiar som brukas seinare
		String inntxt = showInputDialog("Bruttoinntekt: \n(i heiltall)"); // input frå brukar
		inntekt = Integer.parseInt(inntxt); // omgjøring til heiltal
		String trinn = "Feil";

		if (inntekt >= 0 && inntekt < t[0]) { //dersom input ikkje skal ha trinnskatt
			skatt = 0;
			trinn = "ingen";
		} else if (inntekt >= t[0] && inntekt < t[1]) { //Ved trinn 1
			skatt = trinnskatt(inntekt - t[0], tp[0]);
			trinn = "Trinn 1";
		} else if (inntekt >= t[1] && inntekt < t[2]) { //Ved trinn 2
			skatt = t1() + trinnskatt(inntekt - t[1], tp[1]);
			trinn = "Trinn 2";
		} else if (inntekt >= t[2] && inntekt < t[3]) { // Ved trinn 3
			skatt = t1() + t2() + trinnskatt(inntekt - t[2], tp[2]);
			trinn = "Trinn 3";
		} else if (inntekt >= t[3] && inntekt < t[4]) { //Ved trinn 4
			skatt = t1() + t2() + t3() + trinnskatt(inntekt - t[3], tp[3]);
			trinn = "Trinn 4";
		} else if (inntekt >= t[4]) { //Ved trinn 5
			skatt = t1() + t2() + t3() + t4() + trinnskatt(inntekt - t[4], tp[4]);
			trinn = "Trinn 5";
		}
		skatt = skatt / 1000; //omgjør tall til heltall 
		if (skatt == 0) { //Spesiell tekst for ingen skatt
			System.out.println("Sidan du har " + inntekt
					+ " kr i bruttoinntekt, har du ingen trinnskatt. \nDu skal derfor ikkje betale noko i skatt.");
		}else if(trinn.equals("Feil")){ //Dersom det er blitt oppgitt eit negativt tal
			System.out.println("Det har oppstått ein feil");
		}
		else {//tekst som oppgir inntekt, trinn, og trinnskatt
			System.out.println("Sidan du har " + inntekt + " kr i bruttoinntekt, havner du på " + trinn + ".");
			System.out.println("Du skal betale " + skatt + " kr* i trinnskatt.\n*Desimaler er fjernet");
		}
	}

	private static int trinnskatt(int iot, int prosent) { //Rekning av prosentsats (svar avgitt som int der dei tre siste siffer egentleg er desimaltal)
		int s = iot * prosent;
		return s;
	}

	private static int[] t = { 208051, 292851, 670001, 937901, 1350001 // sluttverdier trinnskatt
	};
	private static int[] tp = { 17, 40, 136, 166, 176 // prosentsatser
	};

	private static int t1() {
		int s = trinnskatt(t[1] - t[0], tp[0]); //totalsats for trinn 1
		return s;
	}

	private static int t2() {
		int s = trinnskatt(t[2] - t[1], tp[1]); //totalsats for trinn 2
		return s;
	}

	private static int t3() {
		int s = trinnskatt(t[3] - t[2], tp[2]); //totalsats for trinn 3
		return s;
	}

	private static int t4() {
		int s = trinnskatt(t[4] - t[3], tp[3]); //totalsats for trinn 4
		return s;
	}
}
