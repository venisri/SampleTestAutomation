
import com.transavia.Base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class scenario1Test  extends TestBase{

    @Test
    public void verifyDisplayedFlights() throws InterruptedException {
        try {
            int count=home.searchFlightsByDestination("Lyon, France", "Agadir, Morocco");
            Assert.assertTrue(count>=1);

        }catch(Throwable t){
            driver.close();
            Assert.fail(t.getMessage());
        }

    }
}
