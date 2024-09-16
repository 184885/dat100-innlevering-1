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
	 * Skattebeløpet samt skatteprosent blir oppgitt i konsollen, saman med innverdien.
	 */
	public static void main(String[] args) {
		int inntekt, skatt=0 ; //initierer verdiar som brukas seinare
		int t0 = 208050, t1 = 292850, t2 = 670000, t3 = 937900, t4 = 1350000; // sluttverdier trinnskatt
		double tp1 = 0.017, tp2 = 0.04, tp3 = 0.136, tp4 = 0.166, tp5 = 0.176; // prosentsatser
		
		
			String inntxt = showInputDialog("Bruttoinntekt: "); //input frå brukar
			inntekt = Integer.parseInt(inntxt); //omgjøring til heiltal
			String trinn = "Feil"; //Initierer verdi (bruker feil for feilsøking)
		/*Her sjekkes verdien for inntekt mot dei ulike skattetrinna, 
		 * og definerer uttekst etter kva trinn ein havner på
		 */
		if (inntekt >= 0 && inntekt <= t0) { // Ingen trinnskatt
			skatt = 0;
			trinn = "ingen";
		} else if (inntekt > t0 && inntekt <= t1) { // Trinn 1
			skatt = skattrekning(inntekt, tp1);
			trinn = ("1,7 %");
		} else if (inntekt > t1 && inntekt <= t2) { // Trinn 2
			skatt = skattrekning(inntekt, tp2);
			trinn = ("4,0 %");
		} else if (inntekt > t2 && inntekt <= t3) { // Trinn 3
			skatt = skattrekning(inntekt, tp3);
			trinn = ("13,6 %");
		} else if (inntekt > t3 && inntekt <= t4) { // Trinn 4
			skatt = skattrekning(inntekt, tp4);
			trinn = ("16,6 %");
		} else if (inntekt > t4) { // Trinn 5
			skatt = skattrekning(inntekt, tp5);
			trinn = ("17,6 %");
		}

		System.out.println("Sidan du har " + inntekt + " kr i bruttoinntekt, skal du betale " + trinn + " skatt.");
		System.out.println("Du skal betale " + skatt + " kr i trinnskatt.\n*Rundet til nærmeste heiltal");
		
		
	}
	//oppretter ein eigen metode for sjølve utrekninga (dette var ikkje nødvendig, men lettare å feilsøke)
	private static int skattrekning(int inntekt, double prosent) {
		int skatt;
		double s;
		s = inntekt * prosent;
		skatt = round((float) s); 
		/*Såg på BigDecimal for å prøve å begrense til to desimaler, men fann ut det blei litt komplisert.
		*Endte derfor opp med å avrunde tallet til nærmaste heiltal*/
		return skatt;

	}

}
