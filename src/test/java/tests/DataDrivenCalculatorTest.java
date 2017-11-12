package tests;

import objects.CalculatorPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static tests.WinniumTest.driver;

@RunWith(Parameterized.class)
public class DataDrivenCalculatorTest {

    private static CalculatorPage calc;

    @Parameterized.Parameter
    public String expression;

    @Parameterized.Parameter(1)
    public String expected;

    @Before
    public static void setup() {
        calc = new CalculatorPage(driver);

    }

    @Before
    public void cleanup() {
        calc.clear();
    }

    @Test
    public void calculator_DataDrivenTest(){
        Assert.assertEquals(expected, calc.calculate(expression));
    }

    @Parameterized.Parameters (name="Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "2+2", "4" },
                { "100+100", "200" },
                { "30/2", "15" },
                { "1-10", "-9" },
                { "1.02+1.001", "2.021" },
                { "32785x2", "65570" },
                { "10000000/-1111", "-9000.900090009001" },
                { "-1+154", "153" }
        });
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}