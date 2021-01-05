package com.huzhengxing.test.q2;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########
    //To test the `calcInsurancePrice()` method, which returns void, you can use the `getHealthInsurancePrice()` method, for example:
    //Person p = new Person("XYZ", 10, "XYZ", true, true);
    //assertEquals(0, p.getHealthInsurancePrice().intValue());
    public void testCalcInsurancePrice() {
        Person p = new Person("XYZ", 10, "XYZ", true, true);
        p.calcInsurancePrice();
        assertEquals(340, p.getHealthInsurancePrice().intValue());
    }

    // ########## YOUR CODE ENDS HERE ##########
}
