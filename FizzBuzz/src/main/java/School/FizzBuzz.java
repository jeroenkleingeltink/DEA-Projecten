package School;

class FizzBuzz {
    /**
     * Functions that prints Fizz, Buzz or number up to given parameter maximum
     * @param counter - maximum number for which FizzBuzzPrinter will be calculated
     */
    static void FizzBuzzPrinter(int counter) {
        for (int i = 0; i <= counter; i++) {

            String result;

            if ( i % 15 == 0) {
                // fizzbuzz
                result = "FizzBuzzPrinter";
            } else if (i % 3 == 0) {
                // fizz
                result = "Fizz";
            } else if (i % 5 == 0) {
                // buzz
                result = "Buzz";
            } else {
                // print cijfer
                result = Integer.toString(i);
            }

            Write(result);
        }
    }

    /**
     * Function that prints to console
     * @param result - Result that has to be printed
     */
    private static void Write(String result) {
        System.out.println(result);
    }
}
