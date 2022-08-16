import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void TestEquals() {
        assertTrue(Main.isMatch(
                Main.createNameSet("Osama Laden"),
                Main.createNameSet("Osama Bin Laden")));

        assertTrue(Main.isMatch(
                Main.createNameSet("Bin Laden, Osama"),
                Main.createNameSet("osama Bin LADEN")));

        assertTrue(Main.isMatch(
                Main.createNameSet("Laden Osama Bin"),
                Main.createNameSet("Osama Bin")));

        assertTrue(Main.isMatch(
                Main.createNameSet("Oscar"),
                Main.createNameSet("oscar")));
    }

    @Test
    public void TestNotEquals() {
        assertFalse(Main.isMatch(
                Main.createNameSet("Oscar"),
                Main.createNameSet("Oscarx")));

        assertFalse(Main.isMatch(
                Main.createNameSet("Osama Bin Laden"),
                Main.createNameSet("Osama binn lada")));
    }
}
