package school;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestFizzBuzz {
    private FizzBuzz fb;

    @BeforeEach
    void testSetup() {
        // Arrange
        fb = new FizzBuzz();
    }

    @Test
    void testDividableByThree() {
        // Act
        boolean dividableByThree = fb.divideByThree(9);

        // Assert
        assertTrue(dividableByThree);
    }

    @Test
    void testDividableByFive() {
        // Act
        boolean dividableByFive = fb.divideByFive(10);

        // Assert
        assertTrue(dividableByFive);
    }

    @Test
    void testNotDividableByThreeOrFive() {
        // Act
        boolean notDividableByThreeOrFive =
                !fb.divideByThree(7) &&
                !fb.divideByFive(7);

        // Assert
        assertTrue(!notDividableByThreeOrFive);
    }

    @Test
    void testPrintFizz() {
        // Act
        String output = fb.output(3);

        // Assert
        assertEquals("Fizz",  output);
    }

    @Test
    void testPrintBuzz() {
        // Act
        String output = fb.output(5);

        // Assert
        assertEquals("Buzz", output);
    }

    @Test
    void testPrintNumber() {
        String output =  fb.output(4);

        assertEquals("4", output);
    }
}
