package se.lexicon.robin.products;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SodaTest {

    Soda soda;
    Soda soda2;
    Soda soda3;

    @Before
    public void before(){
        soda = new Soda(1,20,"Coca Cola", 120,"33cl","Aluminium can");
        soda2 = new Soda(2,20,"Coca Cola", 120,"25cl","Glass bottle");
        soda3 = new Soda(3,20,"Coca Cola", 120,"1.5L","Plastic bottle");
    }

    @Test
    public void examine_Successfully(){
        String expected = "Product number: 1\n" +
                "Product name: Coca Cola\n" +
                "Product price: 20\n" +
                "Product calories: 120\n" +
                "Product volume: 33cl\n" +
                "Product bottle type: Aluminium can";
        String result;

        result = soda.examine();

        Assert.assertEquals(expected,result);
    }

    @Test
    public void use_Big_Successfully(){
        String expectedBig = "Some how you managed to down the whole 1.5L bottle and no bathroom for 20km distance.";
        String resultBig;

        resultBig = soda3.use();

        Assert.assertEquals(expectedBig,resultBig);
    }

    @Test
    public void use_Medium_Successfully(){
        String expectedMedium = "You finished of the 33cl can and enjoy the refreshing sensation it had on you.";
        String resultMedium;

        resultMedium = soda.use();

        Assert.assertEquals(expectedMedium,resultMedium);
    }

    @Test
    public void use_Small_Successfully(){
        String expectedSmall = "You drop the glass bottle and it shatters spilling the soda on the ground.";
        String resultSmall;

        resultSmall = soda2.use();

        Assert.assertEquals(expectedSmall,resultSmall);
    }
}
