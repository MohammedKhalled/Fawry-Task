# Fawry Task - E-commerce Checkout System

A Java-based e-commerce checkout system that handles different types of products with various business rules including expiration dates, shipping costs, and inventory management.

## Features

- **Multiple Product Types**: Support for regular products, shippable products, expirable products, and products that are both shippable and expirable
- **Smart Checkout Process**: Validates product expiration, calculates shipping costs, and manages inventory
- **Customer Balance Management**: Tracks customer balance and validates payment capability
- **Inventory Control**: Automatically reduces product quantities after successful checkout
- **Shipping Integration**: Calculates shipping costs based on product weight and handles shipping logistics

## Project Structure

```
src/
├── Main.java                 # Application entry point with demo
├── Model/                    # Data models
│   ├── Cart.java            # Shopping cart implementation
│   ├── CartItem.java        # Individual cart items
│   ├── Customer.java        # Customer with balance management
│   ├── Product.java         # Base product class
│   ├── RegularProduct.java  # Standard products
│   ├── ShippableProduct.java # Products that require shipping
│   ├── ExpirableProduct.java # Products with expiration dates
│   └── ExpirableShippableProduct.java # Products that are both shippable and expirable
└── Services/                # Business logic services
    ├── CheckoutService.java # Main checkout processing
    └── ShippingService.java # Shipping calculations and logistics
```

## Product Types

- **Regular Products**: Standard items like scratch cards
- **Shippable Products**: Items that require shipping (e.g., electronics)
- **Expirable Products**: Items with expiration dates (e.g., food items)
- **Expirable Shippable Products**: Items that are both shippable and have expiration dates (e.g., perishable goods that need shipping)

## How to Run

1. Ensure you have Java installed on your system
2. Navigate to the project directory
3. Compile the project:
   ```bash
   javac -cp src src/Main.java
   ```
4. Run the application:
   ```bash
   java -cp src Main
   ```

## Demo

The main application includes a demonstration that:
- Creates a customer with a balance
- Adds various product types to a cart
- Processes the checkout with validation
- Displays a detailed receipt

## Business Rules

- Products cannot be purchased if they are expired
- Customer must have sufficient balance to complete the purchase
- Product quantities are automatically reduced after successful checkout
- Shipping costs are calculated based on product weight
- Expired products are automatically detected and rejected during checkout

## Technologies Used

- Java 8+
- Object-Oriented Programming principles
- Inheritance and polymorphism for product types
- Service-oriented architecture for business logic
