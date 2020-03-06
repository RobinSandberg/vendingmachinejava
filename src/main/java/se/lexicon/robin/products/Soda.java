package se.lexicon.robin.products;

public class Soda extends Product {

    private String volume;
    private String bottleType;

    public Soda(int productNumber, int price, String name, int calories , String volume, String bottleType) {
        super(productNumber, price, name, calories);
        this.volume = volume;
        this.bottleType = bottleType;
    }

    public String examine(){
        String info = "Product number: " + getProductNumber() +
                "\nProduct name: " + getName() +
                "\nProduct price: " + getPrice() +
                "\nProduct calories: " + getCalories() +
                "\nProduct volume: " + getVolume() +
                "\nProduct bottle type: " + getBottleType();

        return info;
    }

    public String use(){
        String consume = "";
        if (getVolume() == "1.5L"){
            consume = "Some how you managed to down the whole 1.5L bottle and no bathroom for 20km distance.";
        }else if(getVolume() == "33cl"){
            consume = "You finished of the 33cl can and enjoy the refreshing sensation it had on you.";
        }else if(getVolume() == "25cl"){
            consume = "You drop the glass bottle and it shatters spilling the soda on the ground.";
        }
        return consume;
    }

    public String getVolume(){
        return this.volume;
    }

    public String getBottleType(){
        return this.bottleType;
    }

}
