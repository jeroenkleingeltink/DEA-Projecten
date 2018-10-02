package nl.oose.jeroenkleingeltink;

public class RingsBuzz {
    public String howManyAndForWhom(int number) {
        StringBuilder builder = new StringBuilder();

        if (number == 1) {
            return "One for the Dark Lord on his dark throne";
        }
        if (number == 3) {
            return "Three Rings for the Elven-kings under the sky";
        }
        if (number == 7) {
            return "Seven for the Dwarf-lords in their halls of stone";
        }
        if (number == 9) {
            return "Nine for Mortal Men doomed to die";
        }

        return String.valueOf(number);
    }
}
