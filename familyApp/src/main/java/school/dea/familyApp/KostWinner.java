package school.dea.familyApp;

import java.util.ArrayList;

public class KostWinner implements IPersoon {
    private String id;
    private ArrayList<IListener> parasieten;

    public KostWinner(String id) {
        this.id = id;
        parasieten = new ArrayList<IListener>();
    }

    public void meldAan(IListener listener) {
        parasieten.add(listener);
    }

    public void geefGeld() {
        for (IListener parasiet: parasieten){
            parasiet.roep(id+": Geld!!!");
        }
    }
}
