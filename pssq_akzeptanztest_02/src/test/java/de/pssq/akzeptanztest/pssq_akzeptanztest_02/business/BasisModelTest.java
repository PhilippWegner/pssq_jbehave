package de.pssq.akzeptanztest.pssq_akzeptanztest_02.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

class BasisModelTest {

	private BasisModel basisModel;

	@BeforeEach
	void setUp() throws Exception {
		this.basisModel = BasisModel.getInstance();
		this.basisModel.getArtikelListe().clear();

		Artikel artikel1 = new Artikel(1, "Zelt", 10, 150.00);
		this.basisModel.fuegeArtikelHinzu(artikel1);
		Artikel artikel2 = new Artikel(2, "Wanderhose", 25, 45.50);
		this.basisModel.fuegeArtikelHinzu(artikel2);
		Artikel artikel3 = new Artikel(3, "Seil", 10, 25.35);
		this.basisModel.fuegeArtikelHinzu(artikel3);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.basisModel.getArtikelListe().clear();
		this.basisModel = null;
		assertNull(this.basisModel);
	}

	@Test
	void testFuegeArtikelHinzu() {
		assertTrue(() -> this.basisModel.getArtikelListe().size() == 3, 
				"Die ArtikelListe hat nicht die Länge 3.");
	}

	@Test
	void testLoescheArtikel() {
		Artikel artikel4 = new Artikel(1, "Trekkingschuhe", 23, 65.00);
		this.basisModel.fuegeArtikelHinzu(artikel4);
		Artikel artikel5 = new Artikel(2, "Gummistiefel", 7, 9.50);
		this.basisModel.fuegeArtikelHinzu(artikel5);
		Artikel artikel6 = new Artikel(3, "Rucksack", 10, 35.70);
		this.basisModel.fuegeArtikelHinzu(artikel6);

		this.basisModel.loescheArtikel(artikel5);
		this.basisModel.loescheArtikel(artikel6);

		assertTrue(() -> this.basisModel.getArtikelListe().size() == 4, 
				"Die ArtikelListe hat nicht die Länge 4.");
	}

	@Test
	void testSetArtikelListe() {
		ObservableList<Artikel> artikelListe = FXCollections.observableArrayList();
		Artikel artikel1 = new Artikel(10, "Karabiner", 62, 150.00);
		artikelListe.add(artikel1);
		Artikel artikel2 = new Artikel(11, "7/8 Hose", 36, 31.95);
		artikelListe.add(artikel2);
		Artikel artikel3 = new Artikel(12, "Holzfällerhemd", 17, 34.15);
		artikelListe.add(artikel3);

		this.basisModel.setArtikelListe(artikelListe);
		assertTrue(() -> this.basisModel.getArtikelListe().get(1).getBezeichnung().equals("7/8 Hose"),
				"Das Element an der Position 1 hat nicht die Bezeichnung \"7/8 Hose\".");
	}
}
