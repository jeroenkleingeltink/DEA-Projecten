package nl.oose.dea.orderservice.withsrp;

import nl.oose.dea.orderservice.withoutsrp.InsufficientInventoryException;
import nl.oose.dea.orderservice.withoutsrp.InventorySystem;

public class CafetariaReservationService implements ReservationService {
    private InventorySystem inventorySystem = new InventorySystem();

    @Override
    public void reserveInventory(Cart cartWithSufficientInventory) {
        for(Item item : cartWithSufficientInventory.getItems())
        {
            try {
                inventorySystem.reserve(item.sku, item.quantity);
            } catch(InsufficientInventoryException insufficientInventoryException)
            {
                throw new OrderException("Insufficient inventory for item " + item.sku, insufficientInventoryException);
            }
        }
    }

    @Override
    public boolean isOnStock(String frikandel, int i) {
        return inventorySystem.isOnStock(frikandel, i);
    }
}
