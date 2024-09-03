package test;
import main.QuaternaryCalculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuaternaryCalculationTest {
    @Test
    void tenToFourShouldReturnCorrectAnswers() {
        assertEquals(2, QuaternaryCalculation.tentofour( 2));
        assertEquals(33, QuaternaryCalculation.tentofour(15));
        assertEquals(1210, QuaternaryCalculation.tentofour(100));
        assertEquals(33220, QuaternaryCalculation.tentofour(1000));
        assertEquals(22, QuaternaryCalculation.tentofour(10));

    }

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

