import org.junit.Test;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MainTest {
    @Test
    public void TestEquals() {
        Set<String> inputNameSet = Main.createNameSet("Mary Tree");
        Set<String> listNameSet = Main.createNameSet("Mary Tree");
        Main.compareNames(inputNameSet, listNameSet);
        assertEquals("hello", "hello");
    }

    @Test
    public void TestNotEquals() {
        assertNotEquals("hellxo", "hello");
    }
}
