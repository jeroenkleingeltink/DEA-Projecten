package school;

public class MicInt {
    private int value;

    public MicInt(int i) {
        this.value = i;
    }

    public void inc() {
        this.value++;
    }

    public int getValue() {
        return this.value;
    }

    public void half() {
        this.value = this.value / 2;
    }
}
