package oose.jeroenkleingeltink;

public class Card {
    protected String name;
    protected int value;
    protected String cardType;

    public Card(String name, int value, String cardType) {
        this.name = name;
        this.value = value;
        this.cardType = cardType;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getCardType() {
        return cardType;
    }

    public void printCardInformation() {
        System.out.println("CardType: " + cardType +
                "\nName: " + name +
                "\nValue: " + value);
    }
}
