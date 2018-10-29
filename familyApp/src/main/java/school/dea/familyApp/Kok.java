package school.dea.familyApp;

import java.util.ArrayList;

public class Kok implements IPersoon {
    private String id;
    private ArrayList<IListener> eters;
    public Kok(String id) {
        this.id = id;
        eters = new ArrayList<IListener>();
    }

    public void meldAan(IListener listener) {
        eters.add(listener);
    }

    public void kook() {
        for (IListener eter : eters){
            eter.roep(id+": Eten is klaar!!!");
        }
    }
}
