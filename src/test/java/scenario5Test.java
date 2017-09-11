import com.transavia.Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class scenario5Test extends TestBase {

    @Test
    public void validateReturnOnField() throws InterruptedException {
        try {
            String txt = home.uncheckReturnOn();
            Assert.assertTrue(txt.contains("Single flight"));
        } catch (Throwable t) {
            driver.close();
            Assert.fail(t.getMessage());
        }

    }
}
