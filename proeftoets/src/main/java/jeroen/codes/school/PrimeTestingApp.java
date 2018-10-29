package jeroen.codes.school;

public class PrimeTestingApp {
    private static final int HIGHEST_NUMBER_TO_TEST = 200;

    public static void main(String[] args) {
        PrimeTestingApp app = new PrimeTestingApp();
        app.startTesting();
    }

    private void startTesting() {
        NumberUnderTest numberUnderTest = new NumberUnderTest();

        Thread[] testers = new Thread[4];

        for (int i = 0; i < testers.length; i++) {
            testers[i] = new Thread(new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST));
            testers[i].start();
        }
    }
}
