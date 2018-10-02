package nl.oose.jeroenkleingeltink;

public class RingsBuzzAdapter implements BuzzAdapter {
    private RingsBuzz instance;

    public RingsBuzzAdapter() {
        this.instance = new RingsBuzz();
    }

    @Override
    public String getValue(int number) {
        return instance.howManyAndForWhom(number);
    }
}
