package jeroen.codes.school;

import org.apache.commons.math3.primes.Primes;

public class PrimeTester implements Runnable {
    NumberUnderTest numberUnderTest;
    int highestNumberToTest;

    public PrimeTester(NumberUnderTest numberUnderTest, int highestNumberToTest) {
        this.numberUnderTest = numberUnderTest;
        this.highestNumberToTest = highestNumberToTest;
    }

    public synchronized void startTesting() throws OuchIFoundThirtySevenAndHenceMustDieException {
        while (true) {
            int number = numberUnderTest.getNumber();

            if (number == 37) {
                throw new OuchIFoundThirtySevenAndHenceMustDieException();
            }

            if (number > highestNumberToTest) {
                break;
            }

            boolean isPrime = Primes.isPrime(number);

            if (isPrime) {
                System.out.println(Thread.currentThread().getId() + " found a prime number: " + number);
            }
        }
    }

    public void run() {
        try {
            startTesting();
        } catch (OuchIFoundThirtySevenAndHenceMustDieException e) {
            System.out.println(Thread.currentThread().getId() + " found Thristy Seven and must die.");
        }
    }
}
