package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialNgTest {

    @Test
    public void testFactorial() {
        long actual = FactorialNg.factorial(5);
        long expected = 120;
        Assert.assertEquals(actual, expected);

    }
    @Test
    public void testFactorial2(){
        assertEquals(120, FactorialNg.factorial(5));
        assertEquals(1, FactorialNg.factorial(-1));
    }
}