package Reports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
		"json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/re-run.txt" }, glue = {
				"sitaDemo" }, monochrome = true, dryRun = false)

public class Runner {
	private TestNGCucumberRunner runner;


	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {

		runner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
		// the 'featureWrapper' parameter solely exists to display the feature
		// file in a
		// test report
		runner.runScenario(pickleWrapper.getPickle());
	}

	/**
	 * Returns two dimensional array of PickleEventWrapper scenarios with their
	 * associated CucumberFeatureWrapper feature.
	 *
	 * @return a two dimensional array of scenarios features.
	 */
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		if (runner == null) {
			return new Object[0][0];
		}
		return runner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		if (runner == null) {
			return;
		}

		runner.finish();
	}

	
}