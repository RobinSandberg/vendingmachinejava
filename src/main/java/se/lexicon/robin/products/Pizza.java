package se.lexicon.robin.products;

public class Pizza extends Product {

    private String size;
    private String toppings;

    public Pizza(int productNumber, int price, String name, int calories, String size, String toppings) {
        super(productNumber, price, name, calories);
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    public String examine(){
        String info = "Product number: " + getProductNumber() +
                "\nProduct name: " + getName() +
                "\nProduct price: " + getPrice() +
                "\nProduct calories: " + getCalories() +
                "\nProduct size: " + getSize() +
                "\nProduct toppings: " + getToppings();

        return info;
    }

    @Override
    public String use(){
        String consume = "";
        if (getSize() == "Large"){
            consume = "You eat the whole large pizza and need a nap.";
        }else if(getSize() == "Medium"){
            consume = "You finished of a medium pizza and ready for the party.";
        }else if(getSize() == "Small"){
            consume = "You ate the whole small pizza  you sure you don't want more?";
        }
        return consume;
    }

    public String getSize(){
        return this.size;
    }

    public String getToppings() {
        return toppings;
    }

}
