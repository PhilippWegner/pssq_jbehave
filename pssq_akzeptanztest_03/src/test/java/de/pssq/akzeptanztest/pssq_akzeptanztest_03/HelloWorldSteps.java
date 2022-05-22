package de.pssq.akzeptanztest.pssq_akzeptanztest_03;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class HelloWorldSteps {

	private HelloWorld helloWorld = new HelloWorld();

	private String name = "";

	private String output = "";

	public HelloWorldSteps() {
	}

	@Given("A String name $name")
	public void givenInput(String name) {
		this.name = name;
	}

	@When("sayHello method of HelloWorld.java is called")
	public void whenBusinessLogicCalled() {
		output = helloWorld.sayHello(name);
	}

	@Then("It should return $response")
	public void thenCheckOutput(String response) {
		Assert.assertEquals(output, response);
	}
}