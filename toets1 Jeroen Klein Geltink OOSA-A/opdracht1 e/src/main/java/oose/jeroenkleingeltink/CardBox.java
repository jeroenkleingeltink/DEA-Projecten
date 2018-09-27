package oose.jeroenkleingeltink;

import org.kohsuke.randname.RandomNameGenerator;

import java.util.Random;

public class CardBox {
    public CardBox() {

    }

    public Card getCard() {
        RandomNameGenerator rnd = new RandomNameGenerator();
        String randomNaam = rnd.next();

        Random r = new Random();
        int rand = r.nextInt(99) +1;

        Card c = new Card(randomNaam, rand);

        return c;
    }
}
