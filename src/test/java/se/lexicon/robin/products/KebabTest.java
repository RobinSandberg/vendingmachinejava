package se.lexicon.robin.products;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KebabTest {

    Kebab kebab;
    Kebab kebab2;
    Kebab kebab3;

    @Before
    public void before(){
        kebab = new Kebab(1,30,"Kebab roll",250,"Hot sauce");
        kebab2 = new Kebab(2,30,"Kebab roll",250,"Mild sauce");
        kebab3 = new Kebab(3,30,"Kebab roll",250,"Weak sauce");
    }

    @Test
    public void examine_Successfully(){
        String expected = "Product number: 1\n" +
                "Product name: Kebab roll\n" +
                "Product price: 30\n" +
                "Product calories: 250\n" +
                "Product sauce: Hot sauce";
        String result;

        result = kebab.examine();

        Assert.assertEquals(expected,result);

    }

    @Test
    public void use_Hot_Successfully() {
        String expectedHot = "You pushed the wrong button and accidental got hot sauce and your mouth is on fire.";
        String resultHot;

        resultHot = kebab.use();

        Assert.assertEquals(expectedHot,resultHot);
    }

    @Test
    public void use_Mild_Successfully() {
        String expectedMild = "You enjoy your meal and laugh at your friend who accidental got hot sauce and now crying in pain.";
        String resultMild;

        resultMild = kebab2.use();

        Assert.assertEquals(expectedMild,resultMild);
    }

    @Test
    public void use_Weak_Successfully() {
        String expectedWeak = "Your friend brought you the wrong sauce and you eat it disappointed.";
        String resultWeak;

        resultWeak = kebab3.use();

        Assert.assertEquals(expectedWeak,resultWeak);
    }
}
