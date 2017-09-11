import com.transavia.Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class scenario2Test extends TestBase {
    String curDate=getCurrentdate(),chooseDepDate,ChooseRetDate;
    String date=curDate.substring(0,2);
    int depDate=(Integer.parseInt(date))-1,retDate=(Integer.parseInt(date))+2;
@Test

public void bookFlight() throws InterruptedException {
    try {
        chooseDepDate=String.valueOf(depDate);
        ChooseRetDate=String.valueOf(retDate);
        int count= home.bookFlight("Lyon, France", "Agadir, Morocco");
        Assert.assertTrue(count>=1);

    } catch (Throwable t) {
        driver.close();
        Assert.fail(t.getMessage());
    }

}
}