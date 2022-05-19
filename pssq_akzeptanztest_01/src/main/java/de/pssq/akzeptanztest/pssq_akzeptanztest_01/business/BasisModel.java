package de.pssq.akzeptanztest.pssq_akzeptanztest_01.business;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BasisModel {

	private static BasisModel basisModel;

	public static BasisModel getInstance() {
		if (basisModel == null) {
			basisModel = new BasisModel();
		}
		return basisModel;
	}

	private BasisModel() {}
	
	private ObservableList<Artikel> artikelListe = FXCollections.observableArrayList();

	public void fuegeArtikelHinzu(Artikel artikel) {
		this.artikelListe.add(artikel);
	}
	
	public void loescheArtikel(Artikel artikel) {
		this.artikelListe.remove(artikel);
	}
	
	public ObservableList<Artikel> getArtikelListe() {
		return artikelListe;
	}

	public void setArtikelListe(ObservableList<Artikel> artikelListe) {
		this.artikelListe = artikelListe;
	} 
	
	
}
