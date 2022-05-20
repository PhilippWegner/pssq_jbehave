package de.pssq.akzeptanztest.pssq_akzeptanztest_02.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArtikelTest {
	private Artikel artikel;

	@BeforeEach
	void setUp() throws Exception {
		this.artikel = new Artikel();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.artikel = null;
		assertNull(this.artikel);
	}

	@Test
	void testArtikelID() {
		this.artikel.setArtikelID(1);
		assertTrue(() -> this.artikel.getArtikelID() == 1, 
				"Die ArtikelID ist nicht nicht 1.");
	}
	
	@Test
	void testArtikelBezeichnung() {
		this.artikel.setBezeichnung("Zelt");
		assertTrue(() -> this.artikel.getBezeichnung().equals("Zelt"), 
				"Die Artikel Bezeichnung ist nicht nicht \"Zelt\".");
	}
	
	@Test
	void testArtikelLagerbestand() {
		this.artikel.setLagerbestand(10);
		assertTrue(() -> this.artikel.getLagerbestand() == 10, 
				"Die Artikel Lagerbestand ist nicht nicht 10.");
	}
	
	@Test
	void testArtikelPreis() {
		this.artikel.setPreis(105.99);
		assertTrue(() -> Math.abs(this.artikel.getPreis() - 105.99) <= 0.01, 
				"Der Artikel Preis ist nicht 105.99.");
	}
	
	@Test
	void testArtikelConstructor() {
		this.artikel = null;
		this.artikel = new Artikel(11, "Trinkflasche", 101, 9.99);
		assertTrue(() -> this.artikel.getArtikelID() == 11 && 
				this.artikel.getBezeichnung().equals("Trinkflasche") &&
				this.artikel.getLagerbestand() == 101 &&
				Math.abs(this.artikel.getPreis() - 9.99) <= 0.01,
				"Der Artikel Konstruktor ist fehlerhaft.");
	}
	
	@Test
	void testToString() {
		this.artikel = null;
		this.artikel = new Artikel(11, "Trinkflasche", 101, 9.99);
		
		String output_string = "ArtikelID: " + this.artikel.getArtikelID() + 
				"\n" + "Bezeichnung: " + this.artikel.getBezeichnung() + 
				"\n" + "Lagerbestand: " + this.artikel.getLagerbestand() + 
				"\n" + "Preis: " + this.artikel.getPreis();
		assertTrue(() -> this.artikel.toString().equals(output_string),
				"Der Output_String stimmt nicht mit der ToString Methode überein.");
	}

}
