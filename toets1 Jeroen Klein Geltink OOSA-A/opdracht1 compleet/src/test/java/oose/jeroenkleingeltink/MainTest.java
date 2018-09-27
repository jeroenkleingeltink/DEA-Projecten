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

    @Test
    public void TestCardAdd() {
        // Arrange
        // Maak 2 kaarten
        Card c1 = new Card("Kaart1", 25);
        Card c2 = new Card("Kaart2", 25);

        Card output;

        // instantie CardUtil
        CardUtil cu = new CardUtil();

        // Act
        output = cu.add(c1, c2);

        // Assert
        assertEquals("Kaart1Kaart250", output.getNaam()+ output.getWaarde());
    }
}
