package se.lexicon.robin;

import se.lexicon.robin.products.Product;

import java.util.Scanner;

public interface IVendingMachine {

    void addCurrency(int amount);
    Product request(int productNumber);
    int endSession();
    String getDescription(int productNumber);
    int getBalance();
    String[] getProducts();

    Scanner SCANNER = new Scanner(System.in);

    static String getStringFromUser(){
        return SCANNER.nextLine();
    }

    static int getNumber(){
        boolean valid = false;
        int number = 0;
        while(!valid){
            try{
                number = Integer.parseInt(getStringFromUser().trim());
                valid = true;
            }catch(NumberFormatException e){
                System.out.println("Input was not a number.");
            }
        }
        return number;
    }

}
