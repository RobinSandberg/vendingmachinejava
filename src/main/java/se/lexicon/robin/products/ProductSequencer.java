package se.lexicon.robin.products;

public class ProductSequencer {
    private static int productNumber = 0;

    public static int nextProductNumber(){
        productNumber++;
        return productNumber;
    }

    public static void reset(){
        productNumber = 0;
    }

    public static int getProductNumber(){
        return productNumber;
    }
}
