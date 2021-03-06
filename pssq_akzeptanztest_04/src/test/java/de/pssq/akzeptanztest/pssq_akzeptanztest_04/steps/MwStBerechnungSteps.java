package de.pssq.akzeptanztest.pssq_akzeptanztest_04.steps;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import de.pssq.akzeptanztest.pssq_akzeptanztest_04.business.Artikel;
import de.pssq.akzeptanztest.pssq_akzeptanztest_04.gui.BasisControl;

public class MwStBerechnungSteps {
	private BasisControl basisControl;
	private Artikel artikel;

	@BeforeStory
	public void setUp() {
		this.basisControl = new BasisControl();
		this.basisControl.getArtikelListe().clear();
		this.artikel = null;
	}

	@Given("An Ourdoor article with VAT costs $grossprice")
	public void givenAnOurdoorArticleWithVATCostsgrossprice(double grossprice) {
		this.basisControl.getArtikelListe().clear();
		this.artikel = new Artikel(1, "Wanderhose", 10, grossprice);
	}

	@When("I want to know its netprice the calculator should divide 1,19")
	public void whenIWantToKnowItsNetpriceTheCalculatorShouldDivide119() {
		double grossprice = this.artikel.getPreis();
		double netprice = this.basisControl.berechneMwSt(grossprice);
		this.artikel.setPreis(netprice);
	}

	@Then("The outdoor article price should be $netprice")
	public void thenTheOutdoorArticlePriceShouldBenetprice(double netprice) {
		Assert.assertTrue("Die Nettopreisberechnung ist nicht korrekt.", Math.abs(this.artikel.getPreis() - netprice) <= 0.01);
	}
	
	@AfterStory
	public void tearDown() {
		this.basisControl = null;
	}

}
