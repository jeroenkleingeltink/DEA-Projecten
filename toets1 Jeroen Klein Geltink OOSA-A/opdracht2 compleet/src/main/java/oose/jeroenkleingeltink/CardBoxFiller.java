package oose.jeroenkleingeltink;

public class CardBoxFiller implements Runnable {
    public static final int CARDNUMBER = 5000;
    private CardBox cardBox;
    private StudentCardBoxFiller scf;
    private TeacherCardBoxFiller tcf;

    public CardBoxFiller(CardBox cardBox) {
//        this.cardBox = cardBox;
        this.scf = new StudentCardBoxFiller(cardBox);
        this.tcf = new TeacherCardBoxFiller(cardBox);
    }

    public void fillCardBox() {
        this.scf.fillCardBox();
        this.tcf.fillCardBox();
//        boolean studentCardBoxFull = false;
//        boolean teacherCardBoxFull = false;
//
//        while (!studentCardBoxFull) {
//            StudentCard studentCard = new StudentCard(RandomNameGenerator.generateName(), CARDNUMBER);
//
//            try {
//                cardBox.addCard(studentCard);
//
//                Thread.sleep(10);
//            } catch (UnsupportedOperationException ex) {
//                studentCardBoxFull = true;
//                System.out.println("CardBox for Students is full.");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        while (!teacherCardBoxFull) {
//            TeacherCard teacherCard = new TeacherCard(RandomNameGenerator.generateName(), CARDNUMBER, RandomCodeGenerator.generateCode());
//
//            try {
//                cardBox.addCard(teacherCard);
//
//                Thread.sleep(10);
//            } catch (UnsupportedOperationException ex) {
//                teacherCardBoxFull = true;
//                System.out.println("CardBox for Teachers is full.");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Override
    public void run() {
        fillCardBox();
    }
}
