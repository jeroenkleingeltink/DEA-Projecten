package school;

public class RestStock {
    int beerBottles, bitterBallen, whiskeyLiters;

    public RestStock(int beerBottles, int bitterBallen, int whiskeyLiters) {
        this.beerBottles = beerBottles;
        this.bitterBallen = bitterBallen;
        this.whiskeyLiters = whiskeyLiters;
    }

    public void SellOneBeer() {
        this.beerBottles--;
    }

    public void SellBitterBalPlate(int bitterBallen) {
        this.bitterBallen = this.bitterBallen - bitterBallen;
    }

    public void GetDrunkOnWhiskey() {
        this.whiskeyLiters = this.whiskeyLiters - 1;
    }

    public int countBeerBottles() {
        return this.beerBottles;
    }

    public int countBitterBallen() {
        return this.bitterBallen;
    }

    public double weighWhiskeyCask() {
        return this.whiskeyLiters;
    }
}
