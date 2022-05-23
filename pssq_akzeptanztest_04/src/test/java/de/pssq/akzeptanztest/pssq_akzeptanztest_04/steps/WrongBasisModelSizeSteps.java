package de.pssq.akzeptanztest.pssq_akzeptanztest_04.steps;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import de.pssq.akzeptanztest.pssq_akzeptanztest_04.business.BasisModel;
import de.pssq.akzeptanztest.pssq_akzeptanztest_04.business.Artikel;

public class WrongBasisModelSizeSteps {

	private BasisModel basisModel = null;

	@BeforeStory
	public void setUp() {
		this.basisModel = BasisModel.getInstance();
		
	}

	@Given("Eine leere Outdoorartikelliste")
	public void givenEineLeereOutdoorartikelliste() {
		this.basisModel.getArtikelListe().clear();
	}

	@When("Ich $artikelHinzu Artikel in die Liste hinzufuege")
	public void whenIchDreiArtikelInDieListeHinzufuege(int artikelHinzu) {
		for (int i = 0; i < artikelHinzu; i++) {
			Artikel artikel = new Artikel();
			this.basisModel.fuegeArtikelHinzu(artikel);
		}
	}

	@When("danach $artikelEntfernen Artikel aus der Liste entferne")
	public void whenDanachZweiArtikelAusDerListeEntferne(int artikelEntfernen) {
		for (int i = 0; i < artikelEntfernen; i++) {
			Artikel artikel = this.basisModel.getArtikelListe().get(0);
			this.basisModel.loescheArtikel(artikel);
		}
	}

	@Then("Hat die Liste die Laenge $artikelAnzahl")
	public void thenHatDieListeDieLaenge1(int artikelAnzahl) {
		Assert.assertTrue("Die Artikelliste hat nicht die richtige Laenge.",
				this.basisModel.getArtikelListe().size() == artikelAnzahl);
	}

	@AfterStory
	public void tearDown() {
		// Problem mit Singleton zeigen:
//		this.basisModel = null;
		BasisModel.resetInstance();
	}


}
