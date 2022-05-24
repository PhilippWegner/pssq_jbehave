package de.pssq.akzeptanztest.pssq_akzeptanztest_05.steps;


import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import de.pssq.akzeptanztest.pssq_akzeptanztest_05.business.Artikel;

public class ArtikelExceptionSteps {
	private Artikel artikel;
	private Throwable throwable;

	@BeforeStory
	public void setUp() {
		this.artikel = null;
		this.throwable = null;
	}

	@Given("An empty outdoor article instance is created")
	public void givenAnEmptyOutdoorArticleInstanceIsCreated() {
		this.artikel = new Artikel();
	}

	@When("I set the article ID property to $flascheID")
	public void whenISetTheArticleIDPropertyTo1(int flascheID) {
		try {
			this.artikel.setArtikelID(flascheID);			
		} catch(IllegalArgumentException lae) {
			this.throwable = lae;
		}
	}

	@Then("I get an IllegalArgumentException")
	public void thenIGetAnIllegalArgumentException() {
		Assert.assertTrue("Es wurde nicht die erwartete Exception geworfen.", exceptionChecker());
	}

	private boolean exceptionChecker() {
		boolean bool = false;
		if (this.throwable != null) {
			try {
				IllegalArgumentException lae = (IllegalArgumentException) this.throwable;
				bool = true;
			} catch (Exception e) {}
		}
		return bool;
	}

	@AfterStory
	public void tearDown() {
		this.throwable = null;
	}

}
