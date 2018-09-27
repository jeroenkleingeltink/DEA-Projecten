public class TeacherCard {
    private String name;
    private String code;
    private String cardType;
    private int value;

    public TeacherCard(String name, int value, String code) {
        this.name = name;
        this.value = value;
        this.code = code;

        this.cardType = "Teacher";
    }

    public String getCardType() {
        return cardType;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    public void printCardInformation() {
        System.out.println("CardType: " + "Teacher" +
                "\nName: " + name +
                "\nValue: " + value);
    }

}
