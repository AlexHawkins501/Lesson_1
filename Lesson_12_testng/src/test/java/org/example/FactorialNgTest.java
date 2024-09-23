package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static org.testng.Assert.*;

public class FactorialNgTest {

    @Test
    public void testFactorial() {
        long actual = FactorialNg.factorial(5);
        long expected = 120;
        Assert.assertEquals(actual, expected);

    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative(){
        FactorialNg.factorial(-10);
    }
    @Test
    public void testNegativeFactorialErr(){
        assertEquals(1, FactorialNg.factorial(-1));
    }
}
