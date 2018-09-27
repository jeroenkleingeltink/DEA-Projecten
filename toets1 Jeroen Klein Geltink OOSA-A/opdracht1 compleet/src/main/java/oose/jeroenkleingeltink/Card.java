package oose.jeroenkleingeltink;

public class Card {
    private String naam;
    private int waarde;

    public Card(String naam, int waarde) {
        this.naam = naam;
        this.waarde = waarde;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) throws InvalidCardValueException {
        if (waarde  < 0 || waarde > 100) {
            throw new InvalidCardValueException("InvalidValueException");
        } else {
            this.waarde = waarde;
        }
    }

    public String toString() {
        return "Card: " + this.naam + ", " + this.waarde;
    }
}
