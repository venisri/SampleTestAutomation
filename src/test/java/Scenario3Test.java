import com.transavia.Base.TestBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Scenario3Test extends TestBase {
    public String errormessage = "This field is required.";
    @Test
    public void verifyMandatoryMessage(){
        try{
            String errText=home.getToFieldsErrorMessage("\"Lyon, France\"",errormessage);
            Assert.assertEquals(errText,errormessage);
            Reporter.log("Verified the error message as"+errText);


        }catch(Throwable t){
            driver.close();
            Assert.fail(t.getMessage());
        }

    }

    @Test
    public void validateErrorMessage(){

    }
}
