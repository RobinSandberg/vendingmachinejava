package se.lexicon.robin.products;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PizzaTest {

    Pizza pizza;
    Pizza pizza2;
    Pizza pizza3;

    @Before
    public void before(){
        pizza = new Pizza(1,35,"Magarita",300,"Medium","Cheese , Tomato sauce");
        pizza2 = new Pizza(2,40,"Vesuvio",350, "Small", "Cheese , Tomato sauce , Ham");
        pizza3 = new Pizza(3,40,"Vesuvio",450, "Large", "Cheese , Tomato sauce , Ham");
    }

    @Test
    public void examine_Successfully(){
        String expected = "Product number: 1\n" +
                "Product name: Magarita\n" +
                "Product price: 35\n" +
                "Product calories: 300\n" +
                "Product size: Medium\n" +
                "Product toppings: Cheese , Tomato sauce";
        String result;

        result = pizza.examine();

        Assert.assertEquals(expected,result);
    }

    @Test
    public void use_Large_Successfully(){
        String expectedLarge = "You eat the whole large pizza and need a nap.";
        String resultLarge;

        resultLarge = pizza3.use();

        Assert.assertEquals(expectedLarge,resultLarge);
    }

    @Test
    public void use_Medium_Successfully(){
        String expectedMedium = "You finished of a medium pizza and ready for the party.";
        String resultMedium;

        resultMedium = pizza.use();

        Assert.assertEquals(expectedMedium,resultMedium);
    }

    @Test
    public void use_Small_Successfully(){
        String expectedSmall = "You ate the whole small pizza  you sure you don't want more?";
        String resultSmall;

        resultSmall = pizza2.use();

        Assert.assertEquals(expectedSmall, resultSmall);
    }
}
