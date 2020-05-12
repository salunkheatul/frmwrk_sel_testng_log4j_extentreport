package greyatom;

import org.testng.Assert;
import org.testng.annotations.*;


public class TestNGTest {
    @BeforeSuite(alwaysRun = true)
    public TestRun create() {
        return new TestRun();
    }

    private TestRun t1 = create();

    @BeforeTest(alwaysRun = true)
    public void init() {
        t1.print(t1.toString());
    }

    @BeforeMethod(alwaysRun = true)
    public void nullCheck() {
        Assert.assertNotNull(t1);
    }

    @Test(priority = 3, groups = {"gp2"}, dependsOnGroups = "gp1")
    @Parameters({"text"})
    public void printYes(String tx) {
        try {
            t1.yes(tx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 2, groups = {"gp1"})
    @Parameters({"text1"})
    public void printNo(String tx1) {
        try {
            t1.no(tx1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "DataP", priority = 1, alwaysRun = true, groups = {"gp3"}, dependsOnGroups = {"gp1"}, dependsOnMethods = {"printYes"})
    public void printData(String dp1, String dp2) {
        try {
            System.out.println("parameter= " + dp1 + " value= " + dp2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public TestRun newT() {
        System.out.println("old value  " + t1);
        t1 = null;
        t1 = new TestRun();
        System.out.println("new value  " + t1);
        return t1;
    }

    @AfterTest(alwaysRun = true)
    public void check() {
        System.out.println("after test value  " + t1);
    }


    @AfterSuite(alwaysRun = true)
    public void destroy() {
        t1 = null;
    }

    @DataProvider(name = "DataP"/*,parallel = true*/)
    public Object[][] dataCreator() {
        return new Object[][]
                {
                        {"p1", "d1"},
                        {"p2", "d2"},
                        {"p3", "d3"}
                };
    }

}
