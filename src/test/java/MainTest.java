import org.junit.BeforeClass;
import org.junit.Test;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class MainTest {
    @BeforeClass
    public static void start() {
        MatchFinder.noiseWordsSet = new TreeSet<>();
        MatchFinder.noiseWordsSet.add("to");
        MatchFinder.noiseWordsSet.add("the");
    }

    @Test
    public void TestEquals() {
        assertTrue(MatchFinder.isMatch(
                MatchFinder.createNameSet("Osama to the Laden"),
                MatchFinder.createNameSet("Osama Bin Laden,"), false)
        );

        assertTrue(MatchFinder.isMatch(
                MatchFinder.createNameSet("Osama to the"),
                MatchFinder.createNameSet("Osama"), false)
        );

        assertTrue(MatchFinder.isMatch(
                MatchFinder.createNameSet("Oscara"),
                MatchFinder.createNameSet("Oscar"), true)
        );
    }

    @Test
    public void TestNotEquals() {
        assertFalse(MatchFinder.isMatch(
                MatchFinder.createNameSet("Oscarto"),
                MatchFinder.createNameSet("Oscar"), false)
        );

        assertFalse(MatchFinder.isMatch(
                MatchFinder.createNameSet("Oscar T"),
                MatchFinder.createNameSet("Oscar"), false)
        );

        assertFalse(MatchFinder.isMatch(
                MatchFinder.createNameSet("Oscara"),
                MatchFinder.createNameSet("Oscar"), false)
        );
    }
}
