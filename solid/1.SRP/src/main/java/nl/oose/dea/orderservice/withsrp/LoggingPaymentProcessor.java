package nl.oose.dea.orderservice.withsrp;

import nl.oose.dea.orderservice.withoutsrp.PaymentGateway;

public class LoggingPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean chargeCard(PaymentDetails paymentDetails, Cart cart) {
        PaymentGateway paymentGateway = new PaymentGateway();
        return paymentGateway.charge(cart.getBillingTotal(), cart.getCustomerName(), paymentDetails.cardNumber);
    }
}
