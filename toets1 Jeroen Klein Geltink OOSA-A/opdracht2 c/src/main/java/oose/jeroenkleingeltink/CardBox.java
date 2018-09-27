package oose.jeroenkleingeltink;

import java.util.ArrayList;
import java.util.List;

public class CardBox {
    public static final int boxSize = 100;
    public static final int CARDNUMBER = 5000;
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

    public void fillCardBox() {
        boolean studentCardBoxFull = false;
        boolean teacherCardBoxFull = false;

//        boolean cardBoxFull = false;
//
//        while (!cardBoxFull) {
//            Card card = new Card(RandomNameGenerator.generateName(), 5000);
//
//            try {
//                addCard(card);
//                Thread.sleep(10);
//            } catch (UnsupportedOperationExceptionex) {
//                cardBoxFull = true;
//                System.out.println("Cardbox is full.");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        while (!studentCardBoxFull) {
            StudentCard studentCard = new StudentCard(RandomNameGenerator.generateName(), CARDNUMBER);

            try {
                addStudentCard(studentCard);

                Thread.sleep(10);
            } catch (UnsupportedOperationException ex) {
                studentCardBoxFull = true;
                System.out.println("CardBox for Students is full.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (!teacherCardBoxFull) {
            TeacherCard teacherCard = new TeacherCard(RandomNameGenerator.generateName(), CARDNUMBER, RandomCodeGenerator.generateCode());

            try {
                addTeacherCard(teacherCard);

                Thread.sleep(10);
            } catch (UnsupportedOperationException ex) {
                teacherCardBoxFull = true;
                System.out.println("CardBox for Teachers is full.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
