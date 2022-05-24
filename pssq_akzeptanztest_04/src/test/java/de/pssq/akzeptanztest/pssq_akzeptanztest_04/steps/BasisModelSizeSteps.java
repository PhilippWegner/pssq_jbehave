package de.pssq.akzeptanztest.pssq_akzeptanztest_04.steps;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import de.pssq.akzeptanztest.pssq_akzeptanztest_04.business.BasisModel;
import de.pssq.akzeptanztest.pssq_akzeptanztest_04.business.Artikel;

public class BasisModelSizeSteps {

	private BasisModel basisModel;

	private Artikel artikel1;
	private Artikel artikel2;
	private Artikel artikel3;

	@BeforeStory
	public void setUp() {
		this.basisModel = BasisModel.getInstance();
		this.artikel1 = new Artikel();
		this.artikel2 = new Artikel();
		this.artikel3 = new Artikel();
	}

	@Given("Eine leere Outdoorartikelliste")
	public void givenEineLeereOutdoorartikelliste() {
		this.basisModel.getArtikelListe().clear();
	}

	@When("Ich drei Artikel in die Liste hinzufuege")
	public void whenIchDreiArtikelInDieListeHinzufuege() {
		this.basisModel.fuegeArtikelHinzu(artikel1);
		this.basisModel.fuegeArtikelHinzu(artikel2);
		this.basisModel.fuegeArtikelHinzu(artikel3);
	}

	@When("danach zwei Artikel aus der Liste entferne")
	public void whenDanachZweiArtikelAusDerListeEntferne() {
		this.basisModel.loescheArtikel(artikel1);
		this.basisModel.loescheArtikel(artikel3);
	}

	@Then("Hat die Liste die Laenge $laenge")
	public void thenHatDieListeDieLaenge1(int laenge) {
		Assert.assertTrue("Die Artikelliste hat nicht die richtige Laenge.", this.basisModel.getArtikelListe().size() == laenge);
	}
}
