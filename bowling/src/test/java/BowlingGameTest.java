import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private Game game;

    @Before
    public void setUpInitializedZeroGame() {
        game = new Game();
    }

    @Test
    public void initializedGameShouldHaveTenFrame() {
        int actualScore = game.getFrameNumber();
        int expectedScore = 10;
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void rollingZeroPinsShouldHaveAScoreOfZeo() {
        for (int i = 1; i <=10; i++) {
            Frame frame = game.getFrame();
        }
    }
}
