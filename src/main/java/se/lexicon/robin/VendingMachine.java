package se.lexicon.robin;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import se.lexicon.robin.money.Currency;
import se.lexicon.robin.products.*;

public class VendingMachine implements IVendingMachine{

    private static Product[] products = {
            new Pizza(ProductSequencer.nextProductNumber(),90,"Hawaii",410,"Large","Cheese , Tomato sauce , Pineapple , Bananas"),
            new Pizza(ProductSequencer.nextProductNumber(),80, "Vesuvio", 225, "Medium", "Cheese , Tomato sauce , Ham"),
            new Pizza(ProductSequencer.nextProductNumber(),70, "Margarita", 150, "Small" , "Cheese , Tomato sauce"),
            new Soda(ProductSequencer.nextProductNumber(), 20,"Coca cola",50,"33cl", "Aluminium can"),
            new Soda(ProductSequencer.nextProductNumber(), 30, "Fanta", 100, "1.5L","Plastic bottle"),
            new Soda(ProductSequencer.nextProductNumber(), 15, "Pepsi",40,"25cl","Glass bottle"),
            new Kebab(ProductSequencer.nextProductNumber(), 75,"Kebab roll", 175, "Hot sauce"),
            new Kebab(ProductSequencer.nextProductNumber(), 80, "Kebab plate", 210, "Mild sauce"),
            new Kebab(ProductSequencer.nextProductNumber(), 65, "Kebab salad" , 130, "Weak sauce")
    };

    private int depositPool;

    @Override
    public void addCurrency(int amount){
        if(amount > 0){
            depositsAndReturns(amount, "deposit");
            this.depositPool = amount;
        }else{
            System.out.println("Can't add negative values.");
            this.depositPool = 0;
        }
    }

    @Override
    public Product request(int productNumber){
        if(productNumber > 0 && productNumber <= products.length) {
            if (this.depositPool < products[productNumber - 1].getPrice()) {
                System.out.println("You spent more then you put into the vendor.");
                return null;
            } else {
                Product product = products[productNumber - 1];
                this.depositPool -= products[productNumber - 1].getPrice();
                return product;
            }

        }else{
            System.out.println("Your input is invalid product number!");
            return null;
        }
    }

    @Override
    public int endSession(){
        int change = this.depositPool;
        depositsAndReturns(change, "return");
        this.depositPool = 0;
        return change;
    }

    @Override
    public String getDescription(int productNumber){
        if(productNumber > 0 && productNumber <= products.length){
            return products[productNumber-1].examine();
        }else{
            return "Your input is invalid product number!";
        }
    }

    @Override
    public int getBalance(){
        return this.depositPool;
    }

     @Override
     public String[] getProducts(){
        String[] tempProducts = new String[products.length];
        for (int i = 0; i < products.length; i++){
           tempProducts[i] = products[i].getProductNumber() + ". " + products[i].getName();
        }
        return tempProducts;
     }

    public String getUse(Product product){
        if(product != null){
            return product.use();
        }else{
            return "Buy something first!";
        }
    }

    public static void depositsAndReturns(int money, String action) {

        for (int i = Currency.values().length; money > 0; i--) {
            int count = money / Currency.values()[i - 1].getValue();
            if (count != 0) {
                if (action == "deposit") {
                    System.out.println("You put into the vending machine " + count + " of " + Currency.values()[i - 1].getValue() + " kronor.");
                } else if (action == "return") {
                    System.out.println("The vending machine spits out " + count + " of " + Currency.values()[i - 1].getValue() + " kronor.");
                }
            }
            money -= count * Currency.values()[i - 1].getValue();
        }
    }
}
