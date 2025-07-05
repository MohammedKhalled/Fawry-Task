package Services;

import Model.*;

import java.util.*;

public class ShippingService {
    public static double calculateShipping(List<Shippable> items) {
        return items.size() * 10; // flat 10 per item
    }

    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        Map<String, Double> productWeights = new LinkedHashMap<>();
        Map<String, Integer> productQuantities = new LinkedHashMap<>();
        for (Shippable item : items) {
            productWeights.put(item.getName(), productWeights.getOrDefault(item.getName(), 0.0) + item.getWeight());
            productQuantities.put(item.getName(), productQuantities.getOrDefault(item.getName(), 0) + 1);
        }
        double totalWeight = 0;
        for (var entry : productWeights.entrySet()) {
            System.out.printf("%s\t\t%.0fg\n", productQuantities.get(entry.getKey()) + "x " + entry.getKey(), entry.getValue());
            totalWeight += entry.getValue();
        }
        System.out.printf("Total package weight %.1fkg\n\n", totalWeight / 1000.0);
    }
}
