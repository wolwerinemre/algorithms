package eu.costengineering.interview.algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link JumpCounter}, feel free to add you own!
 */
public class JumpCounterTest {


    private JumpCounter counter;

    @Before
    public void createJumpCounter() {
        counter = new JumpCounter();
    }

    @Test
    public void testExample() {
        assertEquals(2, counter.countJumpsToIndex(new int[] { 1, 1, 1 }, 2));
    }

}
