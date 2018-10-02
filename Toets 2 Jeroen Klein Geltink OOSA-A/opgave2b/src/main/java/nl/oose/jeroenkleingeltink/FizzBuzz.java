package nl.oose.jeroenkleingeltink;

public class FizzBuzz {
    public String getFizzBuzzValue(int number) {
        StringBuilder builder = new StringBuilder();

        if (number % 3 == 0) {
            builder.append("Fizz");
        }
        if (number % 5 == 0) {
            builder.append("Buzz");
        }
        if (builder.length() == 0) {
            builder.append(number);
        }

        return builder.toString();
    }
}
