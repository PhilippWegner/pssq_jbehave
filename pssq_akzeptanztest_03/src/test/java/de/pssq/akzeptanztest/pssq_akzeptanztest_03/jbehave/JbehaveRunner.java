package de.pssq.akzeptanztest.pssq_akzeptanztest_03.jbehave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromURL;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

/**
 * JbehaveRunner: parse stories, run scenarios (JbehaveSteps) and generate
 * reports
 */
public class JbehaveRunner extends JUnitStories {
	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryReporterBuilder(
				new StoryReporterBuilder().withPathResolver(new FilePrintStreamFactory.ResolveToSimpleName())
						.withFormats(Format.CONSOLE, Format.HTML))
				.useStoryLoader(new LoadFromURL());
	}

	@Override
	public List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("").getFile(),
				Collections.singletonList("**/*.story"), new ArrayList<String>(), "file:");
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new MwStBerechnungSteps());
	}
}