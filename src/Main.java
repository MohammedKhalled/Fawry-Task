import Model.*;
import Services.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Mohanad", 1000);

        Product cheese = new ExpirableShippableProduct("Cheese", 100, 5, LocalDate.now().plusDays(5), 200);
        Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 3, LocalDate.now().plusDays(2), 700);
        Product tv = new ShippableProduct("TV", 500, 2, 5000);
        Product scratchCard = new RegularProduct("ScratchCard", 50, 10);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);
        //cart.add(tv, 1);




        CheckoutService.checkout(customer, cart);

    }
}