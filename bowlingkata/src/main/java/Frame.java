public class Frame {

    private int leftRoll=2;
    private int currentRoll=0;
    private int rolls[] = new int[2];
    public int getLeftRoll() {
        return leftRoll;
    }

    public void roll(int pins) {
        rolls[currentRoll]= pins;
        leftRoll--;
        currentRoll++;
    }

    public int frameScore() {
        int score =0;
        for (int roll=0;roll<rolls.length; roll++){
            score+=rolls[roll];
        }
        return score;
    }

}
