package se.lexicon.robin.products;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductSequencerTest {

   @Before
   public void before(){
       ProductSequencer.reset();
   }
    @Test
    public void product_Sequencer_Successfully(){
        int expected = 1;
        int result;

        result = ProductSequencer.nextProductNumber();

        Assert.assertEquals(expected,result);
    }

    @Test
    public void reset_Successfully(){
       int expected = 0;
       int result;

       ProductSequencer.nextProductNumber();
       ProductSequencer.reset();
       result = ProductSequencer.getProductNumber();

       Assert.assertEquals(expected,result);
    }

}
