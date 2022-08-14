import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MainTest {
    @Test
    public void TestEquals() {
        assertEquals("hello", "hello");
    }

    @Test
    public void TestNotEquals() {
        assertNotEquals("hellxo", "hello");
    }
}
