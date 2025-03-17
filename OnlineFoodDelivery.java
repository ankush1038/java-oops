// Abstract class: FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

// Interface: Discountable
interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

// Subclass: VegItem
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public void applyDiscount(double percentage) {
        System.out.println("Discount applied on VegItem: " + percentage + "%");
    }

    @Override
    public String getDiscountDetails() {
        return "VegItem has a standard discount policy.";
    }
}

// Subclass: NonVegItem
class NonVegItem extends FoodItem implements Discountable {
    private static final double EXTRA_CHARGE = 50.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + EXTRA_CHARGE;
    }

    @Override
    public void applyDiscount(double percentage) {
        System.out.println("Discount applied on NonVegItem: " + percentage + "%");
    }

    @Override
    public String getDiscountDetails() {
        return "NonVegItem has an extra charge of " + EXTRA_CHARGE + " and discount policy.";
    }
}

// Main class to test Online Food Delivery System
public class OnlineFoodDelivery {
    public static void main(String[] args) {
        VegItem vegItem = new VegItem("Paneer Butter Masala", 250, 2);
        NonVegItem nonVegItem = new NonVegItem("Chicken Biryani", 350, 1);

        vegItem.getItemDetails();
        System.out.println("Total Price: " + vegItem.calculateTotalPrice());
        vegItem.applyDiscount(10);
        System.out.println(vegItem.getDiscountDetails());
        System.out.println();

        nonVegItem.getItemDetails();
        System.out.println("Total Price: " + nonVegItem.calculateTotalPrice());
        nonVegItem.applyDiscount(5);
        System.out.println(nonVegItem.getDiscountDetails());
    }
}
