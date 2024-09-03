package test;
import main.QuaternaryCalculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuaternaryCalculationTest {

    @Test
    void squareRootShouldReturnCorrectAnswer() {
        assertEquals(2, QuaternaryCalculation.squareRoot(4));
    }

    @Test
    void powerShouldReturnCorrectAnswer() {
        assertEquals(4, QuaternaryCalculation.power(2, 2));
        assertEquals(1, QuaternaryCalculation.power(1,1));
    }

    @Test
    void powerShouldReturnOneIfExponentIsZero() {
        assertEquals(1, QuaternaryCalculation.power(3,0));
        assertEquals(1, QuaternaryCalculation.power(2,0));
        assertEquals(1, QuaternaryCalculation.power(1,0));
        assertEquals(1, QuaternaryCalculation.power(0,0));
    }
}

