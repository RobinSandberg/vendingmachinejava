package se.lexicon.robin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.robin.products.Product;

public class VendingMachineTest {

    VendingMachine vendingMachine;
    @Before
    public void before(){
        vendingMachine = new VendingMachine();
    }

    @Test
    public void add_Currency_Successfully(){
        int deposit = 450;
        int expected = 450;
        int result;

        vendingMachine.addCurrency(deposit);
        result = vendingMachine.getBalance();

        Assert.assertEquals(expected,result);

    }

    @Test
    public void add_Currency_Unsuccessfully(){
        int deposit = -15;
        int expected = 0;
        int result;

        vendingMachine.addCurrency(deposit);
        result = vendingMachine.getBalance();

        Assert.assertEquals(expected,result);
    }

    @Test
    public void request_Successfully(){
        int productNumber = 5;
        vendingMachine.addCurrency(100);
        int expectedChange = 70;
        int result;
        String name = "Fanta";

        Product product = vendingMachine.request(productNumber);
        result = vendingMachine.getBalance();

        Assert.assertEquals(expectedChange,result);
        Assert.assertEquals(name,product.getName());
    }

    @Test
    public void request_Without_Enough_Money_Unsuccessfully(){
        int productNumber = 5;
        vendingMachine.addCurrency(1);
        int expectedChange = 1;
        int result;

        Product product = vendingMachine.request(productNumber);
        result = vendingMachine.getBalance();

        Assert.assertEquals(expectedChange,result);
        Assert.assertNull(product);
    }

    @Test
    public void request_Unsuccessfully(){
        int productNumber = 12;

        Product product = vendingMachine.request(productNumber);

        Assert.assertNull(product);
    }

    @Test
    public void end_Session_Successfully(){
        int expectedPool = 0;
        int expectedChange = 100;
        int result;
        vendingMachine.addCurrency(100);
        result = vendingMachine.endSession();

        Assert.assertEquals(expectedPool,vendingMachine.getBalance());
        Assert.assertEquals(expectedChange, result);
    }

    @Test
    public void get_Description_Successfully(){
        int productNumber = 5;
        String expected = "Product number: 5\n" +
                "Product name: Fanta\n" +
                "Product price: 30\n" +
                "Product calories: 100\n" +
                "Product volume: 1.5L\n" +
                "Product bottle type: Plastic bottle";
        String result;

        result = vendingMachine.getDescription(productNumber);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void get_Description_Unsuccessfully(){
        int productNumber = 12;
        String expected = "Your input is invalid product number!";
        String result;
        result = vendingMachine.getDescription(productNumber);
        Assert.assertEquals(expected,result);
    }

    @Test
    public void get_Balance_Successfully(){
        int expected = 100;
        int result;

        vendingMachine.addCurrency(100);
        result = vendingMachine.getBalance();

        Assert.assertEquals(expected,result);
    }

    @Test
    public void get_Products_Successfully(){
        int expected = 9;
        String expectedString = "3. Margarita";
        int result;
        String resultString;

        result = vendingMachine.getProducts().length;
        resultString = vendingMachine.getProducts()[2];

        Assert.assertEquals(expected,result);
        Assert.assertEquals(expectedString,resultString);
    }

    @Test
    public void get_Use_Successfully(){
        int productNumber = 5;
        String expected = "Some how you managed to down the whole 1.5L bottle and no bathroom for 20km distance.";
        String result;

        result = vendingMachine.getUse(productNumber);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void get_Use_Unsuccessfully(){
        int productNumber = 12;
        String expected = "Buy something first!";
        String result;
        result = vendingMachine.getUse(productNumber);
        Assert.assertEquals(expected,result);
    }

}
