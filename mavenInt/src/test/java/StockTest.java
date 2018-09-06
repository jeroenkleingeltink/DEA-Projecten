import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import school.RestStock;

import static org.junit.Assert.*;

public class StockTest {
    RestStock stock;

    @Before
    public void SetUpStock() {
        // Set up stock. 50 beer bottles, 150 bitterballen and 50 liters of whiskey.
        this.stock = new RestStock(50, 150, 50);
        System.out.println("Test stock has been set!");
    }

    @Test
    public void TestBeerStock() {
        this.stock.SellOneBeer();
        System.out.println("Testing beer stock!");

        assertEquals(49, this.stock.countBeerBottles(), 0);
    }

    @Test
    public void TestBitterBallenStock() {
        this.stock.SellBitterBalPlate(12);
        System.out.println("Testing bitterballen stock!");

        assertEquals(138, this.stock.countBitterBallen(), 0);
    }

    @Test
    public void TestWhiskeyStock() {
        this.stock.GetDrunkOnWhiskey();
        System.out.println("Testing whiskey stock!");

        assertEquals(49, this.stock.weighWhiskeyCask(), 0);
    }
}
