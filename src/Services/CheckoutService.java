package Services;


import Model.*;

import java.util.*;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty");

        for (CartItem item : cart.getItems()) {
            if (item.getProduct() instanceof Expirable expirable && expirable.isExpired()) {
                throw new IllegalStateException(item.getProduct().getName() + " is expired.");
            }
        }

        double subtotal = cart.getSubtotal();
        List<Shippable> shippables = cart.getShippableItems();
        double shipping = ShippingService.calculateShipping(shippables);
        double total = subtotal + shipping;

        if (!customer.canPay(total))
            throw new IllegalStateException("Customer does not have enough balance.");

        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        customer.pay(total);

        if (!shippables.isEmpty())
            ShippingService.ship(shippables);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s\t\t%.0f\n", item.getQuantity(), item.getProduct().getName(), item.getSubtotal());
        }
        System.out.printf("----------------------\nSubtotal\t%.0f\nShipping\t%.0f\nAmount\t\t%.0f\nBalance\t\t%.0f\n\n",
                subtotal, shipping, total, customer.getBalance());
    }
}
