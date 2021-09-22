import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimeFactorsTest {

    private PrimeFactors primeFactors;

    @BeforeEach
    public void setUp() {
        primeFactors = new PrimeFactors();
    }

    @Test
    public void testZeroOrNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> primeFactors.resolve(0));
        assertThrows(IllegalArgumentException.class, () -> primeFactors.resolve(-1));
        assertThrows(IllegalArgumentException.class, () -> primeFactors.resolve(-100));
    }

    @Test
    public void testOne() {
        List<Integer> actual = primeFactors.resolve(1);
        List<Integer> expected = Collections.singletonList(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testTwo() {
        List<Integer> actual = primeFactors.resolve(2);
        List<Integer> expected = Collections.singletonList(2);
        assertEquals(expected, actual);
    }

    @Test
    public void testPrimes() {
        List<Integer> actual = primeFactors.resolve(13);
        List<Integer> expected = Collections.singletonList(13);
        assertEquals(expected, actual);

        actual = primeFactors.resolve(39821);
        expected = Collections.singletonList(39821);
        assertEquals(expected, actual);
    }

    @Test
    public void testNonPrimes() {
        List<Integer> actual = primeFactors.resolve(2730);
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 13);
        assertEquals(expected, actual);

        actual = primeFactors.resolve(27);
        expected = Arrays.asList(3, 3, 3);
        assertEquals(expected, actual);

        actual = primeFactors.resolve(221);
        expected = Arrays.asList(13, 17);
        assertEquals(expected, actual);
    }

    @Test
    public void testPowerOfTwo() {
        List<Integer> actual = primeFactors.resolve(65536);
        List<Integer> expected = Collections.nCopies(16,2);
        assertEquals(expected, actual);
    }

    @Test
    public void testIntegerMaxValue() {
        List<Integer> actual = primeFactors.resolve(Integer.MAX_VALUE);
        List<Integer> expected = Collections.singletonList(Integer.MAX_VALUE);
        assertEquals(expected, actual);
    }

}
