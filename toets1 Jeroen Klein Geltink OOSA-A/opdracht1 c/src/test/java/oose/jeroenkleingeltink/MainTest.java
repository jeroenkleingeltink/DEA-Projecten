package oose.jeroenkleingeltink;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple Main.
 */
public class MainTest
{
    @Test
    public void TestCardMinimumValue() {
        // Arrange
        int testVal = 50;
        String output = "";
        Card c = new Card("TestCard", testVal);

        // Act
        try {
            c.setWaarde(-1);
        } catch (InvalidCardValueException e) {
            output = e.getMessage();
        }

        // Assert
        assertEquals("InvalidValueException", output);
    }
}
