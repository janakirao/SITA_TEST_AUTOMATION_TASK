package Reports;


import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;


 

@CucumberOptions(
features = {"src/test/resources/features/login" },
 glue = {"psetest.sitatexonline.testautomation.testcases" },
 plugin = { "html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json", "rerun:target/cucumber-reports/re-run.txt" },

    tags= "@Custom",

    monochrome = true, dryRun = false)

public class TestRunner extends Runner {

                private TestNGCucumberRunner testNGCucumberRunner;
                @BeforeClass(alwaysRun = true)
                public void setUpClass() throws Exception {
                                testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

                }

                 @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")

                public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {


                                testNGCucumberRunner.runScenario(pickleWrapper.getPickle());

                }

 

                /**

                * Returns two dimensional array of PickleEventWrapper scenarios with their

                * associated CucumberFeatureWrapper feature.

                *

                * @return a two dimensional array of scenarios features.

                */

                @DataProvider(parallel = true)

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