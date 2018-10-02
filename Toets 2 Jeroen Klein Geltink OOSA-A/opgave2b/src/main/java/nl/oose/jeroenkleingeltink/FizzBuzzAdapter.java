package nl.oose.jeroenkleingeltink;

public class FizzBuzzAdapter implements BuzzAdapter {
    private FizzBuzz instance;

    public FizzBuzzAdapter() {
        this.instance = new FizzBuzz();
    }

    @Override
    public String getValue(int number) {
        return instance.getFizzBuzzValue(number);
    }
}
