package oose.jeroenkleingeltink;

import java.util.ArrayList;
import java.util.List;

public class CardBox {
    public static final int boxSize = 100;
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        if (cards.size() < boxSize) {
            cards.add(card);
            System.out.println("Added card: ");
            card.printCardInformation();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
