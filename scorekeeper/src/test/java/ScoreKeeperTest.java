import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreKeeperTest {
    private ScoreKeeper scoreKeeper;

    @Test
    public void initializedScoreShouldBeNull(){
        scoreKeeper = new ScoreKeeper();
        String expectedScore = "000:000";
        String actualScore = scoreKeeper.getScore();
        assertEquals(expectedScore,actualScore);
    }
}
