package se.lexicon.robin;

import se.lexicon.robin.products.Product;

public class Menu {

    VendingMachine vendingMachine = new VendingMachine();
    private int inputNumber;
    private Product product;
    public void menuOptions(){
        boolean running = true;
        while(running) {
            System.out.print("\nWelcome  costumer to pizza vendor." +
             "\n1. Deposit money into the vendor." +
             "\n2. Check your balance." +
             "\n3. Get product list." +
             "\n4. Examine item from vendor." +
             "\n5. Buy item from vendor." +
             "\n6. Use your product." +
             "\n7. End transaction and get change back." +
             "\n: INPUT: ");

            int input = IVendingMachine.getNumber();

            switch (input) {
                case 1:
                    System.out.print("How much you wanna put into the vendor? : INPUT: ");
                    vendingMachine.addCurrency(IVendingMachine.getNumber());
                    break;
                case 2:
                    System.out.println(vendingMachine.getBalance());
                    break;
                case 3:
                    for (int i = 0; i < vendingMachine.getProducts().length; i++) {
                        System.out.println(vendingMachine.getProducts()[i]);
                    }
                    break;
                case 4:
                    System.out.print("What product you wanna examine pick product number. : INPUT: ");
                    setInputNumber(IVendingMachine.getNumber());
                    System.out.println(vendingMachine.getDescription(getInputNumber()));
                    break;
                case 5:
                    System.out.print("What product you wanna buy pick product number. : INPUT: ");
                    setInputNumber(IVendingMachine.getNumber());
                    product = vendingMachine.request(getInputNumber());
                    if (product != null) {
                        System.out.println("You bought " + product.getName() + ".");
                    }
                    break;
                case 6:
                    System.out.println(vendingMachine.getUse(product));
                    break;
                case 7:
                    vendingMachine.endSession();
                    running = false;
                    break;
                default:
                    System.out.println("Not a valid input!");
                    break;
            }
        }
    }

    public int getInputNumber(){
        return this.inputNumber;
    }

    public void setInputNumber(int inputNumber){
        this.inputNumber = inputNumber;
    }
}
