package de.pssq.akzeptanztest.pssq_akzeptanztest_03.business;

public class Artikel {
	private int artikelID;
	private String bezeichnung;
	private int lagerbestand;
	private double preis;

	public Artikel(int artikelID, String bezeichnung, int lagerbestand, double preis) {
		this.artikelID = artikelID;
		this.bezeichnung = bezeichnung;
		this.lagerbestand = lagerbestand;
		this.preis = preis;
	}

	public Artikel() {

	}

	public int getArtikelID() {
		return artikelID;
	}

	public void setArtikelID(int artikelID) {
		this.artikelID = artikelID;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getLagerbestand() {
		return lagerbestand;
	}

	public void setLagerbestand(int lagerbestand) {
		this.lagerbestand = lagerbestand;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	@Override
	public String toString() {
		String output_string = "ArtikelID: " + this.artikelID + "\n" + "Bezeichnung: " + this.bezeichnung + "\n"
				+ "Lagerbestand: " + this.lagerbestand + "\n" + "Preis: " + this.preis;
		return output_string;
	}

}
