import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTest {

    @Test
    public void shouldLoseHealthIfAttacked() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(20, 10);

        axe.attack(dummy);
        Assert.assertEquals(10, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionIfAttacked() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(20, 10);

        axe.attack(dummy);
        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test
    public void deadDummyXP() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(20, 10);

        axe.attack(dummy);
        axe.attack(dummy);

        int actual = dummy.giveExperience();
        Assert.assertEquals(10, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyXP() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(20, 10);

        axe.attack(dummy);

        dummy.giveExperience();
    }
}
