package nl.oose.dea.orderservice.withsrp;

public interface ReservationService {
    void reserveInventory(Cart cartWithSufficientInventory);

    boolean isOnStock(String frikandel, int i);
}
