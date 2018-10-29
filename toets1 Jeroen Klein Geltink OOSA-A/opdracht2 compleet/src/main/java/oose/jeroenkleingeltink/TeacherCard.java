package oose.jeroenkleingeltink;

public class TeacherCard extends Card {
    public static final String TEACHER = "Teacher";
    private String code;

    public TeacherCard(String name, int value, String code) {
        super(name, value, TEACHER);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
