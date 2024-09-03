package test;
import main.QuaternaryCalculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuaternaryCalculationTest {

    @Test
    void tentofour() {
    }

    @Test
    void squareRoot() {
        assertEquals(2, QuaternaryCalculation.squareRoot(4));
    }

    @Test
    void power() {
        assertEquals(4, QuaternaryCalculation.power(2, 2));
    }
}

