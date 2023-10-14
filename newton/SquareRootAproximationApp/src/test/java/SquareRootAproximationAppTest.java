import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class SquareRootAproximationAppTest {

    @Test
    public void testCalculateSquareRoot() {

        Function<Double, Double> squareRootAproximation = new SquareRootAproximation();

        Double result = squareRootAproximation.apply(9.0);
        assertEquals(3.0, result);

        result = squareRootAproximation.apply(25.0);
        assertEquals(5.0, result);

        result = squareRootAproximation.apply(2.0);
        assertEquals(Math.sqrt(2), result);
    }

    @Test
    public void testCalculateSquareRootWithNegativeInput() {
        Function<Double, Double> squareRootAproximation = new SquareRootAproximation();
        assertThrows(IllegalArgumentException.class, () -> 
            squareRootAproximation.apply(-1);
        );
    }

}
