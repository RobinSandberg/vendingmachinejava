package se.lexicon.robin.products;

public abstract class Product {
    private final int productNumber;
    private int price;
    private String name;
    private int calories;

    public Product(int productNumber, int price, String name, int calories){
        this.price = price;
        this.name = name;
        this.calories = calories;
        this.productNumber = productNumber;
    }

    public abstract String examine();

    public abstract String use();

    public int getProductNumber(){
        return this.productNumber;
    }

    public int getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public int getCalories(){
        return this.calories;
    }

}
