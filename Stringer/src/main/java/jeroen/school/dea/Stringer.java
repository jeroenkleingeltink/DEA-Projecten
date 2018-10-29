package jeroen.school.dea;

public class Stringer implements IStringer {
    private String stringer;
    private String reverse;

    public Stringer (String input) {
        this.stringer = input;

        reverseString();
    }

    public String getStringer() {
        return this.stringer;
    }

    @Override
    public String getReverse() {
        return this.reverse;
    }

    private void reverseString() {
        // reverse stringer
        this.reverse = new StringBuilder(stringer).reverse().toString();
    }
}
