import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrameTest {

    private static final int NO_ROLL_LEFT = 0;
    private static final int TWO_ROLL_LEFT = 2;
    private static final int ONE_ROLL_LEFT = 1;
    private static final int A_ROLL = 5;
    private static final int A_ZERO_ROLL = 0;
    private static final int ANOTHER_ROLL = 3;
    private static final int A_ZERO_SCORE = 0;

    private Frame frame;

    @Before
    public void setUpAFrameWithTwoRollLeft(){
        frame = new Frame();
    }

    @Test
    public void initializedRollNumberShouldBeZero(){
        assertEquals(TWO_ROLL_LEFT,frame.getLeftRoll());
    }

    @Test
    public void whenRolledOnceThenLeftRollShouldBeOne(){
        frame.roll(5);
        assertEquals(ONE_ROLL_LEFT,frame.getLeftRoll());
    }

    @Test
    public void whenRolledTwiceThenLeftRollShouldBeZero(){
        frame.roll(A_ROLL);
        frame.roll(ANOTHER_ROLL);
        assertEquals(NO_ROLL_LEFT,frame.getLeftRoll());
    }

    @Test
    public void whenRolledTwiceAZerpThenFrameScoreShouldBeZero(){
        frame.roll(A_ZERO_ROLL);
        frame.roll(A_ZERO_ROLL);
        assertEquals(A_ZERO_SCORE,frame.frameScore());
    }

    @Test
    public void whenRolledTwiceThenFrameScoreShouldBeTheSumOfTheRolls(){
        frame.roll(A_ROLL);
        frame.roll(ANOTHER_ROLL);
        assertEquals(A_ROLL+ANOTHER_ROLL,frame.frameScore());
    }





}
