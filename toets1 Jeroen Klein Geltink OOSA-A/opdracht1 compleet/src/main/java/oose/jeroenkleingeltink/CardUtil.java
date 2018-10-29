package oose.jeroenkleingeltink;

public class CardUtil {
    public CardUtil() {
    }

    public Card add (Card k1, Card k2) {
        String newCardName = k1.getNaam() + k2.getNaam();
        int newCardValue = 0;

        if (k1.getWaarde() + k2.getWaarde() > 100) {
            newCardValue = 100;
        } else {
            newCardValue = k1.getWaarde() + k2.getWaarde();
        }

        return new Card(newCardName, newCardValue);
    }
}
