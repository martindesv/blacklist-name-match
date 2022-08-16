import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void TestEquals() {
        assertTrue(Main.isMatch(
                Main.createNameSet("mary tree"),
                Main.createNameSet("MarY tree")));

        assertTrue(Main.isMatch(
                Main.createNameSet("Oscar"),
                Main.createNameSet("Oscar")));
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
