package de.pssq.akzeptanztest.pssq_akzeptanztest_02.gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasisControlTest {

	private BasisControl basisControl;
	
	@BeforeEach
	void setUp() throws Exception {
		this.basisControl = new BasisControl();
		this.basisControl.getArtikelListe().clear();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.basisControl.getArtikelListe().clear();
		this.basisControl = null;
		assertNull(this.basisControl);
	}

	@Test
	void testAddArtikelRichtigeEingaben() {
		this.basisControl.addArtikel("1", "Zelt", "85", "49.50");
		assertTrue(() -> this.basisControl.getArtikelListe().size() == 1,
				"Die ArtikelListe hat nicht die Länge 1.");
	}
	
	@Test
	void testAddArtikelFalscheEingaben() {
		assertThrows(ExceptionInInitializerError.class, 
				() -> this.basisControl.addArtikel("Integer", "String", "Integer", "Double"),
				"Fehler im ExceptionHandling der Benutzereingabe!");
	}
	
	@Test
	void testberechneMwSt() {
		double preis = 100.0;
		double preisOhneMwSt = this.basisControl.berechneMwSt(preis);
		assertTrue(() -> Math.abs(preisOhneMwSt - (preis / 1.19)) <= 0.01,
				"Fehler in der Berechnung der MwSt.");
	}
	
	
	

}
