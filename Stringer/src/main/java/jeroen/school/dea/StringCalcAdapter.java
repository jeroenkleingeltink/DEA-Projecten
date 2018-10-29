package jeroen.school.dea;

public class StringCalcAdapter implements IStringer {
    private StringCalc instance;

    public StringCalcAdapter(StringCalc stringCalc) {
        this.instance = stringCalc;
    }

    @Override
    public String getReverse() {
        return instance.getReverseResult();
    }
}
