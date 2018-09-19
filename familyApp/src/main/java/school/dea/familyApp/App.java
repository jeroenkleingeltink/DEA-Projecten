package school.dea.familyApp;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        IListener jij = new Listener("jij");
        IListener jeBroertje = new Listener("je broertje");
        IListener jeZusje = new Listener("je zusje");
        IListener jeVriend = new Listener("je vriend");

        Kok mama = new Kok("mama");
        Kok oma = new Kok("oma");
        KostWinner papa = new KostWinner("papa");

        mama.meldAan(jij);
        mama.meldAan(jeZusje);
        mama.meldAan(jeVriend);
        oma.meldAan(jeBroertje);
        papa.meldAan(jeBroertje);
        papa.meldAan(jij);

        mama.kook();
        oma.kook();
        papa.geefGeld();
    }
}
