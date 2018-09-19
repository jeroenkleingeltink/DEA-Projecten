package school.dea.familyApp;

public class Listener implements IListener {
    private String id;
    public Listener(String id) {
        this.id = id;
    }

    public void roep(String boodschap) {
        System.out.println(id+" komt aangerend, want: "+boodschap);
    }

}
