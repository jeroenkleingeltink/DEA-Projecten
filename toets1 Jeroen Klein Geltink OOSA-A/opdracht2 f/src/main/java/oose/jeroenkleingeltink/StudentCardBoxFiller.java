package oose.jeroenkleingeltink;

public class StudentCardBoxFiller implements Runnable {
    public static final int CARDNUMBER = 5000;
    private CardBox cardBox;

    public StudentCardBoxFiller(CardBox cardBox) {
        this.cardBox = cardBox;
    }

    public void fillCardBox() {
        boolean studentCardBoxFull = false;

        while (!studentCardBoxFull) {
            StudentCard studentCard = new StudentCard(RandomNameGenerator.generateName(), CARDNUMBER);

            try {
                cardBox.addCard(studentCard);

                Thread.sleep(10);
            } catch (UnsupportedOperationException ex) {
                studentCardBoxFull = true;
                System.out.println("CardBox for Students is full.");
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
