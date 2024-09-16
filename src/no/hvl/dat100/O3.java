package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class O3 {
	/*
	 * Lag et program som leser inn et heltall n > 0, beregner verdien n! (n
	 * fakultet) og skriver verdien til n! ut på skjermen, der n! = 1*2*3* …
	 * *(n-1)*n.
	 */
	public static void main(String[] args) {
		int n, produkt =0;
		String ntxt = showInputDialog("Oppgi heiltalsverdi for fakultet:"); //Input av verdi for n
		n = Integer.parseInt(ntxt); //Omgjøring (String til int)
		

		for (int i = 0; i < n; i++) {
			if(i==0) {
			produkt=(i+1);
			}else {
				produkt=produkt*(i+1);
			}
		}
		if (n>0) {
			System.out.println("Verdien av "+ntxt+"! er: "+produkt);	
		}else {
			System.out.println("");
		}
			
		
	}

}
