public class FizzBuzz {

    public String translate(int number) {
        StringBuilder translationResult;
        boolean multipleOfThree;
        boolean multipleOfFive;

        translationResult = new StringBuilder();
        multipleOfThree = isMultipleOf(number, 3);
        multipleOfFive = isMultipleOf(number, 5);

        if (multipleOfThree || multipleOfFive) {
            if (multipleOfThree) {
                translationResult.append("fizz");
            }
            if (multipleOfFive) {
                translationResult.append("buzz");
            }
        } else {
            translationResult.append(number);
        }

        return translationResult.toString();
    }

    private boolean isMultipleOf(int number, int multplier) {
        if (number % multplier == 0) {
            return true;
        }
        return false;
    }

    public boolean verifyReach(int number) throws OutOfReachException {
        if (number <= 0 || number > 100) {
            throw new OutOfReachException();
        }
        return false;
    }


}
