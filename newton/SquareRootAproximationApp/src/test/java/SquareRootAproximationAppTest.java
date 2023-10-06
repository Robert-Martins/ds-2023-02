import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class SquareRootAproximationAppTest {

    @Test
    public void testCalculateSquareRoot() {

        Double result = SquareRootAproximation.calculateSquareRoot(9);
        assertEquals(3.0);

        result = SquareRootAproximation.calculateSquareRoot(25);
        assertEquals(5.0);

        result = SquareRootAproximation.calculateSquareRoot(2);
        assertEquals(Math.sqrt(2));
    }

    @Test
    public void testCalculateSquareRootWithNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            SquareRootAproximation.calculateSquareRoot(-1);
        });
    }

}
