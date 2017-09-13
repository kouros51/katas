import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    private static int SOME_NUMBER=14;
    private static int NUMBER_3_MULTIPLE=9;
    private static String FIZZ= "fizz";
    private static int NUMBER_5_MULTIPLE=10;
    private static String BUZZ= "buzz";
    private static int NUMBER_3_5_MULTIPLE=15;
    private static String FIZZBUZZ= "fizzbuzz";
    private static int SOME_NEGATIVE_NUMBER=-3;
    private static final int SOME_BIG_NUMBER = 1234;


    @Before
    public void setUp(){
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void GivenNumberWhenTranslatedShouldReturnItself() {
        assertEquals(Integer.toString(SOME_NUMBER),fizzBuzz.translate(SOME_NUMBER));
    }

    @Test
    public void GivenNumberMultipleOf3WhenTranslatedShouldReturnFizz() {
        assertEquals(FIZZ,fizzBuzz.translate(NUMBER_3_MULTIPLE));
    }

    @Test
    public void GivenNumberMultipleOf5WhenTranslatedShouldReturnFizz() {
        assertEquals(BUZZ,fizzBuzz.translate(NUMBER_5_MULTIPLE));
    }

    @Test
    public void GivenNumberMultipleOf3And5WhenTranslatedShouldReturnFizzBuzz(){
        assertEquals(FIZZBUZZ,fizzBuzz.translate(NUMBER_3_5_MULTIPLE));
    }

    @Test(expected = OutOfReachException.class)
    public void GivenANegativeNumberShouldRaiseAnException() throws OutOfReachException {
       fizzBuzz.verifyReach(SOME_NEGATIVE_NUMBER);
    }
    @Test(expected = OutOfReachException.class)
    public void GivenANumberGreaterThan100ShouldRaiseAnException() throws OutOfReachException {
        fizzBuzz.verifyReach(SOME_BIG_NUMBER);
    }


}
