package sitaDemo;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

public class sitaRunner {

	@CucumberOptions(features = { "src/test/resources/features" }, 
 
			glue = {"sitaDemo"}, 
			plugin = {"html:target/cucumber-reports/cucumber-pretty.html",
					"json:target/cucumber-reports/CucumberTestReport.json",
	"rerun:target/cucumber-reports/re-run.txt" }, 
			
			tags= "@submitReservation",
			monochrome = true,
			dryRun = false)

	public class TestRunner  {
		private TestNGCucumberRunner testNGCucumberRunner;

		@BeforeClass(alwaysRun = true)
		public void setUpClass() throws Exception {

			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		}

		@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
		public void runScenario(PickleWrapper pickleWrapper,
				FeatureWrapper featureWrapper) throws Throwable {
			// the 'featureWrapper' parameter solely exists to display the feature
			// file in a
			// test report
			testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
		}

		/**
		 * Returns two dimensional array of PickleWrapper scenarios with their
		 * associated FeatureWrapper feature.
		 *
		 * @return a two dimensional array of scenarios features.
		 */
		@DataProvider(parallel = false)
		public Object[][] scenarios() {
			if (testNGCucumberRunner == null) {
				return new Object[0][0];
			}
			return testNGCucumberRunner.provideScenarios();
		}

		@AfterClass(alwaysRun = true)
		public void tearDownClass(ITestContext result) throws Exception {
			if (testNGCucumberRunner == null) {
				return;
			}
			testNGCucumberRunner.finish();
		}
	}
}