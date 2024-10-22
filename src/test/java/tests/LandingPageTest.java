package tests;

import com.costco.LandingPage;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BrowserTest;

public class LandingPageTest extends BrowserTest {
    LandingPage lp;
@Test
   public void homePageTest()throws InterruptedException {
       lp = new LandingPage(driver);
       lp.verifyCostcoLogo();
       lp.verifyAllLinks();
       lp.searchItem("computer");
       Thread.sleep(2000);
       lp.verifySearchResult();
       Assert.assertEquals(lp.verifySearchResult(), "Computers");
       Thread.sleep(2000);
       System.out.println("Search result is displaying :"+lp.verifySearchResult());

   }



}
