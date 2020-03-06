package se.lexicon.robin.products;

public class Kebab extends Product{

    private String sauce;

    public Kebab(int productNumber, int price, String name, int calories, String sauce) {
        super(productNumber, price, name, calories);
        this.sauce = sauce;
    }

    public String examine(){
        String info = "Product number: " + getProductNumber() +
                "\nProduct name: " + getName() +
                "\nProduct price: " + getPrice() +
                "\nProduct calories: " + getCalories() +
                "\nProduct sauce: " + getSauce();

        return info;
    }

    public String use(){
        String consume = "";
        if (getSauce() == "Hot sauce"){
            consume = "You pushed the wrong button and accidental got hot sauce and your mouth is on fire.";
        }else if(getSauce() == "Mild sauce"){
            consume = "You enjoy your meal and laugh at your friend who accidental got hot sauce and now crying in pain.";
        }else if(getSauce() == "Weak sauce"){
            consume = "Your friend brought you the wrong sauce and you eat it disappointed.";
        }
        return consume;
    }

    public String getSauce(){
        return this.sauce;
    }

}
