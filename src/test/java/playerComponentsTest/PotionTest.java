package playerComponentsTest;

import org.junit.Before;
import org.junit.Test;
import playerComponents.revivalTool.Potion;

import static org.junit.Assert.assertEquals;

public class PotionTest {
    private Potion potion;

    @Before
    public void before() {
        potion = new Potion("Potion");
    }

    @Test
    public void canGetName () {
        assertEquals("Potion", potion.getName());
    }

    @Test
    public void startsFilled () {
        assertEquals(true, potion.isFilled());
    }

    @Test
    public void canGetIsFull () {
        assertEquals(true, potion.isFull());
    }

    @Test
    public void doesNotSayFullWhenNotFull () {
        potion.pour(25);
        assertEquals(false, potion.isFull());
    }

    @Test
    public void canGetAmount () {
        assertEquals(45, potion.getAmount());
    }

    @Test
    public void canPour () {
        potion.pour(25);
        assertEquals(20, potion.getAmount());
    }

    @Test
    public void canGetHealth() {
        assertEquals(45, potion.getAmount());
    }

    @Test
    public void canLooseHealth() {
        potion.pour(20);
        assertEquals(25, potion.getAmount());
        assertEquals(true, potion.isFilled());
    }

}

