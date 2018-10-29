package oose.jeroenkleingeltink;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
//        CardBox cardBox = new CardBox();
//        cardBox.fillCardBox();

        // Opdracht 2d
         CardBox cardBox = new CardBox();
//         CardBoxFiller kaartenBakVuller = new CardBoxFiller(cardBox);
//         kaartenBakVuller.fillCardBox();

         Thread studentThread = new Thread(new StudentCardBoxFiller(cardBox));

         Thread teacherThread = new Thread(new TeacherCardBoxFiller(cardBox));

         studentThread.start();

         teacherThread.start();
    }
}
