package oose.jeroenkleingeltink;

public class TeacherCard extends Card {
    private String code;

    public TeacherCard(String name, int value, String code) {
        super(name, value, "Teacher");
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
