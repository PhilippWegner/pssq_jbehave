package de.pssq.akzeptanztest.pssq_akzeptanztest_02.business;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("restriction")
public class BasisModel {

	private static BasisModel basisModel;
	private ObservableList<Artikel> artikelListe = FXCollections.observableArrayList();

	public static BasisModel getInstance() {
		if (basisModel == null) {
			basisModel = new BasisModel();
		}
		return basisModel;
	}

	private BasisModel() {
	}

	public void fuegeArtikelHinzu(Artikel artikel) {
		this.artikelListe.add(artikel);
	}

	public void loescheArtikel(Artikel artikel) {
		this.artikelListe.remove(artikel);
	}

	public ObservableList<Artikel> getArtikelListe() {
		return this.artikelListe;
	}

	public void setArtikelListe(ObservableList<Artikel> artikelListe) {
		this.artikelListe = artikelListe;
	}
}
