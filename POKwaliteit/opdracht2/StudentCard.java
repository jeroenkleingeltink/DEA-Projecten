public class StudentCard {
    private String name;
    private int value;

    private String cardType;

    public StudentCard(String name, int value) {
        this.name = name;
        this.value = value;

        cardType = "Student";
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getCardType() {
        return cardType;
    }

    public void printCardInformation() {
        System.out.println("CardType: " + "Student" +
                "\nName: " + name +
                "\nValue: " + value);
    }

}
