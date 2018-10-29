import org.junit.Test;
import school.MicInt;
import static org.junit.Assert.*;

public class TestClass {
    @Test
    public void TestClassFunction() {
        // Arrange
        int counter = 20;
        MicInt mi = new MicInt(counter);

        // Act
        mi.inc();

        // Assert
        assertEquals(counter + 1, mi.getValue(), 0);
    }

    @Test
    public void TestClassFunctionHalf() {
        // Arrange
        int counter = 20;
        MicInt mi = new MicInt(counter);

        // Act
        mi.half();

        // Assert
        assertEquals(counter / 2, mi.getValue(), 0);
    }
}
