package oose.jeroenkleingeltink;

import java.util.Random;

public class RandomCodeGenerator {
    private static String[] Beginning = {"Kr", "Ca", "Ra", "Mrok", "Cru",
            "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
            "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
            "Mar", "Luk", "air", "ir", "mi", "sor", "mee", "clo",
            "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
            "marac", "zoir", "slamar", "salmar", "urak"};

    private static Random rand = new Random();

    public static String generateCode() {
        String randomCode = Beginning[rand.nextInt(Beginning.length)] + rand.nextInt(1000);

        return randomCode;
    }
}