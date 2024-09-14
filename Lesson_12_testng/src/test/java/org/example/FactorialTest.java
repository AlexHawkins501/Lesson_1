package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    public void testFactorial() {
        long actual = Factorial.factorial(5);
        long expected = 120;
        Assert.assertEquals(actual, expected);

    }
    @Test
    public void testFactorial2(){
        assertEquals(120,Factorial.factorial(5));
    }
}