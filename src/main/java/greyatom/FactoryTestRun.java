package greyatom;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FactoryTestRun
{
    private String td ;
    private String o ;

    FactoryTestRun(String o, String td)
    {
        this.o = o ;
        this.td= td ;
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("This is before class of " + o);
    }

    @Test
    public void testMethod(){
        System.out.println("This is test method testData is  :" + td);
    }

    @AfterClass
    public void afterClass(){
        System.out.println("This is after class of " +  o);
    }
}
