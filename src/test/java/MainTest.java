import org.junit.Test;
import java.util.Set;
import static org.junit.Assert.*;

public class MainTest {
    Set<String> noiseWordsSet = MatchFinder.createNoiseWordsSet("noise.txt");

    @Test
    public void TestEquals() {
        assertTrue(MatchFinder.isMatch(
                MatchFinder.createNameSet("Osama to the Laden", noiseWordsSet),
                MatchFinder.createNameSet("Osama Bin Laden,", noiseWordsSet)));
    }

    @Test
    public void TestNotEquals() {
        assertFalse(MatchFinder.isMatch(
                MatchFinder.createNameSet("Oscarto", noiseWordsSet),
                MatchFinder.createNameSet("Oscar", noiseWordsSet)));
    }
}
