package greyatom;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import greyatom.FactoryTestRun;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class})
public class FactoryExampleT
{
    @DataProvider (name="FDataP")
    public Object[][] fDataCreator()
    {
        return new Object[][]
                {{"object1","testData1"},{"object2","testData2"}};
    }

    @Factory (dataProvider = "FDataP")
    public Object[] OPrint(String s,String s1)
    {
        Object[] o=new Object[1];
        o[0]=new FactoryTestRun(s,s1);
        return o;
    }
}
