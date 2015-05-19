package Classes;

import java.util.ArrayList;

/**
 * Program: Product Inventory Project
 * Programmer: Harsha Kuchampudi
 * Date: May 19, 2015
 *
 * Description: An application which manages an inventory of products.
 * Creates a product class which has a price, id, and quantity on hand.
 * Then creates an inventory class which keeps track of various products
 * and can sum up the inventory value.
 */

public class Product_Inventory {

    public static void main(String []args){

        // Product Creation: (Product Name, Price Per Unit, Product ID, Quantity of Product in Stock)
        Product milk = new Product("Milk", 3.15, 1, 9);
        Product eggs = new Product("Eggs", 5.45, 2, 12);
        Product butter = new Product("Butter", 6.55, 3, 5);

        // Inventory Creation
        Inventory masterInventory = new Inventory();

        // Add Items to Inventory: (Product, Quantity to Add to Inventory)
        masterInventory.addtoInventory(milk, 5);        // Within Stock Parameters < 9
        masterInventory.addtoInventory(eggs, 3);        // Within Stock Parameters < 12
        masterInventory.addtoInventory(butter, 20);     // Not in Stock Parameters < 5

        // Output the Total Value of the Inventory
        System.out.print("The Total Value of Your Inventory is: " + masterInventory.getInventoryValue());

    }

}

// Product Class
class Product{

    // Product Properties
    private String product_name;
    private double product_price;
    private int product_id;
    private int product_quantity;

    // Default Constructor
    Product(String product_name, double product_price, int product_id, int product_quantity){
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_id = product_id;
        this.product_quantity = product_quantity;

    }

    // Returns Product Name
    public String getProductName(){
        return product_name;
    }

    // Returns the Product's Price per Unit
    public double getProductPrice(){
        return product_price;
    }

    // Returns the Product's ID
    public int getProductID(){
        return product_id;
    }

    // Returns the Quantity of the Product in Stock
    public int getProductQuantity(){
        return product_quantity;
    }

    // Reduces the Quantity of a Product in Stock by a Specified Amount
    public void reduceProductQuantity(int number){
        product_quantity = product_quantity - number;
    }

}

// Inventory Class
class Inventory{

    // Inventory Product Storage
    private ArrayList<Product> productList;

    // Default Constructor
    Inventory(){
        productList = new ArrayList<>();
    }

    // Adds a Specified Quantity of a Specified Product to the Inventory
    public void addtoInventory(Product product, int product_Quantity){

        // Output What is Being Added to the Inventory
        System.out.println("Adding " + product.getProductName() + " to Inventory...");

        // While there is More Quantity of Product to Add
        while(product_Quantity > 0) {

            // If There is More of the Item in Stock
            if(product.getProductQuantity() > 0) {

                // Add Product to the Inventory List
                Product newProduct = new Product(product.getProductName(), product.getProductPrice(),
                        product.getProductID(), 1);

                productList.add(newProduct);

                // Reduce the Stock Quantity by One
                product.reduceProductQuantity(1);

                // Reduce the Amount of the Item to Add by One
                product_Quantity -= 1;

            }

            // If the Item is No Longer in Stock, Return Error
            else{
                System.out.println("Sorry, There are/is No More " + product.getProductName() + " in Stock!");
                return;
            }

        }

    }

    // Calculate the Total Value of the Inventory
    public double getInventoryValue(){

        // Total Price Storage
        double totalPrice = 0;

        // Total Price Calculation
        for(Product product : productList){
            int product_quantity = product.getProductQuantity();
            double product_price = product.getProductPrice();
            totalPrice += (product_price * product_quantity);

        }

        // Return Total Price
        return totalPrice;

    }

}
