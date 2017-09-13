import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UncleBobBowlingGameTest {
    private UncleBobBowlingGame game;

    private static final int MAX_ROLL_NUMBER = 20;
    private static final int A_ROLL_NUMBER = 17;
    private static final int A_PERFECT_GAME_ROLL_NUMBER = 12;
    private static final int ANOTHER_ROLL_NUMBER = 16;
    private static final int ZERO_PINS_ROLL = 0;
    private static final int ONE_PINS_ROLL = 1;
    private static final int A_PINS_ROLL = 3;
    private static final int ANOTHER_PINS_ROLL = 6;
    private static final int SPARE_PINS_ROLL = 4;
    private static final int A_PERFECT_PINS_ROLL = 10;
    private static final int AN_EXPECTED_SCORE = 16;
    private static final int ANOTHER_EXPECTED_SCORE = 28;
    private static final int A_ZERO_GAME_SCORE = 0;
    private static final int A_ONE_GAME_SCORE = 20;
    private static final int A_PERFECT_GAME_SCORE = 300;


    @Before
    public void setUp() {
        game = new UncleBobBowlingGame();
    }

    private void rollMany(int rollNumber, int pins) {
        for (int i = 0; i < rollNumber; i++) {
            game.roll(pins);
        }
    }

    private void rollSpare() {
        game.roll(ANOTHER_PINS_ROLL);
        game.roll(SPARE_PINS_ROLL);
    }

    private void rollStrike() {
        game.roll(A_PERFECT_PINS_ROLL);
    }

    @Test
    public void gutterGameShouldHaveZeroScore() {

        rollMany(MAX_ROLL_NUMBER, ZERO_PINS_ROLL);
        assertEquals(A_ZERO_GAME_SCORE, game.score());
    }

    @Test
    public void rollingAllOnesScoreShouldBeTwenty() {
        rollMany(MAX_ROLL_NUMBER, ONE_PINS_ROLL);
        assertEquals(A_ONE_GAME_SCORE, game.score());
    }

    @Test
    public void whenRollingASpareShouldCalculateTheBonusRoll() {
        rollSpare();
        game.roll(A_PINS_ROLL);
        rollMany(A_ROLL_NUMBER, ZERO_PINS_ROLL);
        assertEquals(AN_EXPECTED_SCORE, game.score());
    }

    @Test
    public void whenRollingAStrikeShouldCalculateTheTwoBonusRoll() {
        rollStrike();
        game.roll(A_PINS_ROLL);
        game.roll(ANOTHER_PINS_ROLL);
        rollMany(ANOTHER_ROLL_NUMBER, ZERO_PINS_ROLL);
        assertEquals(ANOTHER_EXPECTED_SCORE, game.score());
    }

    @Test
    public void whenRollingAPerfectGameScoreShouldBe300() {
        rollMany(A_PERFECT_GAME_ROLL_NUMBER, A_PERFECT_PINS_ROLL);
        assertEquals(A_PERFECT_GAME_SCORE, game.score());
    }


}
