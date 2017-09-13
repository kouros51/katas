import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreKeeperTest {

    private ScoreKeeper scoreKeeper;

    private static final String INITIAL_BOARD_SCORE = "000:000";
    private static final String A_BOARD_SCORE = "001:000";
    private static final String ANOTHER_BOARD_SCORE = "002:000";
    private static final String GAME_BOARD_SCORE = "014:012";
    private static final int INITIAL_TEAM_SCORE = 0;
    private static final int SCORE_STRING_LENGTH = 7;
    private static final int ONE_POINT_SCORE = 1;
    private static final int TWO_POINT_SCORE = 2;
    private static final int THREE_POINT_SCORE = 3;
    private static final int FIVE_POINTS_SCORE = 5;


    @Before
    public void initializintcoreKeeper() {
        scoreKeeper = new ScoreKeeper();
    }

    @Test
    public void initializedScoreShouldBeZero() {
        assertEquals(INITIAL_BOARD_SCORE, scoreKeeper.getScore());
    }

    @Test
    public void initializedTeamAScoreShouldBeZero() {
        assertEquals(INITIAL_TEAM_SCORE, scoreKeeper.getTeamAScore());
    }

    @Test
    public void initializedTeamBScoreShouldBeZero() {
        assertEquals(INITIAL_TEAM_SCORE, scoreKeeper.getTeamBScore());
    }

    @Test
    public void whenScoreIsReturnedShouldBeASevenCharacter() {
        String actualScore = scoreKeeper.getScore();
        int actualScoreStringLength = actualScore.length();

        assertEquals(SCORE_STRING_LENGTH, actualScoreStringLength);
    }

    @Test
    public void whenTeamAScoreOnePointThenTeamAScoreIncreaseByOne() {
        scoreKeeper.scoreTeamA1();

        assertEquals(ONE_POINT_SCORE, scoreKeeper.getTeamAScore());
    }

    @Test
    public void whenTeamAScoreOnePointThenGameScoreShouldBeFormattedAccordingly() {
        scoreKeeper.scoreTeamA1();

        assertEquals(A_BOARD_SCORE, scoreKeeper.getScore());
    }

    @Test
    public void givenAScoreWhenTeamAScoreOnePointThenTeamAScoreIncreaseByOne() {
        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamA1();

        assertEquals(TWO_POINT_SCORE, scoreKeeper.getTeamAScore());
    }

    @Test
    public void givenAScoreWhenTeamAScoreOnePointThenGameScoreShouldBeFormattedAccordingly() {
        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamA1();
        assertEquals(ANOTHER_BOARD_SCORE, scoreKeeper.getScore());
    }

    @Test
    public void whenTeamAScoreTwoPointsThenTeamAScoreIncreaseByTwo() {
        scoreKeeper.scoreTeamA2();

        assertEquals(TWO_POINT_SCORE, scoreKeeper.getTeamAScore());
    }

    @Test
    public void givenAScoreWhenTeamAScoreTwoPointThenTeamAScoreIncreaseByTwo() {
        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamA2();

        assertEquals(THREE_POINT_SCORE, scoreKeeper.getTeamAScore());
    }

    @Test
    public void whenTeamAScoreThreePointsThenTeamAScoreIncreaseByThree() {
        scoreKeeper.scoreTeamA3();

        assertEquals(THREE_POINT_SCORE, scoreKeeper.getTeamAScore());
    }

    @Test
    public void givenAScoreWhenTeamAScoreThreePointsThenTeamAScoreIncreaseByThree() {
        scoreKeeper.scoreTeamA2();
        scoreKeeper.scoreTeamA3();

        assertEquals(FIVE_POINTS_SCORE, scoreKeeper.getTeamAScore());
    }


    @Test
    public void whenTeamBScoreOnePointThenTeamBScoreIncreaseByOne() {
        scoreKeeper.scoreTeamB1();

        assertEquals(ONE_POINT_SCORE, scoreKeeper.getTeamBScore());
    }

    @Test
    public void givenAScoreWhenTeamBScoreOnePointThenTeamBScoreIncreaseByOne() {
        scoreKeeper.scoreTeamB1();
        scoreKeeper.scoreTeamB1();

        assertEquals(TWO_POINT_SCORE, scoreKeeper.getTeamBScore());
    }

    @Test
    public void whenTeamBScoreTwoPointsThenTeamBScoreIncreaseByTwo() {
        scoreKeeper.scoreTeamB2();

        assertEquals(TWO_POINT_SCORE, scoreKeeper.getTeamBScore());
    }

    @Test
    public void givenAScoreWhenTeamBScoreTwoPointThenTeamBScoreIncreaseByTwo() {
        scoreKeeper.scoreTeamB1();
        scoreKeeper.scoreTeamB2();

        assertEquals(THREE_POINT_SCORE, scoreKeeper.getTeamBScore());
    }

    @Test
    public void whenTeamBScoreThreePointsThenTeamBScoreIncreaseByThree() {
        scoreKeeper.scoreTeamB3();

        assertEquals(THREE_POINT_SCORE, scoreKeeper.getTeamBScore());
    }

    @Test
    public void givenAScoreWhenTeamBScoreThreePointsThenTeamBScoreIncreaseByThree() {
        scoreKeeper.scoreTeamB2();
        scoreKeeper.scoreTeamB3();

        assertEquals(FIVE_POINTS_SCORE, scoreKeeper.getTeamBScore());
    }

    @Test
    public void givenARandomGameWhenPointsScoredThenBoardScoreShouldCalculateAllPoints() {

        scoreKeeper.scoreTeamA2();
        scoreKeeper.scoreTeamB2();
        scoreKeeper.scoreTeamA2();
        scoreKeeper.scoreTeamA2();
        scoreKeeper.scoreTeamB3();
        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamB3();
        scoreKeeper.scoreTeamB2();
        scoreKeeper.scoreTeamB1();
        scoreKeeper.scoreTeamB1();
        scoreKeeper.scoreTeamA3();
        scoreKeeper.scoreTeamA2();

        assertEquals(GAME_BOARD_SCORE, scoreKeeper.getScore());
    }

    @Test(expected = OutOfBoundaryScoreException.class)
    public void whenTeamAScoreMoreThan999PointsAreScoredShouldThrowAnException() {
        for (int i = 0; i < 501; i++) {
            scoreKeeper.scoreTeamA2();
        }
    }

    @Test(expected = OutOfBoundaryScoreException.class)
    public void whenTeamBScoreMoreThan999PointsAreScoredShouldThrowAnException() {
        for (int i = 0; i < 501; i++) {
            scoreKeeper.scoreTeamB2();
        }
    }
}
