package eu.costengineering.interview.algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link BestShuffle}, feel free to add you own!
 */
public class BestShuffleTest {

    private BestShuffle shuffler;

    @Before
    public void createShuffler() {
        shuffler = new BestShuffle();
    }

    @Test
    public void testExample() {
        assertEquals(16, shuffler.calculateBestShuffle(new int[] { 1, 2, 4, 8}));
    }
}
