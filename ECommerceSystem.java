// Abstract class: Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discounted Price: " + (price - calculateDiscount()));
    }
}

// Interface: Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Subclass: Electronics
class Electronics extends Product implements Taxable {
    private double discountRate;

    public Electronics(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate / 100;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "Tax: 18% GST";
    }
}

// Subclass: Clothing
class Clothing extends Product implements Taxable {
    private double discountRate;

    public Clothing(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate / 100;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Tax: 5% GST";
    }
}

// Subclass: Groceries
class Groceries extends Product {
    private double discountRate;

    public Groceries(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate / 100;
    }
}

// Main class to test E-Commerce Platform
public class ECommerceSystem {
    public static void main(String[] args) {
        Electronics e1 = new Electronics(201, "Laptop", 60000, 10);
        Clothing c1 = new Clothing(202, "T-Shirt", 800, 5);
        Groceries g1 = new Groceries(203, "Rice", 1200, 2);

        e1.displayDetails();
        System.out.println(e1.getTaxDetails());
        System.out.println("Final Price: " + (e1.getPrice() - e1.calculateDiscount() + e1.calculateTax()));
        System.out.println();

        c1.displayDetails();
        System.out.println(c1.getTaxDetails());
        System.out.println("Final Price: " + (c1.getPrice() - c1.calculateDiscount() + c1.calculateTax()));
        System.out.println();

        g1.displayDetails();
        System.out.println("Final Price: " + (g1.getPrice() - g1.calculateDiscount()));
    }
}
