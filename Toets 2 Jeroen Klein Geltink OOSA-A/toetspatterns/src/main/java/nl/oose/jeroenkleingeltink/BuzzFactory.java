package nl.oose.jeroenkleingeltink;

public class BuzzFactory {
    private static BuzzFactory instance;

    private BuzzFactory() {
        // empty
    }

    public static BuzzFactory getInstance() {
        if (instance == null) {
            instance = new BuzzFactory();
        }

        return instance;
    }

    public FizzBuzz create() {
        return new FizzBuzz();
    }

    public BuzzAdapter create(String name) {
        if ("Fizz".equals(name)) {
            return new FizzBuzzAdapter();
        } else if ("Rings".equals(name)) {
            return new RingsBuzzAdapter();
        }

        // else return null
        return null;
    }
}
