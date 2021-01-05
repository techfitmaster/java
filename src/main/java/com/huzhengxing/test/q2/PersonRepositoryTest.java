package com.huzhengxing.test.q2;

import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonRepositoryTest {

    SequenceGenerator sequenceGenerator;
    PersonRepository personRepository;

    @Before
    public void before() {
        sequenceGenerator = new SequenceGenerator();
        personRepository = new PersonRepository();
        personRepository.setSequenceGenerator(sequenceGenerator);
    }

    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########

    public void testSave() {
        Person p = new Person("XYZ", 10, "XYZ", true, true);
        p = personRepository.save(p);
        assertTrue(p.getId() > 0);
    }


    // ########## YOUR CODE ENDS HERE ##########


}
