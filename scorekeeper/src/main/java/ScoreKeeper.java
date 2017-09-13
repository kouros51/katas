public class ScoreKeeper {

    private int teamAScore = 0;
    private int teamBScore = 0;

    public static final int SCORE_BOUNDARY = 999;
    public static final int ONE_POINT = 1;
    public static final int TWO_POINTS = 2;
    public static final int THREE_POINTS = 3;
    public static final char TEAM_A = 'A';
    public static final char TEAM_B = 'B';

    public void scoreTeamA1() {
        scoreTeam(TEAM_A, ONE_POINT);
    }

    public void scoreTeamA2() {
        scoreTeam(TEAM_A, TWO_POINTS);
    }

    public void scoreTeamA3() {
        scoreTeam(TEAM_A, THREE_POINTS);
    }

    public void scoreTeamB1() {
        scoreTeam(TEAM_B, ONE_POINT);
    }

    public void scoreTeamB2() {
        scoreTeam(TEAM_B, TWO_POINTS);
    }

    public void scoreTeamB3() {
        scoreTeam(TEAM_B, THREE_POINTS);
    }

    private void scoreTeam(char team, int points) {
        if (team == TEAM_A) {
            checkScoreBoundary(teamAScore);
            teamAScore += points;
        } else if (team == TEAM_B) {
            checkScoreBoundary(teamBScore);
            teamBScore += points;
        }

    }

    private void checkScoreBoundary(int teamScore) {
        if (teamScore >= SCORE_BOUNDARY) {
            throw new OutOfBoundaryScoreException();
        }
    }

    public String getScore() {
        return String.format("%03d:%03d", teamAScore, teamBScore);
    }

    public int getTeamAScore() {
        return teamAScore;
    }

    public int getTeamBScore() {
        return teamBScore;
    }
}
