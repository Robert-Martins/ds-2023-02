import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class SquareRootAproximationAppTest {

    @Test
    public void testCalculateSquareRoot() {

        Double result = SquareRootAproximation.calculateSquareRoot(9, 0.001, 100);
        assertEquals(3.0, result, 0.001);

        result = SquareRootAproximation.calculateSquareRoot(25, 0.01, 100);
        assertEquals(5.0, result, 0.01);

        result = SquareRootAproximation.calculateSquareRoot(2, 0.0001, 1000);
        assertEquals(Math.sqrt(2), result, 0.0001);
    }

    @Test
    public void testCalculateSquareRootWithNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            SquareRootAproximation.calculateSquareRoot(-1, 0.001, 100);
        });
    }

}
