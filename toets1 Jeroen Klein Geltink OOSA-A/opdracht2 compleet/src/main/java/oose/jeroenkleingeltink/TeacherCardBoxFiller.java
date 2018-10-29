package oose.jeroenkleingeltink;

public class TeacherCardBoxFiller implements Runnable {
    public static final int CARDNUMBER = 5000;
    private CardBox cardBox;
    public TeacherCardBoxFiller(CardBox cardBox) {
        this.cardBox = cardBox;
    }

    public void fillCardBox() {
        boolean teacherCardBoxFull = false;

        while (!teacherCardBoxFull) {
            TeacherCard teacherCard = new TeacherCard(RandomNameGenerator.generateName(), CARDNUMBER, RandomCodeGenerator.generateCode());

            try {
                cardBox.addCard(teacherCard);

                Thread.sleep(10);
            } catch (UnsupportedOperationException ex) {
                teacherCardBoxFull = true;
                System.out.println("CardBox for Teachers is full.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        fillCardBox();
    }
}
