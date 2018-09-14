package school;

class FizzBuzz {
    boolean divideByThree(int getal) {
        return (getal % 3 == 0);
    }

    boolean divideByFive(int getal) {
        return (getal % 5 == 0);
    }

    String output(int getal) {
        if (divideByThree(getal)) {
            return "Fizz";
        } else if (divideByFive(getal)) {
            return "Buzz";
        }

        return Integer.toString(getal);
    }
}
