package oose.jeroenkleingeltink;

import java.util.ArrayList;
import java.util.List;

public class CardBox {
    private List<TeacherCard> teacherCards = new ArrayList<>();
    private List<StudentCard> studentCards = new ArrayList<>();

    public void addStudentCard(StudentCard studentCard) {
        if (studentCards.size() < 100) {
            studentCards.add(studentCard);
            System.out.println("Added StudentenCard:");
            studentCard.printCardInformation();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void addTeacherCard(TeacherCard teacherCard) {
        if (teacherCards.size() < 100) {
            teacherCards.add(teacherCard);
            System.out.println("Added TeacherCard:");
            teacherCard.printCardInformation();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void fillCardBox() {
        boolean studentCardBoxFull = false;
        boolean teacherCardBoxFull = false;

        while (!studentCardBoxFull) {
            StudentCard studentCard = new StudentCard(RandomNameGenerator.generateName(), 5000);

            try {
                addStudentCard(studentCard);

                Thread.sleep(10);
            } catch (UnsupportedOperationException ex) {
                studentCardBoxFull = true;
                System.out.println("CardBox for Students is full.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (!teacherCardBoxFull) {
            TeacherCard teacherCard = new TeacherCard(RandomNameGenerator.generateName(), 5000, RandomCodeGenerator.generateCode());

            try {
                addTeacherCard(teacherCard);

                Thread.sleep(10);
            } catch (UnsupportedOperationException ex) {
                teacherCardBoxFull = true;
                System.out.println("CardBox for Teachers is full.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
