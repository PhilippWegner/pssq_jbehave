package de.pssq.akzeptanztest.pssq_akzeptanztest_05.steps;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import de.pssq.akzeptanztest.pssq_akzeptanztest_05.business.Artikel;

public class ArtikelPropertiesSteps {

	private Artikel article;

	@BeforeStory
	public void setUp() {
		this.article = null;
	}

	@Given("An empty outdoor article instance")
	public void givenAnEmptyOutdoorArticleInstance() {
		this.article = new Artikel();
	}

	@When("I set the article properties to $id, $bezeichnung, $lagerbestand, $preis")
	public void whenISetTheArticlePropertiesTo1Zelt125999(int id, String bezeichnung, int lagerbestand, double preis) {
		this.article.setArtikelID(id);
		this.article.setBezeichnung(bezeichnung);
		this.article.setLagerbestand(lagerbestand);
		this.article.setPreis(preis);
	}

	@Then("The article properties should be $id, $bezeichnung, $lagerbestand, $preis")
	public void thenTheArticlePropertiesShouldBe1Zelt125999(int id, String bezeichnung, int lagerbestand,
			double preis) {
		assertTrue("Die Properties sind nicht korrekt.",
				(this.article.getArtikelID() == id && this.article.getBezeichnung().equals(bezeichnung)
						&& this.article.getLagerbestand() == lagerbestand
						&& Math.abs(this.article.getPreis() - preis) <= 0.01));
	}

}
