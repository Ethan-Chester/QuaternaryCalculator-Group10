package test;


import main.QuaternaryUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuaternaryUtilsTest {

    @Test
    void tenToFourShouldReturnCorrectAnswers() {
        assertEquals("2", QuaternaryUtils.toQuaternary(2));
        assertEquals("33", QuaternaryUtils.toQuaternary(15));
        assertEquals("1210", QuaternaryUtils.toQuaternary(100));
        assertEquals("33220", QuaternaryUtils.toQuaternary(1000));
        assertEquals("22", QuaternaryUtils.toQuaternary(10));
    }

    @Test
    void squareRootShouldReturnCorrectAnswer() {
        assertEquals(2, QuaternaryUtils.squareRoot(4));
    }

    @Test
    void powerShouldReturnCorrectAnswer() {
        assertEquals(4, QuaternaryUtils.power(2, 2));
        assertEquals(1, QuaternaryUtils.power(1,1));
    }

    @Test
    void powerShouldReturnOneIfExponentIsZero() {
        assertEquals(1, QuaternaryUtils.power(3,0));
        assertEquals(1, QuaternaryUtils.power(2,0));
        assertEquals(1, QuaternaryUtils.power(1,0));
        assertEquals(1, QuaternaryUtils.power(0,0));
    }
}

