package oose.jeroenkleingeltink;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
//        // Opgave 1b
//         System.out.println("Opgave 1b");
//         Card c1 = new Card("kees", 25);
//         System.out.println(c1.toString());

        // Opgave 1d
//         System.out.println("Opgave 1d");
//         CardBox cardBox = new CardBox();
//         Card c2;
//         for (int i = 0; i < 4; i++) {
//              c2 = cardBox.getCard();
//              System.out.println(c2.toString());
//         }

        // Opgave 1e
         System.out.println("Opgave 1e/f");
         CardUtil cu = new CardUtil();
         Card c3 = new Card("Jan", 55);
         Card c4 = new Card("Michel", 50);
         Card c5 = cu.add(c3, c4);
         System.out.println(c5.toString());
    }
}
