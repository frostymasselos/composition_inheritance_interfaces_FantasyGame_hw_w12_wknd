package characterTypesTest.magiTest;

import characterTypes.magi.Wizard;
import characterTypes.magi.WizardType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    private Wizard wizard;

    @Before
    public void before () {
        wizard = new Wizard(WizardType.GANDALF);
    }

    @Test
    public void canGetName () {
        assertEquals("Gandalf", wizard.getName());
    }

    @Test
    public void canGetCreature () {
        assertEquals("Dragon", wizard.getCreature().getName());
    }

    @Test
    public void canGetSpell () {
        assertEquals("Lightning Strike", wizard.getWeapon().getName());
    }

    @Test
    public void dragonWillSustainDamageWhenDragonIsAlive () {
        wizard.sustainAttack(20);
        assertEquals(105, wizard.getCreature().getHealth());
        assertEquals(700, wizard.getHealth());
    }

    @Test
    public void wizardWillNotTakeDamageWhenDragonTakesOverwhelmingAMount () {
        wizard.sustainAttack(200);
        assertEquals(0, wizard.getCreature().getHealth());
        assertEquals(false, wizard.getCreature().checkIfAlive());
        assertEquals(700, wizard.getHealth());
    }

    @Test
    public void wizardWillTakeDamageWhenDragonIsDead () {
        wizard.sustainAttack(200);
        wizard.sustainAttack(200);
        assertEquals(0, wizard.getCreature().getHealth());
        assertEquals(false, wizard.getCreature().checkIfAlive());
        assertEquals(500, wizard.getHealth());
    }
}
